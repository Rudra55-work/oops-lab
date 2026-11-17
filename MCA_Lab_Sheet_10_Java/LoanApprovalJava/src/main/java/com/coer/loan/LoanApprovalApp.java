package com.coer.loan;

import weka.classifiers.Classifier;
import weka.classifiers.Evaluation;
import weka.classifiers.functions.Logistic;
import weka.classifiers.trees.J48;
import weka.classifiers.trees.RandomForest;
import weka.core.Attribute;
import weka.core.DenseInstance;
import weka.core.Instance;
import weka.core.Instances;
import weka.core.SerializationHelper;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.nio.file.*;
import java.util.*;

public class LoanApprovalApp {
    private static final String MODEL_FILE = "loan_approval_model.model";
    private static final String DATA_FILE = "loan_approval_data.arff";
    private static Instances structure;

    private static ArrayList<Attribute> makeAttributes() {
        ArrayList<Attribute> a = new ArrayList<>();
        a.add(new Attribute("income"));
        a.add(new Attribute("loan_amount"));
        a.add(new Attribute("credit_history"));
        a.add(new Attribute("education", new ArrayList<>(List.of("Graduate", "Not Graduate"))));
        a.add(new Attribute("employment", new ArrayList<>(List.of("Salaried", "Self Employed"))));
        a.add(new Attribute("marital_status", new ArrayList<>(List.of("Married", "Single"))));
        a.add(new Attribute("loan_status", new ArrayList<>(List.of("Not Approved", "Approved"))));
        return a;
    }

    private static Instances generateData(int n) throws Exception {
        Instances data = new Instances("LoanApproval", makeAttributes(), n);
        data.setClassIndex(data.numAttributes() - 1);
        Random r = new Random(42);
        for (int i = 0; i < n; i++) {
            double income = 15000 + r.nextInt(145001);
            double loan = 30000 + r.nextInt(570001);
            int credit = r.nextDouble() < 0.72 ? 1 : 0;
            int education = r.nextBoolean() ? 0 : 1;
            int employment = r.nextBoolean() ? 0 : 1;
            int married = r.nextBoolean() ? 0 : 1;

            double score = (income > 55000 ? 2 : 0) + 4 * credit
                    + (education == 0 ? 1 : 0)
                    + (loan < 280000 ? 2 : 0)
                    + (married == 0 ? 1 : 0)
                    + (employment == 0 ? 1 : 0);
            double p = 1.0 / (1.0 + Math.exp(-(score - 6.0)));
            int label = r.nextDouble() < p ? 1 : 0;

            double[] values = {income, loan, credit, education, employment, married, label};
            data.add(new DenseInstance(1.0, values));
        }
        return data;
    }

    private static void train() throws Exception {
        Instances data = generateData(2400);
        try (BufferedWriter writer = Files.newBufferedWriter(Path.of(DATA_FILE))) {
            writer.write(data.toString());
        }

        data.randomize(new Random(42));
        int trainSize = (int) Math.round(data.numInstances() * 0.8);
        Instances train = new Instances(data, 0, trainSize);
        Instances test = new Instances(data, trainSize, data.numInstances() - trainSize);

        Map<String, Classifier> candidates = new LinkedHashMap<>();
        Logistic logistic = new Logistic();
        J48 tree = new J48();
        RandomForest forest = new RandomForest();
        forest.setNumIterations(150);
        candidates.put("Logistic Regression", logistic);
        candidates.put("Decision Tree (J48)", tree);
        candidates.put("Random Forest", forest);

        double bestAccuracy = -1;
        Classifier best = null;
        String bestName = "";
        StringBuilder report = new StringBuilder("MODEL EVALUATION\n\n");

        for (Map.Entry<String, Classifier> entry : candidates.entrySet()) {
            Classifier model = entry.getValue();
            model.buildClassifier(train);
            Evaluation evaluation = new Evaluation(train);
            evaluation.evaluateModel(model, test);
            double accuracy = evaluation.pctCorrect();
            report.append(entry.getKey()).append("\n")
                  .append(String.format(Locale.US, "Accuracy: %.2f%%\n", accuracy))
                  .append("Weighted F1: ").append(String.format(Locale.US, "%.4f", evaluation.weightedFMeasure()))
                  .append("\n\n");
            System.out.println(entry.getKey() + " accuracy: " + String.format(Locale.US, "%.2f%%", accuracy));
            if (accuracy > bestAccuracy) {
                bestAccuracy = accuracy;
                best = model;
                bestName = entry.getKey();
            }
        }

        SerializationHelper.write(MODEL_FILE, best);
        report.append("Best model: ").append(bestName).append("\n");
        report.append("Best accuracy: ").append(String.format(Locale.US, "%.2f%%", bestAccuracy)).append("\n");
        Files.writeString(Path.of("loan_model_evaluation.txt"), report.toString());
        structure = new Instances(data, 0);
        System.out.println("Saved model to " + MODEL_FILE);
        System.out.println(report);
    }

    private static Instance makeApplicant(double income, double loan, int credit,
                                          String education, String employment, String marital) {
        Instance instance = new DenseInstance(structure.numAttributes());
        instance.setDataset(structure);
        instance.setValue(structure.attribute("income"), income);
        instance.setValue(structure.attribute("loan_amount"), loan);
        instance.setValue(structure.attribute("credit_history"), credit);
        instance.setValue(structure.attribute("education"), education);
        instance.setValue(structure.attribute("employment"), employment);
        instance.setValue(structure.attribute("marital_status"), marital);
        instance.setMissing(structure.classIndex());
        return instance;
    }

    private static void launchUI() throws Exception {
        Classifier model = (Classifier) SerializationHelper.read(MODEL_FILE);
        JFrame frame = new JFrame("Loan Approval Prediction System");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(480, 430);
        frame.setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridLayout(0, 2, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(18, 18, 18, 18));

        JTextField income = new JTextField("50000");
        JTextField loan = new JTextField("200000");
        JComboBox<String> credit = new JComboBox<>(new String[]{"Good (1)", "Poor (0)"});
        JComboBox<String> education = new JComboBox<>(new String[]{"Graduate", "Not Graduate"});
        JComboBox<String> employment = new JComboBox<>(new String[]{"Salaried", "Self Employed"});
        JComboBox<String> marital = new JComboBox<>(new String[]{"Married", "Single"});
        JButton predict = new JButton("Predict Loan Status");
        JLabel result = new JLabel("Enter details and click Predict.");

        panel.add(new JLabel("Monthly income (₹):")); panel.add(income);
        panel.add(new JLabel("Loan amount (₹):")); panel.add(loan);
        panel.add(new JLabel("Credit history:")); panel.add(credit);
        panel.add(new JLabel("Education:")); panel.add(education);
        panel.add(new JLabel("Employment:")); panel.add(employment);
        panel.add(new JLabel("Marital status:")); panel.add(marital);
        panel.add(predict); panel.add(result);

        predict.addActionListener(e -> {
            try {
                Instance applicant = makeApplicant(
                        Double.parseDouble(income.getText().trim()),
                        Double.parseDouble(loan.getText().trim()),
                        credit.getSelectedIndex() == 0 ? 1 : 0,
                        (String) education.getSelectedItem(),
                        (String) employment.getSelectedItem(),
                        (String) marital.getSelectedItem()
                );
                double prediction = model.classifyInstance(applicant);
                String label = structure.classAttribute().value((int) prediction);
                result.setText("Prediction: " + label);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(frame, "Please enter valid numeric values.");
            }
        });

        frame.add(panel);
        frame.setVisible(true);
    }

    public static void main(String[] args) throws Exception {
        if (!Files.exists(Path.of(MODEL_FILE))) {
            System.out.println("Training models...");
            train();
        }
        Instances loadedData = generateData(1);
        structure = new Instances(loadedData, 0);
        launchUI();
    }
}

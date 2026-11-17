package com.coer.disease;

import weka.classifiers.Classifier;
import weka.classifiers.Evaluation;
import weka.classifiers.functions.Logistic;
import weka.classifiers.lazy.IBk;
import weka.classifiers.trees.J48;
import weka.classifiers.trees.RandomForest;
import weka.core.Attribute;
import weka.core.DenseInstance;
import weka.core.Instance;
import weka.core.Instances;
import weka.core.SerializationHelper;

import javax.swing.*;
import java.awt.*;
import java.nio.file.*;
import java.util.*;

public class DiseasePredictionApp {
    private static final String MODEL_FILE = "disease_prediction_model.model";
    private static final String DATA_FILE = "disease_data.arff";
    private static Instances structure;

    private static final String[] SYMPTOMS = {
            "fever", "cough", "fatigue", "headache",
            "nausea", "vomiting", "diarrhea", "rash"
    };

    private static final String[] DISEASES = {
            "Common Cold", "Influenza", "Allergy", "Gastroenteritis", "Migraine"
    };

    private static final double[][] PROFILES = {
            {0.55, 0.85, 0.55, 0.40, 0.10, 0.05, 0.05, 0.08},
            {0.90, 0.70, 0.90, 0.70, 0.25, 0.15, 0.10, 0.05},
            {0.08, 0.75, 0.25, 0.20, 0.05, 0.02, 0.02, 0.70},
            {0.45, 0.10, 0.55, 0.20, 0.80, 0.70, 0.75, 0.05},
            {0.08, 0.05, 0.45, 0.90, 0.35, 0.12, 0.05, 0.03}
    };

    private static ArrayList<Attribute> attributes() {
        ArrayList<Attribute> a = new ArrayList<>();
        for (String s : SYMPTOMS) a.add(new Attribute(s));
        a.add(new Attribute("age"));
        a.add(new Attribute("temperature"));
        a.add(new Attribute("disease", new ArrayList<>(Arrays.asList(DISEASES))));
        return a;
    }

    private static Instances generateData(int perClass) {
        Instances data = new Instances("DiseaseDemo", attributes(), perClass * DISEASES.length);
        data.setClassIndex(data.numAttributes() - 1);
        Random r = new Random(24);
        for (int c = 0; c < DISEASES.length; c++) {
            for (int i = 0; i < perClass; i++) {
                double[] values = new double[data.numAttributes()];
                for (int j = 0; j < SYMPTOMS.length; j++)
                    values[j] = r.nextDouble() < PROFILES[c][j] ? 1 : 0;
                values[8] = 1 + r.nextInt(89);
                values[9] = Math.max(34, Math.min(41,
                        (c == 1 ? 38.2 : 37.1) + r.nextGaussian() * 0.65));
                values[10] = c;
                data.add(new DenseInstance(1.0, values));
            }
        }
        return data;
    }

    private static void train() throws Exception {
        Instances data = generateData(500);
        Files.writeString(Path.of(DATA_FILE), data.toString());

        data.randomize(new Random(42));
        int trainSize = (int) Math.round(data.numInstances() * 0.8);
        Instances train = new Instances(data, 0, trainSize);
        Instances test = new Instances(data, trainSize, data.numInstances() - trainSize);

        Map<String, Classifier> candidates = new LinkedHashMap<>();
        candidates.put("Logistic Regression", new Logistic());
        candidates.put("Decision Tree (J48)", new J48());
        RandomForest rf = new RandomForest();
        rf.setNumIterations(150);
        candidates.put("Random Forest", rf);
        candidates.put("K-Nearest Neighbors", new IBk(7));

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
        report.append("Best model: ").append(bestName).append("\n")
              .append("Best accuracy: ").append(String.format(Locale.US, "%.2f%%", bestAccuracy));
        Files.writeString(Path.of("disease_model_evaluation.txt"), report.toString());
        structure = new Instances(data, 0);
        System.out.println(report);
        System.out.println("Saved model to " + MODEL_FILE);
    }

    private static void launchUI() throws Exception {
        Classifier model = (Classifier) SerializationHelper.read(MODEL_FILE);
        JFrame frame = new JFrame("Disease Prediction System - Academic Demo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(520, 590);
        frame.setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridLayout(0, 2, 8, 8));
        panel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));

        JSpinner age = new JSpinner(new SpinnerNumberModel(25, 1, 100, 1));
        JSpinner temperature = new JSpinner(new SpinnerNumberModel(37.0, 30.0, 45.0, 0.1));
        JComboBox<String>[] symptomBoxes = new JComboBox[SYMPTOMS.length];

        panel.add(new JLabel("Age:")); panel.add(age);
        panel.add(new JLabel("Temperature (°C):")); panel.add(temperature);

        for (int i = 0; i < SYMPTOMS.length; i++) {
            panel.add(new JLabel(SYMPTOMS[i].replace("_", " ") + ":"));
            symptomBoxes[i] = new JComboBox<>(new String[]{"No", "Yes"});
            panel.add(symptomBoxes[i]);
        }

        JButton predict = new JButton("Predict");
        JLabel result = new JLabel("Select symptoms and predict.");
        panel.add(predict); panel.add(result);

        predict.addActionListener(e -> {
            try {
                Instance input = new DenseInstance(structure.numAttributes());
                input.setDataset(structure);
                for (int i = 0; i < SYMPTOMS.length; i++)
                    input.setValue(i, symptomBoxes[i].getSelectedIndex());
                input.setValue(8, ((Number) age.getValue()).doubleValue());
                input.setValue(9, ((Number) temperature.getValue()).doubleValue());
                input.setMissing(structure.classIndex());

                double prediction = model.classifyInstance(input);
                String label = structure.classAttribute().value((int) prediction);
                result.setText("Model class: " + label);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(frame, "Prediction error: " + ex.getMessage());
            }
        });

        frame.add(panel);
        frame.setVisible(true);
        JOptionPane.showMessageDialog(frame,
                "Educational synthetic-data demo only. Not medically validated; do not use for diagnosis or treatment.",
                "Important notice", JOptionPane.WARNING_MESSAGE);
    }

    public static void main(String[] args) throws Exception {
        if (!Files.exists(Path.of(MODEL_FILE))) {
            System.out.println("Training models...");
            train();
        }
        structure = new Instances(generateData(1), 0);
        launchUI();
    }
}

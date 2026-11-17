# Lab Sheet 10 — Java Project Documentation

## Objective
Implement the two capstone ML projects using Java, Weka, and Swing. The workflows cover data generation, training/testing, algorithm comparison, evaluation, model serialization, and interactive predictions.

## Project 1: Loan Approval Prediction
**Problem:** Binary classification of an illustrative loan status from monthly income, requested loan amount, credit history, education, employment, and marital status.

**Algorithms compared:** Weka Logistic, J48 Decision Tree, and RandomForest.

**Workflow:** Generate ARFF data → randomize and split into training/testing sets → train classifiers → compare accuracy and weighted F1 → serialize the best model → load it in the Swing form.

## Project 2: Disease Prediction
**Problem:** Multi-class classification of generated symptom patterns into Common Cold, Influenza, Allergy, Gastroenteritis, or Migraine.

**Features:** Fever, cough, fatigue, headache, nausea, vomiting, diarrhea, rash, age, and temperature.

**Algorithms compared:** Logistic, J48, RandomForest, and IBk (K-nearest neighbors).

**Workflow:** Generate ARFF data → split data → train classifiers → compare accuracy and weighted F1 → serialize best model → load it in the Swing form.

## Architecture
User input (Swing) → Weka Instance → serialized Weka classifier → predicted class → result displayed in Swing.

Training: synthetic ARFF dataset → train/test split → candidate classifiers → Evaluation metrics → best model serialized.

## Testing checklist
- Install JDK 17 and Maven.
- Run `mvn compile exec:java` in each project folder.
- Confirm ARFF dataset and model file are generated.
- Confirm evaluation text file is created.
- Test several different inputs in each Swing form.
- Capture screenshots of model comparison output and app prediction.
- Add student name, roll number, guide name, and actual screenshots before submission.

## Limitations and ethics
The generated data are synthetic and use illustrative probability/rule profiles. Results do not establish performance on real applicants or patients. Do not use the loan application for actual lending decisions. The disease classifier is not a medical device or diagnostic tool.

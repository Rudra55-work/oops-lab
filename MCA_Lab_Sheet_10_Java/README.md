# MCA Lab Sheet 10 — Java Implementations

Both capstone projects are implemented in Java 17 using **Weka** for machine-learning algorithms and **Swing** for the desktop prediction interfaces.

## Requirements
- JDK 17 or newer
- Apache Maven 3.8+
- Internet access for Maven to download Weka on the first build

## Project 1: Loan Approval Prediction
```bash
cd LoanApprovalJava
mvn compile exec:java
```
The program generates a synthetic ARFF dataset, compares Logistic Regression, J48 Decision Tree and Random Forest, saves the best model as `loan_approval_model.model`, writes `loan_model_evaluation.txt`, and opens the Swing prediction form.

## Project 2: Disease Prediction
Open another terminal:
```bash
cd DiseasePredictionJava
mvn compile exec:java
```
The program generates a synthetic ARFF dataset, compares Logistic Regression, J48 Decision Tree, Random Forest and K-Nearest Neighbors, saves `disease_prediction_model.model`, writes `disease_model_evaluation.txt`, and opens the Swing form.

## Important
- These datasets are synthetically generated for coursework demonstrations.
- Loan predictions are not suitable for real lending decisions.
- The disease project is not medically validated and must not be used for diagnosis, treatment or triage.
- Evaluation values are produced by the program at runtime. Do not invent or claim specific real-world accuracy.

## Files
- `LoanApprovalJava/src/main/java/com/coer/loan/LoanApprovalApp.java`
- `DiseasePredictionJava/src/main/java/com/coer/disease/DiseasePredictionApp.java`
- Each project has its own Maven `pom.xml`.
- The `documentation` folder contains the report outline, flowcharts and viva questions.

import java.util.*;

class Learner {
    private int rollNo;
    private String name;
    private double marks;
    Learner(int rollNo, String name, double marks) {
        this.rollNo = rollNo; this.name = name; this.marks = marks;
    }
    public double getMarks() { return marks; }
    @Override public String toString() { return rollNo + " " + name + " " + marks; }
}

public class Q27ComparatorSort {
    public static void main(String[] args) {
        ArrayList<Learner> learners = new ArrayList<>();
        learners.add(new Learner(1, "Aarav", 78.5));
        learners.add(new Learner(2, "Diya", 91.0));
        learners.add(new Learner(3, "Kabir", 84.0));
        learners.sort(Comparator.comparingDouble(Learner::getMarks).reversed());
        learners.forEach(System.out::println);
    }
}

import java.util.ArrayList;
import java.util.Iterator;

class Student {
    private int rollNo;
    private String name;
    public Student(int rollNo, String name) { this.rollNo = rollNo; this.name = name; }
    public int getRollNo() { return rollNo; }
    public String getName() { return name; }
    @Override public String toString() { return rollNo + " - " + name; }
}

public class Q26StudentIterator {
    public static void main(String[] args) {
        ArrayList<Student> students = new ArrayList<>();
        students.add(new Student(1, "Aarav"));
        students.add(new Student(2, "Diya"));
        students.add(new Student(3, "Kabir"));
        Iterator<Student> it = students.iterator();
        while (it.hasNext()) System.out.println(it.next());
    }
}

import java.util.ArrayList;
public class Q06ArrayListForEach {
    public static void main(String[] args) {
        ArrayList<String> subjects = new ArrayList<>();
        subjects.add("Java"); subjects.add("Python"); subjects.add("DBMS");
        for (String subject : subjects) System.out.println(subject);
    }
}

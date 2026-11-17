public class StudentBean {
    private int id;
    private String name;
    private double grade;

    public StudentBean() {}
    public StudentBean(int id, String name, double grade) {
        this.id = id; this.name = name; this.grade = grade;
    }
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public double getGrade() { return grade; }
    public void setGrade(double grade) { this.grade = grade; }

    public static void main(String[] args) {
        StudentBean s = new StudentBean();
        s.setId(101); s.setName("Aarav"); s.setGrade(8.5);
        System.out.println("ID: " + s.getId() + ", Name: " + s.getName() + ", Grade: " + s.getGrade());
    }
}

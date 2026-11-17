import java.time.LocalDate;

public class DateBean {
    public DateBean() {}
    public LocalDate getCurrentDate() { return LocalDate.now(); } // read-only: no setter
    public static void main(String[] args) {
        System.out.println("Current date: " + new DateBean().getCurrentDate());
    }
}

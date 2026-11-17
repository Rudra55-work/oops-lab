public class CarBean {
    private String make, model;
    private int year;
    public CarBean() {}
    public String getMake() { return make; }
    public void setMake(String make) { this.make = make; }
    public String getModel() { return model; }
    public void setModel(String model) { this.model = model; }
    public int getYear() { return year; }
    public void setYear(int year) { this.year = year; }
    public static void main(String[] args) {
        CarBean car = new CarBean();
        car.setMake("Toyota"); car.setModel("Camry"); car.setYear(2024);
        System.out.println(car.getMake() + " " + car.getModel() + " (" + car.getYear() + ")");
    }
}

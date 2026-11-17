public class CircleBean {
    private double radius;
    public CircleBean() {}
    public double getRadius() { return radius; }
    public void setRadius(double radius) {
        if (radius < 0) throw new IllegalArgumentException("Radius cannot be negative");
        this.radius = radius;
    }
    public double getArea() { return Math.PI * radius * radius; } // read-only
    public double getCircumference() { return 2 * Math.PI * radius; } // read-only
    public static void main(String[] args) {
        CircleBean c = new CircleBean(); c.setRadius(7);
        System.out.printf("Area: %.2f%nCircumference: %.2f%n", c.getArea(), c.getCircumference());
    }
}

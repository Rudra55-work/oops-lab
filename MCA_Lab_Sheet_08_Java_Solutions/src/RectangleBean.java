public class RectangleBean {
    private double length, width;
    public RectangleBean() {}
    public RectangleBean(double length, double width) { this.length = length; this.width = width; }
    public double getLength() { return length; }
    public void setLength(double length) { this.length = length; }
    public double getWidth() { return width; }
    public void setWidth(double width) { this.width = width; }
    public double getArea() { return length * width; }
    public double getPerimeter() { return 2 * (length + width); }
    public static void main(String[] args) {
        RectangleBean r = new RectangleBean(10, 5);
        System.out.println("Area: " + r.getArea());
        System.out.println("Perimeter: " + r.getPerimeter());
    }
}

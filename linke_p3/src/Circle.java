public class Circle extends Shape2D {
    private String name = "circle";
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    public String getName(){
        return this.name;
    }

    @Override
    public double getArea() {
        return Math.PI * Math.pow(this.radius, 2);
    }
}

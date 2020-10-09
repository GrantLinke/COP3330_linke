public class Triangle extends Shape2D {
    private String name = "triangle";
    private double sideLength, height;

    public Triangle(double sideLength1, double height) {
        this.sideLength = sideLength1;
        this.height = height;
    }

    public String getName(){
        return this.name;
    }

    @Override
    public double getArea() {
        return 0.5 * (sideLength * height);
    }
}

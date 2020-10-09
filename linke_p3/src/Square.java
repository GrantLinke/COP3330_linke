public class Square extends Shape2D {
    private String name = "square";
    private double sideLength;

    public Square(double sideLength) {
        this.sideLength = sideLength;
    }
    public String getName(){
        return this.name;
    }

    @Override
    public double getArea() {
        return sideLength * sideLength;
    }
}

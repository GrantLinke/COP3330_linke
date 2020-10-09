public class Pyramid extends Shape3D {
    private String name = "pyramid";
    private double length;
    private double width;
    private double height;

    public Pyramid(double i, double i1, double i2) {
        this.length = i;
        this.width = i1;
        this.height = i2;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public double getArea() {
        return (length * width) + (length * Math.sqrt((Math.pow(width / 2, 2)) + Math.pow(height, 2))) +
                (width * Math.sqrt(Math.pow(length / 2 , 2) + Math.pow(height, 2)));
    }

    @Override
    public double getVolume() {
        return (length * width * height) / 3.0;
    }
}

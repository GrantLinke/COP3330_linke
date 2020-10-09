public class Cube extends Shape3D {
    private double length;
    private String name = "cube";

    public Cube(double length) {
        this.length = length;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public double getArea() {
        return 6 * (length * length);
    }

    @Override
    public double getVolume() {
        return Math.pow(length, 3);
    }
}

public class Sphere extends Shape3D {
    private String name = "sphere";
    private double radius;

    public Sphere(double v) {
        this.radius = v;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public double getArea() {
        return 4 * Math.PI * (radius * radius);
    }

    @Override
    public double getVolume() {
        return (4.0/3.0) * Math.PI * Math.pow(radius, 3);
    }
}

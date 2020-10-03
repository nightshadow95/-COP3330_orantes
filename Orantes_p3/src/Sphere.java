public class Sphere extends Shape3D {

    private final String Name = "sphere";
    private double Radius;

    public Sphere(double Radius) {

       this.Radius = Radius;
    }

    @Override
    public String getName() {

        return Name;
    }

    @Override
    public double getArea() {

        return (4 * Math.PI * Math.pow(Radius, 2));
    }


    @Override
    public double getVolume() {

        return (1.333333 * Math.PI * Math.pow(Radius, 3));
    }
}

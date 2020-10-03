public class Circle extends Shape2D {

    private final String Name = "circle";
    private double Radius;

    public Circle(double Radius) {

        this.Radius = Radius;
    }

    @Override
    public String getName() {

        return Name;
    }

    @Override
    public double getArea() {

        return Math.PI * Math.pow(Radius, 2);
    }
}

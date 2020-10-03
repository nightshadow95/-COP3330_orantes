public class Triangle extends Shape2D {

    private final String Name = "triangle";
    private double Base;
    private double Height;

    public Triangle(double Base, double Height) {

        this.Base = Base;
        this.Height = Height;
    }

    @Override
    public String getName() {

        return Name;
    }

    @Override
    public double getArea() {

        return ((Height*Base) /2);
    }
}

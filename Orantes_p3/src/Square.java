public class Square extends Shape2D {

    private final String Name = "square";
    private double Side;

    public Square(double Side) {

        this.Side = Side;
    }

    @Override
    public String getName() {

        return Name;
    }

    @Override
    public double getArea() {

        return Side*Side;
    }
}

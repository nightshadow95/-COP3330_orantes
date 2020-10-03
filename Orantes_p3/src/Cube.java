public class Cube extends Shape3D {

    private final String Name = "cube";
    private double Edge;

    public Cube(double Edge) {

        this.Edge = Edge;
    }

    @Override
    public String getName() {

        return Name;
    }

    @Override
    public double getArea() {

        return (6 * Math.pow(Edge, 2));
    }


    @Override
    public double getVolume() {

        return Math.pow(Edge, 3);
    }
}

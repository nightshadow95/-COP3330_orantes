public class Pyramid extends Shape3D {

    private final String Name = "pyramid";
    private double Base_Length;
    private double Base_Width;
    private double Height;

    public Pyramid(double Base_Length, double Base_Width, double Height) {

        this.Base_Length = Base_Length;
        this.Base_Width = Base_Width;
        this.Height = Height;
    }

    @Override
    public String getName() {

        return Name;
    }

    @Override
    public double getArea() {

        return ((Base_Length * Base_Width) + (Base_Length * (Math.sqrt(Math.pow(Base_Width/2,2) + Math.pow(Height, 2))))
                + (Base_Width * (Math.sqrt(Math.pow(Base_Length/2,2) + Math.pow(Height, 2)))));
    }


    @Override
    public double getVolume() {

        return (Base_Length * Base_Width * Height) / 3;
    }
}

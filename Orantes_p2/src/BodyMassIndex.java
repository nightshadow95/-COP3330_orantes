public class BodyMassIndex {

    double height;
    double weight;

    public BodyMassIndex(double height, double weight) {
        this.height = height;
        this.weight = weight;
    }


    public static double BMI_Calculator(double Height, double Weight) {

        return(703 * Weight) / (Height * Height);

    }

    public static String BMI_Category(double BMI) {

        if (BMI < 18.5) {
            return "Underweight";
        } else if (BMI == 18.5 || BMI <= 24.9) {
            return "Normal Weight";
        } else if (BMI == 25 || BMI <= 29.9) {
            return "Overweight";
        } else
            return "Obesity";
    }
}

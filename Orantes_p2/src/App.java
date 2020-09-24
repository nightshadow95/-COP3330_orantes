import java.util.ArrayList;
import java.util.Scanner;


public class App {

    public static void main(String[] args) {
        ArrayList<BodyMassIndex> bmiData = new ArrayList<BodyMassIndex>();

        while (moreInput()) {
            double height = getUserHeight();
            double weight = getUserWeight();

            BodyMassIndex bmi = new BodyMassIndex(height, weight);
            bmiData.add(bmi);


            displayBmiInfo(bmi);
        }

        displayBmiStatistics(bmiData);
    }

    private static void displayBmiStatistics(ArrayList<BodyMassIndex> bmiData) {
        double Sum = 0;
        double Average;
        int counter = 0;
        for (BodyMassIndex bmiDatum : bmiData) {
            Sum += BodyMassIndex.BMI_Calculator(bmiDatum.height, bmiDatum.weight);
            counter++;
        }

        Average = Sum / counter;
        System.out.printf("The Average BMI of all the users is: " +"%.1f\n", Average);
        System.out.println("which is in the "+ BodyMassIndex.BMI_Category(Average)+ " category.");
    }

    private static double getUserWeight() {
        double Answer;
        Scanner input = new Scanner(System.in);
        System.out.println("Please enter your weight in pounds(lbs): ");
        Answer = input.nextDouble();
        while(Answer <= 0) {
            System.out.println("You cannot enter \"0\" or a negative value\n Please try again:");
            Answer = input.nextDouble();
        }
        return Answer;
    }

    private static double getUserHeight() {
        double Answer;
        Scanner input = new Scanner(System.in);
        System.out.println("Please enter your Height in inches: ");
        Answer = input.nextDouble();
        while(Answer <= 0) {
            System.out.println("You cannot enter \"0\" or a negative value\n Please try again:");
            Answer = input.nextDouble();
        }
        return Answer;
    }

    public static void displayBmiInfo(BodyMassIndex BMI){
        double FinalBMI = BodyMassIndex.BMI_Calculator(BMI.height, BMI.weight);
        System.out.printf("The BMI of the user is: " +"%.1f\n", FinalBMI);
        System.out.println("The category of the user is: " + BodyMassIndex.BMI_Category(FinalBMI));

    }

    public static boolean moreInput(){
        String Answer;
        Scanner input = new Scanner(System.in);
        System.out.println("If you would like to enter a new user enter: \"yes\" otherwise enter: \"no\"");
        Answer = input.nextLine();
        while (!Answer.toLowerCase().equals("yes") && !Answer.toLowerCase().equals("no") ) {
            System.out.println("Please enter a valid answer:");
            Answer = input.nextLine();
        }

        return Answer.toLowerCase().equals("yes");
    }


}


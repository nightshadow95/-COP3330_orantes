import java.util.Arrays;

public class Decrypter {

    public static String decrypt(String Message) {
        return ConvertArray(Equations(ConvertString(Message)));
    }

    public static int [] ConvertString(String Decrypt) {
        int [] number = new int[4];

        for(int i=0; i < 4; i++) {
            number[i] =  Integer.parseInt(String.valueOf(Decrypt.charAt(i)));
        }

        return number;
    }

    public static int [] Equations(int FirstNumbers []) {

        int [] FinalNumbers = new int[4];

        FinalNumbers[0] = (FirstNumbers[2]+10) -7;
        FinalNumbers[1] = (FirstNumbers[3]+10) -7;
        FinalNumbers[2] = (FirstNumbers[0]+10) -7;
        FinalNumbers[3] = (FirstNumbers[1]+10) -7;

        for (int i = 0; i < 4; i++ ){
            if (FinalNumbers[i] >= 10) {
                FinalNumbers[i] = FinalNumbers[i] - 10;
            }
        }

        return FinalNumbers;
    }

    public static String ConvertArray(int FinalNumbers []) {
        return Arrays.toString(FinalNumbers).replace("[","").replace("]","").replace(", ","");
    }
}
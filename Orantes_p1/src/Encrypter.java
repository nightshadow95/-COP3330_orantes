import java.util.Arrays;
import java.util.Scanner;

public class Encrypter {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Encrypter MyEncrypter = new Encrypter();
        Decrypter MyDecrypter = new Decrypter();

        System.out.println("Hello, and welcome to the Encryption program.");
        System.out.println("Please enter the 4 digits that you would like to encrypt: ");
        String Encryption = scan.nextLine();

        System.out.println("Encrypts " + "\"" + Encryption + "\"" + " to " + "\"" + MyEncrypter.encrypt(Encryption) + "\"");

        System.out.println("This program can also allow users to decrypt messages.");
        System.out.println("If you would like to use this part of the program, then enter the encrypted value or type \"exit\" to exit the program");
        String Decryption = scan.nextLine();

        if (Decryption.toLowerCase().equals("exit")) {
            System.out.println("Thank you, have a good day.");
        }

        else {
            System.out.println("Decrypts " + "\"" + Decryption + "\"" + " to " + "\"" + MyDecrypter.decrypt(Decryption) + "\"");
        }
    }

    public static String encrypt(String Message) {
        return ConvertArray(Equations(ConvertString(Message)));
    }

    public static int [] ConvertString(String Encrypt) {
        int [] number = new int[4];

        for(int i=0; i < 4; i++) {
            number[i] =  Integer.parseInt(String.valueOf(Encrypt.charAt(i)));
        }
        return number;
    }

    public static int [] Equations(int[] FirstNumbers) {

        int [] FinalNumbers = new int[4];

        FinalNumbers[0] = (FirstNumbers[2]+7) %10;
        FinalNumbers[1] = (FirstNumbers[3]+7) %10;
        FinalNumbers[2] = (FirstNumbers[0]+7) %10;
        FinalNumbers[3] = (FirstNumbers[1]+7) %10;

        return FinalNumbers;
    }

    public static String ConvertArray(int[] FinalNumbers) {
        return Arrays.toString(FinalNumbers).replace("[","").replace("]","").replace(", ","");
    }
}

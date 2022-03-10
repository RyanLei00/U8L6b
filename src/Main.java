import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("What sentence are you trying to encrypt?");
        String encryptStr = input.nextLine();
        System.out.println("What is your encryption key (rows)");
        int rows = input.nextInt();
        System.out.println("What is your encryption key (columns)");
        int columns = input.nextInt();
        Encryptor encrypt = new Encryptor(rows, columns);
        System.out.println(encrypt.encryptMessage(encryptStr));
    }
}

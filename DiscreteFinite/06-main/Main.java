import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.print("Input : ");
        new PasswordChack().process(scn.nextLine());
    }
}


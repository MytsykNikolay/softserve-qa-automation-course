package softserveinc.com.SandBox;

import java.util.Scanner;

public class Palindrome {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.println("Enter string:");
        String string = input.nextLine();

        boolean palindrome = true;
        for (int i = 0; i < string.length() / 2; i++)
            if (string.charAt(i) != string.charAt(string.length() - i - 1)) {
                palindrome = false;
                break;
            }

        if (palindrome)
            System.out.println("YES");
        else
            System.out.println("NO");

    }
}

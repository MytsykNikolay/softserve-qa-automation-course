package softserveinc.com.ElementaryTasks;

import java.util.Scanner;

public class FibonacciRow {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        final byte MAX_LENGTH = 10;
        long value = 0;

        System.out.println("Enter a number no more then 10 digits: ");
        while (scanner.hasNext()) {
            if (scanner.hasNextLong()) {
                value = scanner.nextLong();
                if ((String.valueOf(value).length() <= MAX_LENGTH) && (value > 0)) {
                    break;
                } else {
                    System.out.println("Error: Input number was too long or negative number");
                    System.out.println("Enter a number: ");
                }
            } else {
                System.out.println("Error: Invalid Input!");
                System.out.println("Enter a number: ");
                scanner.next();
            }
        }

        long number1 = 0;
        long number2 = 1;
        long number3 = 0;

        while (number3 <= value) {
            number3 = number1 + number2;
            number1 = number2;
            number2 = number3;

            System.out.print(number1 + " ");

        }
    }
}

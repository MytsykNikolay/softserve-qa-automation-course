package softserveinc.com.ElementaryTasks;

import java.util.Scanner;

public class ChessBoard {

    public static void main(String[] args) {

        Scanner inputHorizontal = new Scanner(System.in);
        Scanner inputVertical = new Scanner(System.in);






        int a = 10;
        int b = 10;

        for (int i = 0; i < a; i++) {

            for (int j = 0; j < b * 2; j++) {

                if ((i + j) % 2 == 0) {

                    System.out.print("*");

                } else {

                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
}

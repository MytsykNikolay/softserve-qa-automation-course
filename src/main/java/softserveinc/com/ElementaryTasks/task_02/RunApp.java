package softserveinc.com.ElementaryTasks.task_02;

import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

public class RunApp {
    /**
     * This program asks user to enter vertical and horizontal sides
     * for envelope A and envelope B both respectively.
     * Then it tells if some of envelope can fit into another
     * If user wants to repeat procedure with new envelopes he types y or yes (case insensitive)
     * after the question "Would you like to try again?"
     */

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in).useLocale(Locale.ENGLISH); // locale for inputting double values with dot delimiter
        final String agreement = "(?i)(y|yes)";

        /*
        Array for temporary saving sides of both of envelopes.
        vertical side A envelope -> sides[0]
        horizontal side A envelope -> sides[1]
        vertical side B envelope -> sides[2]
        horizontal side B envelope -> sides[3]
         */
        double sides[] = new double[4];

        do {
            try {
                for (int i = 0; i < sides.length; i++) {
                    switch (i) {
                        case 0:
                            System.out.println("Envelope A");
                            System.out.println("Vertical side:");
                            break;
                        case 1:
                            System.out.println("Horizontal side:");
                            break;
                        case 2:
                            System.out.println("Envelope B");
                            System.out.println("Vertical side:");
                            break;
                        case 3:
                            System.out.println("Horizontal side:");
                    }
                    sides[i] = scanner.nextDouble();
                }

                Envelope envelopeA;
                Envelope envelopeB;
                envelopeA = Envelope.createEnvelope(sides[0], sides[1]);
                envelopeB = Envelope.createEnvelope(sides[2], sides[3]);

                if (envelopeA.isFitInto(envelopeB)) {
                    System.out.println("Envelope A can be put in envelope B");

                } else if (envelopeB.isFitInto(envelopeA)) {
                    System.out.println("Envelope B can be put in envelope A");

                } else {
                    System.out.println("Neither of them can fit into each other");
                }
                System.out.println("Would you like to try again? (enter 'y/yes' to continue or any key for exit");

            } catch (NumberFormatException | InputMismatchException e) {
                System.out.println("Wrong arguments entered");

            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        } while (scanner.next().matches(agreement));
        scanner.close();
    }
}

package softserveinc.com.ElementaryTasks.task_03;

import java.util.LinkedList;
import java.util.Scanner;

/**
 * This is program outputs triangles in a descend order by their area.
 * It asks user to input triangle attributes in following format:
 * <name>, <sideOne>, <sideTwo>, <sideThree> separated with comma. After completing of entering
 * attributes of a triangle program asks user if he wants to continue adding triangles.
 * If he enters 'y' or 'yes' (input is case insensitive) then he is allowed to enter
 * attributes for next triangle. Else, adding ends up and program outputs those triangles in a descend order/
 */

public class StartApp {

    public static void main(String[] args) {
        LinkedList<Triangle> triangles = new LinkedList<>();

        System.out.println("Arguments should be in the following order: <name>, <sideOne>, <sideTwo>, <sideThree>");
        System.out.println("(don't forget to separate them with comma like: name, 4, 5.7 , 8.0)\n");

        Scanner input = new Scanner(System.in);

        try (Scanner scanner = new Scanner(System.in)) {
            do {
                System.out.println("Enter new triangle attributes: ");

                String triangleDataInput[] = scanner.nextLine().split(",");
//                if (triangleDataInput[0].isEmpty()) {
//                    printWarning();
//                }

                triangles.add(
                        Triangle.createTriangle(
                                triangleDataInput[0].trim(),
                                Double.parseDouble(triangleDataInput[1]),
                                Double.parseDouble(triangleDataInput[2]),
                                Double.parseDouble(triangleDataInput[3])));


                System.out.println("Do you want to continue adding triangles? (enter 'y/yes' to continue or any key for exit and getting result");
            }
            while (input.next().matches("(?i)(y|yes)"));

            Triangle.getTrianglesList(triangles);

        } catch (NumberFormatException e) {
            System.out.println("You can't use any characters to input values of sideOne, sideTwo, sideThree except digits numbers");

        } catch (IndexOutOfBoundsException e) {
            System.out.println("Need to separate every argument with comma");

        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}

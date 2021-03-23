package softserveinc.com.ElementaryTasks.task_03;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

public class Triangle {

    private final String name;
    private final double area;

    private Triangle(String name, double sideOne, double sideTwo, double sideThree) {
        this.name = name;
        area = areaCalculation(sideOne, sideTwo, sideThree);
    }

    public double getArea() {
        return area;
    }

    public static Triangle createTriangle(String name, double sideOne, double sideTwo, double sideThree)
            throws IllegalArgumentException {
        if (name == null || name.equals("")) {
            throw new IllegalArgumentException("Triangle must have any name.");
        } else if (sideOne <= 0 || sideTwo <= 0 || sideThree <= 0) {
            throw new IllegalArgumentException("Triangle sides must be positive numbers.");
        } else if (sideOne + sideTwo <= sideThree
                || sideOne + sideThree <= sideTwo
                || sideTwo + sideThree <= sideOne) {
            throw new IllegalArgumentException(
                    "Triangle sides must suit the following rule:\n" + "The sum of two arbitrary triangle sides is always greater then the third side");
        } else {
            return new Triangle(name, sideOne, sideTwo, sideThree);
        }
    }

    private double areaCalculation(double sideOne, double sideTwo, double sideThree) {
        double p = 0.5 * (sideOne + sideTwo + sideThree);
        return Math.pow(p * (p - sideOne) * (p - sideTwo) * (p - sideThree), 0.5);
    }

    @Override
    public String toString() {
        DecimalFormat decimalFormat = new DecimalFormat("0", DecimalFormatSymbols.getInstance(Locale.ENGLISH));
        decimalFormat.setMinimumFractionDigits(0);
        decimalFormat.setMaximumFractionDigits(3);
        return String.format("[Triangle %s]: " + decimalFormat.format(area) + " cm", name);
    }


    public static void getTrianglesList(List<Triangle> triangles) {    //reversed list
        triangles.sort(Collections.reverseOrder(new TriangleComparator()));
        System.out.println("------------ Triangles list: -------------");
        int i = 1;
        for (Triangle temp : triangles) {
            System.out.println(i++ + ". " + temp);
        }
    }
}

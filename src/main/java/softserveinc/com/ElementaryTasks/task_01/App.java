package softserveinc.com.ElementaryTasks.task_01;

import java.util.regex.Pattern;

public class App {

    public static void printManual() {
        System.out.println(
                "This program displays a chess board with custom size.\n"
                        + "You should enter two arguments in numerical representation:\n"
                        + "height and width of the board respectively\n"
                        + "Each argument must be greater than 0 or chess board won't be created and exception will be thrown\n");
    }

    public static void main(String[] args) {

        ChessBoard.createChessBoard(5,5);

        Pattern pattern = Pattern.compile("^[+-]?\\d+");

        try {
            if (args.length == 0) {
                printManual();
            } else if (args.length != 2) {
                System.out.println("There must be exactly two arguments");
            } else if (pattern.matcher(args[0]).matches() && pattern.matcher(args[1]).matches()) {
                ChessBoard chessBoard =
                        ChessBoard.createChessBoard(Integer.parseInt(args[0]), Integer.parseInt(args[1]));
                System.out.println(chessBoard.getBoardRepresentation());
            } else {
                System.out.println("Arguments must be integer numbers");
            }
        } catch (NumberFormatException e) {
            System.out.println("You used too large number or incorrect input");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}

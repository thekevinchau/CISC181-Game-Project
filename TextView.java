import java.util.Scanner;

public class TextView {
    /**
     * TextView
     *
     * @author: Philip Stoyanov
     * @version: 1.0
     */

    private int fromSquareRow;
    private int fromSquareCol;
    private int toSquareRow;
    private int toSquareCol;
    private char actionType;

    public int getFromSquareRow() {
        return this.fromSquareRow;
    }

    public int getFromSquareCol() {
        return this.fromSquareCol;
    }

    public int getToSquareRow() {
        return this.toSquareRow;
    }

    public int getToSquareCol() {
        return this.toSquareCol;
    }

    public char getActionType() {
        return this.actionType;
    }

    public static char getUsersNextActionType(Scanner scr) {
        /**
         * Asks user to input the character a, r, s, or m, ignoring case
         *
         * @param scr Scanner class, therfore user can type the string into tha console until they
         *            input a desired value
         * @return the first char that is either a, r, s, or m, ignoring case
         */
        boolean validLetter = false;
        String attackType = " ";
        while (!validLetter) {
            System.out.println("Enter either A for Attack, M for Move, R for Recruit, or S for Spawn");
            if (scr.hasNext("A")||scr.hasNext("M")||scr.hasNext("R")||scr.hasNext("s")||scr.hasNext("a")||scr.hasNext("m")||scr.hasNext("r")||scr.hasNext("S")) {
                attackType = scr.next();
                validLetter = true;
            } else {
                System.out.println("Choose one of the specified characters");
                scr.next();
            }

        } return(attackType.charAt(0));
    }

    public static int getValidInt(int min, int max, Scanner scr) {
        /**
         * Asks user to input a value that is between the min and max arguments.
         * Keeps looping, asking user to input values until value inputted is
         * between min and max.
         *
         * @param min the minimum value the input can be that will still exit the loop
         *        max the maximum value the input can be that will still exit the loop
         *        scr Scanner class so that user can input their own values through the console
         * @return an int representing the first input that was in the range of min and max
         */
        boolean inRange = false;
        int target = 0;
        while (!inRange) {
            System.out.println("Type a number between " + min + " and " + max);
            if (scr.hasNextInt()) {
                target = scr.nextInt();
                if (target >= min && target <= max) {
                    inRange = true;
                }
                else {
                    System.out.println("Try another number");
                }
            } else {
                scr.next();
                System.out.println("Type in an integer");
            }

        }
        return target;

    }

    public void getNextPlayersAction(GameS22 game) {
        Scanner scr = new Scanner(System.in);
        // use scanner to ask for action type
        this.actionType = getUsersNextActionType(scr);
        // asks for input of from square (row, col)
        this.fromSquareRow = getValidInt(0, game.getGameBoard().getNumRows(), scr);
        this.fromSquareCol = getValidInt(0, game.getGameBoard().getNumColumns(), scr);
        this.toSquareRow = getValidInt(0, game.getGameBoard().getNumRows(), scr);
        this.toSquareCol = getValidInt(0, game.getGameBoard().getNumColumns(), scr);
    }

    public void updateView(Game game) {
        System.out.println(game);
    }

    public void printEndOfGameMessage(Game game) {
        System.out.println("Game Has Ended");
        System.out.println(game.getWinner() + " has won");
    }

}









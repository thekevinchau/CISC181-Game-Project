/*
@author Paul Kearney
@version 1
this method creates the game and calls alot of other classes methods to bring
everything together
*/
import java.util.Collections;
public abstract class Game {
    /**
     * this method puts everything together and calls methods from previously
     * defined classes to put the game together.
     *
     * @author Paul kearney
     * @version 1.0
     */
    public GameBoard board;
    protected Team one;
    protected Team two;
    public String turn;

    protected void initializeGameBoard(int rows, int columns) {
        /**
         @returns nothing
         @param rows-int
         and columns-int
         this methods does not return anything and uses the parameters row and
         columns and makes a new GameBoard calling the GameBoard constructor
         then, a for loop iterates through an array list of Pieces and then
         finds empty space, and once empty space is found, the piece is placed
         this for loop is done with both team one and team two.
         */
        this.board = new GameBoard(rows, columns);

        for (int i = 0; i < one.getTeamPieces().size(); i++) {
            BoardSquare empty = this.board.findRandomEmptySpace();
            empty.setPiece(one.PlayerPieces.get(i));
        }
        for (int i = 0; i < two.getTeamPieces().size(); i++) {
            BoardSquare empty = this.board.findRandomEmptySpace();
            empty.setPiece(two.PlayerPieces.get(i));
        }
    }

    public Game(int rows, int columns, Team a, Team b) {
        /**
         @param int rows, int columnsm Team a, Team b
         @returns nothing
         this method sets each team to their respective parameter, then
         the variable turn is set to the first teams color indicating that
         the first team starts with the first turn. then the initializeGameBoard
         method is called to create a game board with the rows and colums int
         parameters being passed to this method
         */
        this.one = a;
        this.two = b;
        turn = a.getTeamColor();
        this.initializeGameBoard(rows, columns);

    }

    public GameBoard getGameBoard() {
        /**
         @returns a GameBoard
         @param none
         this method returns the game board of the object
         that this method is called on
         */
        return this.board;
    }

    public Team getCurrentTeam() {
        /**
         @param none
         @returns none
         this method, if the turn variable is equal to the color of
         the first team, will return the Team one. if turn is not equal
         to the color of the first team, it means its the second Teams turn
         and the second team(two) is returned
         */
        if (turn == this.one.getTeamColor()) {
            return this.one;
        } else
            return this.two;


    }

    public Team getOpponentTeam() {
        /**
         @param none
         @returns a Team
         this method, if the turn variable is equal to the color of
         the first team, will return the Team two. if turn is not equal
         to the color of the first team, it means its the second Teams turn
         and the first Team(one) is returned
         */
        if (turn == this.one.getTeamColor()) {
            return this.two;
        } else {
            return this.one;
        }
    }

    public boolean isTurn(Team turnOrNot) {
        /**
         @param Team turnOrNot
         @returns a boolean
         if the parameter team is equal to the current team, true will
         be returned, and if its not equal, false will be returned
         */
        if (turnOrNot == getCurrentTeam()) {
            return true;
        } else {
            return false;
        }
    }


    public BoardSquare[][] getBoardSquares() {
        /**
         * @returns the 2d array that this method is called on
         * @param none
         */
        return this.board.getSquares();
    }

    public void changeTurn() {
        this.turn = getOpponentTeam().getTeamColor();
    }

    @Override
    public String toString() {
        StringBuilder retString = new StringBuilder();
        retString.append("Game Board:\n")
                .append(String.join("", Collections.nCopies(10 + board.getNumColumns() * 8, "*")))
                .append("\n" + getGameBoard().toString())
                .append(String.join("", Collections.nCopies(10 + board.getNumColumns() * 8, "*")))
                .append("\n" + getCurrentTeam().toString() + "\n")
                .append(String.join("", Collections.nCopies(10 + board.getNumColumns() * 8, "*")))
                .append("\n" + getOpponentTeam().toString() + "\n")
                .append(String.join("", Collections.nCopies(10 + board.getNumColumns() * 8, "*")))
                .append("\nIt is Team " + getCurrentTeam().getTeamColor() + "'s turn\n");
        return retString.toString();
    }


    public abstract boolean isAWinner();
    public abstract Team getWinner();
    public abstract boolean isGameEnded();

}


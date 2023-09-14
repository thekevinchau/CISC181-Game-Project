public class GameBoard {
    private int rows;
    private int columns;
    private BoardSquare[][] squares;
    /**
     * Class that handles the game's game board that the Pieces will traverse through
     *
     * @author Kevin Chau
     * @version 1.0
     */
    /**
     * Constructor for the GameBoard
     * @param rows: The number of rows
     * @param columns: The number of columns.
     */
    public GameBoard(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
        this.squares = new BoardSquare[rows][columns];
        setUpEmptyBoard();


    }

    /**
     * Gets the number of rows on the board.
     * @return: The number of rows.
     */
    public int getNumRows() {
        return this.rows;
    }

    /**
     * Returns the number of columns on the board.
     * @return: The number of columns.
     */
    public int getNumColumns() {
        return this.columns;
    }

    /**
     * Gets the BoardSquare's squares.
     * @return: The BoardSquare's squares.
     */
    public BoardSquare[][] getSquares() {
        return this.squares;
    }

    /**
     * method that checks rows and columns to see whether a piece is within the GameBoard bounds
     *
     * @param rowIndex: syncs index of row array to its value
     * @param columnIndex: syncs index of column array to its value
     * @return boolean: if rowIndex and columnIndex are less than their respective fields - 1 and greater than 0,
     * return true, otherwise return false
     */

    public boolean inBounds(int rowIndex, int columnIndex) {
        if (rowIndex > this.rows - 1 || columnIndex > this.columns - 1) {
            return false;
        } else if (rowIndex < 0 || columnIndex < 0) {
            return false;
        }
         else {
            return true;
        }
    }

    /**
     * Sets up an empty board for pieces to load into.
     */
    public void setUpEmptyBoard() {
        for (int i = 0; i < squares.length; i++) {
            for (int j = 0; j < squares[i].length; j++) {
                if (((j + 1) % 2) == 0) {
                    squares[i][j] = new BoardSquare("Blue");
                } else {
                    squares[i][j] = new BoardSquare("Red");
                }
            }
        }
    }

    /**
     * Returns a randomly found boardSquare on the board.
     * @return: A random location of a BoardSquare on the gameBoard.
     */
    public BoardSquare findRandomEmptySpace() {
        while(true){
            int row_num =  (int)(Math.random() * rows);
            int col_num = (int)(Math.random()*columns);
            if (squares[row_num][col_num].isEmpty()){
                return squares[row_num][col_num];
            }
        }
    }

    /**
     * Plants a mine in a random location on the board.
     */
    public void plantMine(){
        BoardSquare bomb = findRandomEmptySpace();
        while (bomb.isLandMine()){
            bomb = findRandomEmptySpace();
        }
        bomb.setPiece(new PieceBomb());
        bomb.setLandMine(new PieceBomb());

    }

    /**
     * Overriden toString to create a visual representation of the gameBoard.
     * @return: Returns a string.
     */
    @Override
    public String toString(){
        StringBuilder boardString = new StringBuilder();
        boardString.append("Col :       ");

        for(int col = 0; col < squares[0].length; col++){
            boardString.append(col + "        ");
        }
        boardString.append("\n");
        for(int row = 0; row < squares.length; row++){
            boardString.append("Row : " + row + "   ");
            for(int col = 0; col < squares[row].length; col++){
                boardString.append(squares[row][col].toString() + "  ");
            }
            boardString.append("\n");
        }
        return boardString.toString();
    }

}




public class BoardSquare {
    public boolean empty;
    Piece piece;
    public Piece bomb;
    public boolean isLandMine;
    private String boardColor;

    /**
     * Constructor for a boardSquare
     * @param boardColor: The color of the board.
     */

    public BoardSquare(String boardColor) {
        this.boardColor = boardColor;
        this.empty = true;
    }

    /**
     * Checks if the board is empty.
     * @return: A boolean indicating whether or not the boardSquare is empty.
     */
    public boolean isEmpty() {
        return this.empty;
    }

    /**
     * Checks if the BoardSquare's piece is a landMine.
     * @return: A boolean indicating whether or not it's a landmine.
     */
    public boolean isLandMine(){
        if (this.piece instanceof PieceBomb){
            this.isLandMine = true;
        }
        else{
            this.isLandMine = false;
        }
        return this.isLandMine;
    }

    /**
     * Sets the landMine by setting the isLandMine to true and setting the Piece to the bomb.
     * @param bomb
     */
    public void setLandMine(Piece bomb){
        isLandMine = true;
        this.bomb = bomb;
    }

    /**
     * Checks if the bomb is null or non-existent.
     * @return: A boolean indicating whether or not the bomb is there or not.
     */
    public boolean checkBomb(){
        if (bomb == null) {
            return false;
        }
        else{
            return true;
        }
        }

    /**
     * Gets the Board's square color.
     * @return: Returns the color of the boardSquare.
     */
    public String getSquareColor() {
        return this.boardColor;
    }

    /**
     * Gets the piece that's on this boardSquare.
     * @return: The piece that's on this boardsquare.
     */
    public Piece getPiece() {
        return this.piece;
    }

    /**
     * Sets the piece to this boardSquare.
     * @param piece: Specified piece onto this boardSquare.
     */
    public void setPiece(Piece piece) {
        this.piece = piece;
        this.empty = false;
    }

    /**
     * Removes the piece that is on this boardSquare.
     * @return: The piece that has been removed.
     */
    public Piece removePiece() {
        Piece temp = this.piece;
        this.piece = null;
        this.empty = true;
        return temp;
    }

    /**
     * Overrides the toString method to display the current status of the boardSquare.
     * @return: The status of the boardSquare, if it is empty, a bomb, or a piece.
     */
    @Override
    public String toString() {
        if (this.empty == true) {
            return "-------";
        }
        if (this.checkBomb()){
            return "-" + bomb.toString() + "-";
        }
        else {
            return "-" + piece.toString() + "-";
        }
    }
}


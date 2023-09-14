public class PieceBomb extends Piece{

    /**
     * Creates a constructor for the PieceBomb
     * @param symbol: Character indicating symbol
     * @param teamColor: String indicating team's color.
     * @param hidden: Boolean determining whether or not it is hidden.
     * @param original: Boolean indicating whether or not it is an original piece.
     */
    public PieceBomb(char symbol, String teamColor, boolean hidden, boolean original) {
        super(symbol, teamColor, hidden, original);
    }

    /**
     * Gets the Piece's symbol
     * @return: The piece's symbol.
     */
    public char getSymbol(){
        return this.symbol;
    }

    /**
     * Gets the Piece's team color
     * @return: Returns the piece's team color.
     */
    public String getTeamColor(){
        return this.teamColor;
    }

    /**
     * Checks if the piece is hidden.
     * @return: Returns if it is hidden.
     */
    public boolean isHidden(){
        return this.hidden;
    }

    /**
     * Checks if the piece is original.
     * @return: Returns if it is an original piece.
     */
    public boolean isOriginal(){
        return this.original;
    }

    /**
     * Sets the symbol to one's specification.
     * @param symbol
     */
    public void setSymbol(char symbol){
        this.symbol = symbol;
    }

    /**
     * Sets the teamColor to one's specification.
     * @param teamColor
     */
    public void setTeamColor(String teamColor){
        this.teamColor = teamColor;
    }

    /**
     * Sets the Piece's hidden boolean flag.
     * @param hidden
     */
    public void setHidden(boolean hidden){
        this.hidden = hidden;
    }

    /**
     * Sets the Piece's original boolean flag.
     * @param original
     */
    public void setOriginal(boolean original){
        this.original = original;
    }

    /**
     * Default constructor for the bomb piece.
     */
    public PieceBomb(){
        this('X', "BOMB", true, true);
    }

    @Override
    public PieceBomb spawn() {
        return null;
    }

    /**
     * Returns nothing. Prints I'm a bomb!
     */
    @Override
    public void speak() {
        System.out.println("I'm a bomb! Boom!");

    }

    /**
     * The path the bomb can take to move. For this moment, the bomb cannot move
     * @param fromSquareRow: From square's Row
     * @param fromSquareCol: From square's Column
     * @param toSquareRow: to Square's row
     * @param toSquareCol: to Square's column
     * @return: Boolean indicating whether or not it can move.
     */
    @Override
    public boolean validMovePath(int fromSquareRow, int fromSquareCol, int toSquareRow, int toSquareCol) {
        return false;
    }

    /**
     * The path the bomb can take to spawn. For this instance, the bomb cannot spawn again.
     * @param fromSquareRow: From square's row.
     * @param fromSquareCol: From square's column.
     * @param toSquareRow: to Square's row.
     * @param toSquareCol: to Square's column
     * @return: Boolean indicating whether or not it can spawn on specified path.
     */
    @Override
    public boolean validSpawnPath(int fromSquareRow, int fromSquareCol, int toSquareRow, int toSquareCol) {
        return false;
    }

    /**
     * Returns the toString version of the piece.
     * @return: Returns the Bomb's team Color and symbol.
     */
    @Override
    public String toString(){
        return this.teamColor + this.symbol;
    }
}

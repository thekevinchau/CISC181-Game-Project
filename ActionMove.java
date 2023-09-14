public class ActionMove extends Action {

    /**
     * Calls on super class parameters and instantiates an action that the Piece can take ot move.
     * @param game: A GameS22 object
     * @param fromRow: The row index of the Piece that is moving
     * @param fromColumn: The column index of the Piece that is moving
     * @param toRow: The row index of the location of where the Piece is moving.
     * @param toColumn: The column index of the location of where the Piece is moving.
     */

    public ActionMove(GameS22 game, int fromRow, int fromColumn,
                      int toRow, int toColumn){
        super(game, fromRow, fromColumn, toRow, toColumn);
    }

    @Override
    /**
     * Returns and consumes nothing. It will move the piece from the fromRow, fromColumn to the ToRow, toColumn.
     */
    public void performAction() {
        BoardSquare[][] boardSquares = game.getBoardSquares();
        Piece pieceA = boardSquares[fromRow][fromColumn].getPiece();
        pieceA.speak();
        boardSquares[fromRow][fromColumn].removePiece();
        boardSquares[toRow][toColumn].setPiece(pieceA);
        game.changeTurn();
    }
}

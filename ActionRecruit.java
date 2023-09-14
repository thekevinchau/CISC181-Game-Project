public class ActionRecruit extends Action {
    /**
     * Creates a constructor by calling on super class parameters, and instantiates an action that allows a piece to recruit another piece.
     * @param game: A Game S22 object
     * @param fromRow: The row index of the Piece that is recruiting.
     * @param fromColumn: The column index of the Piece that is recruiting.
     * @param toRow: The row index of the Piece that is being recruited.
     * @param toColumn: The column index of the Piece that is being recruited.
     */
    public ActionRecruit(GameS22 game, int fromRow, int fromColumn,
                      int toRow, int toColumn){
        super(game, fromRow, fromColumn, toRow, toColumn);
    }

    @Override
    /**
     * Returns and consumes nothing. It will recruit a piece from the other team by removing it from the other team and adding it
     * to the current team.
     */
    public void performAction() {
        BoardSquare[][] boardSquare = game.getBoardSquares();
        Piece aPiece = boardSquare[fromRow][fromColumn].getPiece();
        aPiece.speak();
        game.getOpponentTeam().removePieceFromTeam(boardSquare[toRow][toColumn].getPiece());
        game.getCurrentTeam().addPieceToTeam(boardSquare[toRow][toColumn].getPiece());
        game.changeTurn();


    }
}

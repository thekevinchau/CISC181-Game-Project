public class ActionSpawn extends Action {
    /**
     * Creates a constructor for the ActionSpawn object which picks another place on the board to spawn the same Piece object.
     * @param game: A GameS22 object
     * @param fromRow: The row index of where the Piece currently is.
     * @param fromColumn: The column index of where the Piece currently is.
     * @param toRow: The row index of where the next Piece will be spawned.
     * @param toColumn: The column index of where the next Piece will be spawned.
     */
    public ActionSpawn(GameS22 game, int fromRow, int fromColumn,
                      int toRow, int toColumn){
        super(game, fromRow, fromColumn, toRow, toColumn);
    }

    @Override
    /**
     * Returns and consumes nothing. It will spawn another Piece that is another copy of the fromRow, fromColumn on the
     * toRow, toColumn indices.
     */
    public void performAction() {
        BoardSquare[][] boardSquare = game.getBoardSquares();
        Piece aPiece = boardSquare[fromRow][fromColumn].getPiece();
        aPiece.speak();
        aPiece.spawn();
        game.getCurrentTeam().addPieceToTeam(aPiece);
        boardSquare[toRow][toColumn].setPiece(aPiece);
        game.changeTurn();
    }
}

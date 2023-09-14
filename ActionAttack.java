public class ActionAttack extends Action {
    /**
     * Creates a constructor using the super class parameters. It creates an attack action object with two Piece locations.
     * @param game: A GameS22 object
     * @param fromRow: The row index of the attacking piece.
     * @param fromColumn: The column index of the attacking piece.
     * @param toRow: The row index of the piece being attacked.
     * @param toColumn: The column index of the piece being attacked.
     */
    public ActionAttack(GameS22 game, int fromRow, int fromColumn, int toRow, int toColumn){
        super(game,fromRow,fromColumn,toRow,toColumn);
    }

    @Override
    /**
     * The 'from' Piece will make an attack, which will remove the Piece from the Opponent's team, and sets the Attacking Piece
     * to the location of the Piece that was attacked and removed. If it is an Evil Minion, it will check if the piece it is attacking
     * is a minion. If so, it will remove the Minion and turn it into an Evil Minion instead.
     */
    public void performAction(){
        BoardSquare[][] boardSquare = game.getBoardSquares();
        Piece aPiece = boardSquare[fromRow][fromColumn].getPiece();
        Piece bPiece = boardSquare[toRow][toColumn].getPiece();
        if (aPiece instanceof PieceEvilMinion && bPiece instanceof PieceMinion && !(bPiece instanceof PieceEvilMinion)){
                aPiece.speak();
                game.getCurrentTeam().removePieceFromTeam(boardSquare[toRow][toColumn].removePiece());
                Piece evilMinion = new PieceEvilMinion();
                game.getCurrentTeam().addPieceToTeam(evilMinion);
                boardSquare[toRow][toColumn].setPiece(evilMinion);
                game.changeTurn();
        }
        else{
            aPiece.speak();
            game.getOpponentTeam().removePieceFromTeam(boardSquare[toRow][toColumn].removePiece());
            boardSquare[toRow][toColumn].setPiece(aPiece);
            game.changeTurn();


        }


    }

}

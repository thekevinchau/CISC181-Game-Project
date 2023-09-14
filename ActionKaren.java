public class ActionKaren extends Action {
    public ActionKaren(GameS22 game, int fromRow, int fromColumn, int toRow, int toColumn) {
        super(game, fromRow, fromColumn, toRow, toColumn);
    }

    public void performAction() {
        BoardSquare[][] boardSquares = game.getBoardSquares();
        Piece pieceA = boardSquares[fromRow][fromColumn].getPiece();
        pieceA.speak();
        if (fromColumn < toColumn) {
            fromColumn += 1;
            while (fromColumn < 8) {
                if (!(boardSquares[fromRow][fromColumn].isEmpty())) {
                    boardSquares[fromRow][fromColumn].removePiece();
                }
                fromColumn += 1;
            }

        }
        else  if (fromColumn > toColumn) {
            fromColumn -= 1;
            while (fromColumn >0) {
                if (!(boardSquares[fromRow][fromColumn].isEmpty())) {
                    boardSquares[fromRow][fromColumn].removePiece();
                }
                fromColumn -= 1;
            }
        }
        else  if (fromRow < toRow) {
            fromRow +=1;
            while (fromRow <8) {
                if (!(boardSquares[fromRow][fromColumn].isEmpty())) {
                    boardSquares[fromRow][fromColumn].removePiece();
                }
                fromRow +=1;
            }
        }else if (fromRow > toRow) {
            fromColumn -= 1;
            while (fromRow>0) {
                if (!(boardSquares[fromRow][fromColumn].isEmpty())) {
                    boardSquares[fromRow][fromColumn].removePiece();
                }
                fromRow -= 1;
            }

        }
        game.changeTurn();
    }
}



import java.util.ArrayList;

public class Rules {
    /**
     * this class checks the rules of the game and returns a boolean if the action is valid. the main method is there just
     * for testing the checkValidAction function.
     * @author Paul Kearney
     * @version 1.0
     *
     */
    public static boolean checkValidAction(GameS22 curr,int curRow,
                                           int curColumn, int rowP,int colP,
                                           char action) {
        /**
         * this class creates two new pieces one representing the to square piece if it is not empty
         * and another set equal to the from square if it is not empty. first i check if the poeces are in bounds
         * then if that passes the pieces are made by grabbing the piece in each square and creating a new piece
         * from those values. then the action given to the method will determine if the action will be valid and if
         * it is a valid action, true will be returned and if it is not a valid action false will be returned
         *  @param curr-the current game
         *  @param curRow-the from square row index
         *  @param curColumn-the from square column index
         *  @param rowP-the to square row index
         *  @param colP-the to square column index
         *  @param action- the char representing the desired action
         *  @returns a boolean representing if the action is valid or not
         */
        Piece oldSpace = null;
        Piece newSpace = null;
        boolean boolF = true;
        BoardSquare[][] squ = curr.getBoardSquares();
        if (!(curr.board.inBounds(curRow, curColumn) && curr.board.inBounds(rowP, colP))) {

            return false;
        }
        if (!(squ[curRow][curColumn].isEmpty())) {
            oldSpace = squ[curRow][curColumn].getPiece();
        } else {

            return false;
        }
        if (squ[rowP][colP].isEmpty() == false) {
            newSpace = squ[rowP][colP].getPiece();
        }

        //if (curr.board.inBounds(curRow, curColumn) && curr.board.inBounds(rowP, colP)) {
        //now determine if teh poece moving is that of the current team
        if ((oldSpace.getTeamColor().equals(curr.getCurrentTeam().getTeamColor()))) {
            if (action == 'M') {
                if (squ[rowP][colP].isEmpty() && oldSpace != null) {
                    return boolF;

                }
                if (squ[rowP][colP].getPiece() instanceof PieceBomb && oldSpace!=null){
                    squ[rowP][colP].removePiece();
                    return boolF;
                }
                else {

                    return false;
                }
            } else if (action == 'S') {
                if (!(oldSpace instanceof PieceBuzz||oldSpace instanceof PiecePlankton)) {
                    if (squ[rowP][colP].isEmpty()) {
                        if (oldSpace instanceof PieceEvilMinion) {
                            if (((PieceEvilMinion) oldSpace).canSpawn() == true) {
                                return true;
                            } else {

                                return false;
                            }

                        } else {
                            return true;
                        }
                    } else {
                        return false;
                    }
                } else {
                    return false;
                }

            } else if (action == 'R') {
                if (!(oldSpace instanceof PieceBuzz||oldSpace instanceof PiecePlankton)) {
                    if (newSpace == null) {

                        return false;

                    } else if (oldSpace.getTeamColor() != newSpace.getTeamColor()) {

                        return true;

                    } else {

                        boolF = false;

                    }
                } else {

                    boolF = false;
                }


            } else if (action == 'A') {
                if (newSpace == null) {
                    return false;
                } else if (oldSpace instanceof PieceBuzz) {
                    if (oldSpace.getTeamColor() != newSpace.getTeamColor()) {
                        if (((PieceBuzz) oldSpace).canAttack() == true) {
                            boolF = true;
                        } else {

                            boolF = false;
                        }
                    } else {

                        boolF = false;
                    }


                } else if (oldSpace instanceof PieceEvilMinion) {
                    if (oldSpace.getTeamColor() != newSpace.getTeamColor() || newSpace instanceof PieceMinion) {
                        if (((PieceEvilMinion) oldSpace).canAttack() == true && ((PieceEvilMinion) oldSpace).getNumAttacks() <= 4) {
                            return true;
                        } else {

                            return false;
                        }
                    } else {
                        return false;
                    }


                } else if (oldSpace instanceof PieceBlueHen) {
                    if (oldSpace.getTeamColor() != newSpace.getTeamColor()) {
                        return true;
                    } else {

                        boolF = false;
                    }


                } else {
                    return false;
                }
            }
        } else if (action == 'K') {
            if (oldSpace instanceof PiecePlankton) {

                int counter = 0;
                for (int row = -2; row < 3; row++) {
                    for (int col = -2; col < 3; col++) {
                        if (!(squ[rowP + row][colP + col].isEmpty())) {
                            if (squ[rowP + row][colP + col].getPiece().getTeamColor() != oldSpace.teamColor) {
                                counter += 1;
                            }
                        }
                    }

                }
                if (counter >= 3) {
                    return true;
                } else {
                    return false;
                }

            } else {
                return false;
            }

        } else {
            return false;
        }
        return boolF;
    }


}







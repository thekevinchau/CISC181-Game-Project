import java.util.ArrayList;

public class Team {
    /**
     * @author Paul kearney
     * @version 1.0
     * this class modifies teams as well as has constructors, modifiers
     * and getters for Team objects
     */
    protected String teamColor;
    public ArrayList<Piece> PlayerPieces = new ArrayList<Piece>();

    public Team(String teamColor, ArrayList<Piece> playerList) {
        /**
         * @param String teamColor, Arraylist playerList
         * @returns a Team object
         * this method creates a Team object with the parameters stored
         * in the Team that is created
         */
        this.PlayerPieces = playerList;
        this.teamColor = teamColor;
    }

    public String getTeamColor() {
        /**
         * accessor method to allow access to value of teamColor
         *
         * @return String: value of teamColor
         */
        return this.teamColor;
    }

    public ArrayList<Piece> getTeamPieces() {
/**
 * accessor method to allow access the list of Pieces on the Team object
 * that this method is called on
 *
 * @return arrayList of Pieces in the Team object
 */
        return this.PlayerPieces;
    }

    public void removePieceFromTeam(Piece getRid) {
        /**
         * this method takes the list of Pieces in the Team object that this method
         * is called on and removes the Piece that is specified as a parameter
         * @param Piece getRid
         * @returns nothing
         */
        this.PlayerPieces.remove(getRid);
    }

    public void addPieceToTeam(Piece newPiece) {
        /**
         * this method adds the Piece that is a parameter and adds
         * it to the list of Pieces in the PlayerPiece Arraylist
         * @param Piece newPiece
         * @retuns nothing
         */
        newPiece.teamColor = this.teamColor;
        this.PlayerPieces.add(newPiece);


    }

    @Override
    public String toString() {
        /**
         * toString displays the pieces in the Piece object depending on the size of the PLayerPieces in the ArrayList, a different
         *
         *
         * @return String: text shows the pieces in the Team object that this method is called on
         */

        int size = this.PlayerPieces.size();
        if (size == 1) {
            return ("Team " + this.teamColor + " Pieces :\n" + this.teamColor + " " + PlayerPieces.get(0).getSymbol() + "\n");
        } else if (size == 2) {
            return ("Team " + this.teamColor + " Pieces :\n" + this.teamColor + " " + PlayerPieces.get(0).getSymbol() + " " + this.teamColor + " " + PlayerPieces.get(1).getSymbol() + "\n");
        } else if (size == 3) {
            return ("Team " + this.teamColor + " Pieces :\n" + this.teamColor + " " + PlayerPieces.get(0).getSymbol() + " " + this.teamColor + " " + PlayerPieces.get(1).getSymbol() + " " + this.teamColor + " " + PlayerPieces.get(2).getSymbol() + "\n");
        } else if (size ==4){
            return("Team " + this.teamColor + " Pieces :\n" + this.teamColor + " " + PlayerPieces.get(0).getSymbol() + " " + this.teamColor + " " + PlayerPieces.get(1).getSymbol() + " " + this.teamColor + " " + PlayerPieces.get(2).getSymbol() + " " + this.teamColor + " " + PlayerPieces.get(3).getSymbol() +"\n");
        }else {
            return ("Team " + this.teamColor + " Pieces :\n" + this.teamColor + " " + PlayerPieces.get(0).getSymbol() + " " + this.teamColor + " " + PlayerPieces.get(1).getSymbol() + " " + this.teamColor + " " + PlayerPieces.get(2).getSymbol() + " " + this.teamColor + " " + PlayerPieces.get(3).getSymbol() + " " + this.teamColor + " " + PlayerPieces.get(4).getSymbol() +"\n");

        }
    }
}


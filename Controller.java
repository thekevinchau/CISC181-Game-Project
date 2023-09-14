import java.util.ArrayList;

public class Controller {
    /**
     * Controller class, in charge of running the game itself
     * Uses the TextView class to update the view of the game as actions are made
     * The game is set up with the setUpGameModel method and is played with the playGame method
     * main method is included in order to run everything
     *
     * @author: Philip Stoyanov
     * @version: 1.0
     */

    GameS22 game;
    TextView view;

    public GameS22 setUpGameModel() {
        /**
         * Sets up the teams for the teams Red and Blue, 4 Pieces to a team, each one at a different location, they are loaded
         * into an array and are loaded into the new game
         *
         * @return GameS22: new game with the pieces loaded onto it
         */
        // Create 4 pieces for team A

        // Load the pieces in an ArrayList
        ArrayList<Piece> piecesTeamA = new ArrayList<>();
        piecesTeamA.add(new PieceMinion('M', "Blu",
                0, 0, false, true));
        piecesTeamA.add(new PieceBuzz('B', "Blu", 2, 1,
                true, false, true));
        piecesTeamA.add(new PieceBlueHen('H', "Blu", 3,
                9, false, true));
        piecesTeamA.add(new PieceEvilMinion('E', "Blu", 1,
                1, 4, false, true));
        piecesTeamA.add(new PiecePlankton('P', "Blu", 1,
                false, true));
        // Create a team object
        Team teamA = new Team("Blu", piecesTeamA);

        // Create 4 pieces for team B
        // Load the pieces in an ArrayList
        ArrayList<Piece> piecesTeamB = new ArrayList<>();
        piecesTeamB.add(new PieceMinion('M', "Red",
                0, 0, false, true));
        piecesTeamB.add(new PieceBlueHen('H', "Red", 3,
                9, false, true));
        piecesTeamB.add(new PieceBuzz('B', "Red", 2, 1,
                true, false, true));
        piecesTeamB.add(new PieceEvilMinion('E', "Red", 1,
                1, 4, false, true));

        // Create a team object
        Team teamB = new Team("Red", piecesTeamB);


        // Create an instance of the game
        return new GameS22(8, 8, teamA, teamB);
    }

    public Controller() {
        /**
         * constructs Controller object, calling the setUpGameModel method to set up the game, sets up four bombs, sets up a TextView and
         * updates its to match the game
         */
        game = setUpGameModel();
        for (int i = 0; i < 4; i++){
            game.getGameBoard().plantMine();
        }
        view = new TextView();
        view.updateView(game);

    }

    public void carryOutAction(int fromSquareRow, int fromSquareCol, int toSquareRow, int toSquareCol, char actionType) {
        /**
         * takes letter, and depending on what letter is inputted, the Piece will either move, attack, spawn, or recruit
         *
         * @param int fromSquareRow: row the piece is on before action is carried out
         * @param int fromSquareCol: column the piece is on before action is carried out
         * @param int toSquareRow: row the piece is on after action is carried out
         * @param int toSquareCol: column the piece is on after action is carried out
         * @param char actionType: action the piece is to carry out
         */
        actionType = Character.toUpperCase(actionType);
        Action action;
        if (actionType == 'A') {
            action = new ActionAttack(game, fromSquareRow, fromSquareCol, toSquareRow, toSquareCol);
            action.performAction();
        }
        if (actionType == 'M') {
            action = new ActionMove(game, fromSquareRow, fromSquareCol, toSquareRow, toSquareCol);
            action.performAction();
            }
        if(actionType == 'R') {
            action = new ActionRecruit(game, fromSquareRow, fromSquareCol, toSquareRow, toSquareCol);
            action.performAction();
        }
        if(actionType == 'S') {
            action = new ActionSpawn(game, fromSquareRow, fromSquareCol, toSquareRow, toSquareCol);
            action.performAction();
        }
        if(actionType == 'K') {
            action = new ActionKaren(game, fromSquareRow, fromSquareCol, toSquareRow, toSquareCol);
            action.performAction();
        }

    }

    public void playGame() {
        /**
         * loop to check if game ended
         * inside loop, ask user to take their getNextPlayerAction from TextView class
         * check if action is valid with Rules
         * if valid, carry out, call updateview
         * if not, keep going through it
         * if yes, print endOfGame
         */
        boolean validMove = false;
        PieceBomb bomb = new PieceBomb();

        while (!game.isGameEnded()) {
            validMove = false;
            while (!validMove) {
                view.getNextPlayersAction(game);
                System.out.println("Checking Rules");
                if (Rules.checkValidAction(game, view.getFromSquareRow(), view.getFromSquareCol(), view.getToSquareRow(), view.getToSquareCol(), view.getActionType())) {
                    validMove = true;
                }
            }
            carryOutAction(view.getFromSquareRow(), view.getFromSquareCol(), view.getToSquareRow(), view.getToSquareCol(), view.getActionType());
            if (game.getBoardSquares()[view.getToSquareRow()][view.getToSquareCol()].checkBomb()
                    && !game.getBoardSquares()[view.getToSquareRow()][view.getToSquareCol()].isEmpty()){
                game.getOpponentTeam().removePieceFromTeam(game.getBoardSquares()[view.getToSquareRow()][view.getToSquareCol()].getPiece());
                game.getBoardSquares()[view.getToSquareRow()][view.getToSquareCol()].removePiece();
                game.getBoardSquares()[view.getToSquareRow()][view.getToSquareCol()].setPiece(bomb);
                System.out.println("Your piece was destroyed by a land mine!");
            }
            view.updateView(game);
        }
            view.printEndOfGameMessage(game);
        }




    public static void main(String[] args) {
        /**
         * main method, sets up game using Controller object
         */
        Controller game = new Controller();
        game.playGame();
    }
}





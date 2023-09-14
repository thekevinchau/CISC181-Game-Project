public class    PiecePlankton extends Piece implements Attacker{
    protected GameBoard board;
    private char symbol;
    private String teamColor;
    private int numAttacks;
    private boolean hidden;
    private boolean original;


    @Override
    public  boolean validAttackPath (int fromRow,int fromColumn,
                                     int toRow,int toColumn)
    {
        /**
         * @returns a boolean, false as this piece cannot attack
         */
        return false;
    }
    @Override
    public  boolean validSpawnPath (int fromRow,int fromColumn,
                                    int toRow,int toColumn)
    {
        /**
         * return a boolean, false as this piece ccnnot spawn
         * @param not used but there are 4 ints, 2 representing the from board square and 2 ints representing the to square
         */
        return false;
    }
    public PiecePlankton (char symbol,
                          String teamColor,
                          int numAttacks,
                          boolean hidden, boolean original){
        /**
         * constructor for the plankton piece, calls the super piece class to set some of the parameters.
         */
        super(symbol, teamColor, hidden, original);
        this.symbol = super.symbol;
        this.teamColor = super.teamColor;
        this.hidden = super.hidden;
        this.original = super.original;

        this.numAttacks = numAttacks;


    }

    public PiecePlankton ()  {
        /**
         * constructor for plankton when no parameters are given
         */
        this('P',"NON",
                0,
                false,true);
    }
    @Override
    public char getSymbol() {
        /**
         * getter for the symbol. returns a char
         */
        return super.symbol;
    }
    @Override
    public String getTeamColor() {
        /**
         * getter for the Teamcolor, returns a String
         */
        return super.teamColor;
    }
    public int getNumAttacks()    {
        /**
         * getter for the number of attacks. returns an int
         */
        return this.numAttacks;
    }

    public boolean isHidden() {
        /**
         * getter for the boolean hidden
         */
        return this.hidden;
    }
    @Override
    public boolean isOriginal() {
        /**
         * getter for the original boolean
         */
        return this.original;
    }


    public void setSymbol(char symbol) {
        /**
         setter for the symbol
         */
        this.symbol = symbol;
    }
    public void setTeamColor(String teamColor) {
        /**
         * setter for the team color
         */
        this.teamColor = teamColor;
    }
    @Override
    public void setNumAttacks(int numAttacks)    {
        /**
         setter for the number of attacks
         */
        this.numAttacks = numAttacks;
    }

    public void setHidden(boolean hidden) {
        /**
         * setter for the  hidden boolean
         */
        this.hidden = hidden;
    }
    public void setOriginal(boolean original) {
        /**
         * setter for the original boolean
         */
        this.original = original;
    }

    public void speak(){
        /**
         * @returns nothing
         * @param none
         * just prints "Krabs!" whe called
         */
        System.out.println("Krabs!");
    }

    @Override
    public boolean validMovePath(int fromSquareRow, int fromSquareCol,
                                 int toSquareRow, int toSquareCol) {
        // You will implement this method in a later step
        // each Piece will have a different valid path
        if (fromSquareRow == toSquareRow) {
            if (fromSquareCol - 2 == toSquareCol || fromSquareCol - 1 == toSquareCol || fromSquareCol + 2 == toSquareCol || fromSquareCol + 1 == toSquareCol) {
                return true;
            }
        } else if (fromSquareCol == toSquareCol) {
            if (fromSquareRow - 2 == toSquareRow || fromSquareRow - 1 == toSquareRow || fromSquareRow + 2 == toSquareRow || fromSquareRow + 1 == toSquareRow) {
                return true;
            }

        }
        return false;
    }
    @Override
    public PiecePlankton spawn(){
        return null;
    }
    public boolean canSpawn() {
        return false;
    }






}





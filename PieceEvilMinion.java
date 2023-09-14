public class PieceEvilMinion extends PieceMinion implements Recruiter,Attacker{
    /**
     * sublclass of PieceMinion that creates an Evil Minion instead, adding the numAttacks and hungry field
     *
     * @author Philip Stoyanov
     * @version 1.0
     */

    private char symbol;
    private String teamColor;
    private int numRecruits;
    private int numAttacks;
    private int numTimesSpawned;
    private boolean hidden;
    private boolean original;
    private boolean hungry;

    final static int MAX_NUM_SPAWNED = 3;
    final static int MAX_ATTACKS = 4;

    public PieceEvilMinion(char symbol, String teamColor, int numRecruits, int numAttacks, int numTimesSpawned, boolean hidden, boolean original) {
        /**
         * no parameter constructor for PieceEvilMinion that set its fields to default values
         */

        super(symbol, teamColor, numRecruits, numTimesSpawned, hidden, original);
        this.symbol = super.symbol;
        this.teamColor = super.teamColor;
        this.numRecruits = super.numRecruits;
        this.numAttacks = numAttacks;
        this.numTimesSpawned = super.numTimesSpawned;
        this.hidden = super.hidden;
        this.original = super.original;
        this.numAttacks = numAttacks;
        updateHungry();
    }

    public PieceEvilMinion() {
        this('E', "NON", 0, 0, 0, false, true);
    }

    @Override
    public char getSymbol() {
        /**
         * accessor method to allow access to value of symbol
         *
         * @return char: value of symbol
         */

        return this.symbol;
    }

    public String getTeamColor() {
        /**
         * accessor method to allow access to value of teamColor
         *
         * @return String: value of teamColor
         */


        return this.teamColor;
    }

    public int getNumRecruits() {
/**
 * accessor method to allow access to value of numRecruits
 *
 * @return int: value of numRecruits
 */

        return this.numRecruits;
    }
    @Override
    public int getNumAttacks() {
        /**
         * accessor method to allow access to value of numAttacks
         *
         * @return int: value of numAttacks
         */

        return this.numAttacks;
    }

    public int getNumTimesSpawned() {
        /**
         * accessor method to allow access to value of numTimesSpawned
         *
         * @return int: value of numTimesSpawned
         */

        return this.numTimesSpawned;
    }

    public boolean isHidden() {
        /**
         * accessor method to allow access to value of hidden
         *
         * @return boolean: value of hidden (true or false)
         */

        return this.hidden;
    }

    public boolean isOriginal() {

        /**
         * accessor method to allow access to value of hidden
         *
         * @return boolean: value of original (true or false)
         */

        return this.original;
    }

    public boolean canSpawn() {
        /**
         * method to figure out whether Evil Minion can spawn or not, if the Minion is original and
         * it has not exceeded MAX_NUM_SPAWNED, then it can spawn
         *
         * @return boolean: if true, the Evil Minion can spawn a clone, if false, it cannot
         */

        if (this.original && this.numTimesSpawned < MAX_NUM_SPAWNED) {
            return true;
        } else {
            return false;
        }
    }

    public boolean canAttack() {
        /**
         * determines whether Evil Minion can attacked by seeing if it is hungry or not
         *
         * @return boolean: if hungry, Minion can attack, if not hungry, minion cannot attack
         */

        return this.hungry;
    }

    public void setSymbol(char symbol) {
        /**
         * mutator method that sets the value of symbol field
         *
         * @param char symbol: sets the value of the classes' symbol variable
         */

        this.symbol = symbol;
    }

    public void setTeamColor(String teamColor) {
        /**
         * mutator method that sets the value of teamColor field
         *
         * @param String teamColor: sets the value of the classes' teamColor variable
         */

        this.teamColor = teamColor;
    }
    @Override
    public void setNumAttacks(int numAttacks) {
        /**
         * mutator method that sets the value of numAttacks field
         *
         * @param int numAttacks: sets the value of the classes' numAttacks variable
         */

        this.numAttacks = numAttacks;
    }

    public void setNumRecruits(int numRecruits) {
        /**
         * mutator method that sets the value of numRecruits field
         *
         * @param int numRecruits: sets the value of the classes' numRecruits variable
         */

        this.numRecruits = numRecruits;
    }

    public void setNumTimesSpawned(int numTimesSpawned) {
        /**
         * mutator method that sets the value of numTimesSpawned field
         *
         * @param int numTimesSpawned: sets the value of the classes' numTimesSpawned variable
         */

        this.numTimesSpawned = numTimesSpawned;
    }

    public void setOriginal(boolean original) {
        /**
         * mutator method that sets the value of original field
         *
         * @param boolean original: sets the value of the classes' original variable
         */

        this.original = original;
    }

    public void setHidden(boolean hidden) {
        /**
         * mutator method that sets the value of hidden field
         *
         * @param boolean hidden: sets the value of the classes' hidden variable
         */

        this.hidden = hidden;
    }

    public void updateHungry() {
        /**
         * sets the value of hungry based on whether the Minion's number of attacks is less than MAX_ATTACKS constant,
         * if Minion's number of attacks is less, than hungry is set to true, else hungry is false
         *
         */

        if (this.numAttacks < MAX_ATTACKS) {
            this.hungry = true;
        } else {
            this.hungry = false;
        }
    }

    public void speak() {
        /**
         * Evil Minion says "Roar!"
         */

        System.out.println("Roar!");
    }

    public boolean validMovePath(int fromSquareRow, int fromSquareCol,
                                 int toSquareRow, int toSquareCol) {
        /**
         * determines whether Minion can move, not implemented in this class
         *
         * @return boolean: true
         */

        if (fromSquareCol == toSquareCol) {
            return true;
        } else if (fromSquareRow == toSquareRow && Math.abs(toSquareCol - fromSquareCol) == 2) {
            return true;
        }
        else{
            return false;
        }
    }

    public PieceEvilMinion spawn() {
        /**
         * creates a new Evil Minion, hungry is set by default to true, each time this method is ran, numTimesSpawned
         * increases by one
         *
         * @return PieceEvilMinion: new Evil Minion, taking symbol and teamColor from previous minion
         */

        this.symbol = Character.toLowerCase(this.symbol);
        PieceEvilMinion newSpawn = new PieceEvilMinion(this.symbol, this.teamColor, 1, 0, 0, false, false);
        this.hungry = true;
        numTimesSpawned++;
        return newSpawn;


    }

    @Override
    public  boolean validRecruitPath (int fromSquareRow,int toSquareRow,
                                      int fromSquareCol,int toSquareCol)
    {
        if (fromSquareCol == toSquareCol) {
            return true;
        } else if (fromSquareRow == toSquareRow && Math.abs(toSquareCol - fromSquareCol) == 2) {
            return true;
        }
        else{
            return false;
        }
    }
    @Override
    public boolean validSpawnPath(int fromSquareRow,int toSquareRow,
                                  int fromSquareCol,int toSquareCol){
        if (fromSquareCol == toSquareCol) {
            return true;
        } else if (fromSquareRow == toSquareRow && Math.abs(toSquareCol - fromSquareCol) == 2) {
            return true;
        }
        else{
            return false;
        }

    }
    @Override
    public  boolean validAttackPath (int gameRow,int GameColumn,
                                     int pRow,int pColumn)
    {
        return true;
    }
    public static void main(String[] args){
        PieceEvilMinion bob = new PieceEvilMinion('E',
                "Blu",4,2,3,
                true,false);
        System.out.println(bob.getNumTimesSpawned());
    }







}


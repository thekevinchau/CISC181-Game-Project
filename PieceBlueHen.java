public class PieceBlueHen extends Piece implements Attacker,Recruiter {
    protected char symbol;
    protected String teamColor;
    protected int numAttacks;
    protected int numRecruits;
    protected boolean hidden;
    protected boolean original;
    protected boolean flies;

    final public int MAX_NUM_ATTACKS = 3;


    public PieceBlueHen(char symbol,
                        String teamColor,
                        int numAttacks, int numRecruits,
                        boolean hidden, boolean original) {
        super(symbol, teamColor, hidden, original);
        this.symbol = super.symbol;
        this.teamColor = super.teamColor;
        this.hidden = super.hidden;
        this.original = super.original;

        this.numAttacks = numAttacks;
        this.numRecruits = numRecruits;
        updateFly();
    }

    public PieceBlueHen() {
        this('H', "NON",
                0, 0,
                false, true);
    }

    @Override
    public char getSymbol() {
        return super.symbol;
    }

    @Override
    public String getTeamColor() {
        return super.teamColor;
    }

    public int getNumAttacks() {
        return this.numAttacks;
    }

    public int getNumRecruits() {
        return this.numRecruits;
    }

    @Override
    public boolean isHidden() {
        return this.hidden;
    }

    @Override
    public boolean isOriginal() {
        return this.original;
    }

    public boolean canFly() {
        return this.flies;
    }

    public void setSymbol(char symbol) {
        this.symbol = symbol;
    }

    public void setTeamColor(String teamColor) {
        this.teamColor = teamColor;
    }

    @Override
    public void setNumAttacks(int numAttacks) {
        this.numAttacks = numAttacks;
        updateFly();
    }

    @Override
    public void setNumRecruits(int numRecruits) {
        this.numRecruits = numRecruits;
    }

    public void setHidden(boolean hidden) {
        this.hidden = hidden;
    }

    public void setOriginal(boolean original) {
        this.original = original;
    }

    private void updateFly() {
        if (this.numAttacks < MAX_NUM_ATTACKS) {
            this.flies = true;
        } else {
            this.flies = false;
        }
    }

    public void speak() {
        System.out.println("Go UD!");
    }

    @Override
    public boolean validMovePath(int fromSquareRow, int fromSquareCol,
                                 int toSquareRow, int toSquareCol) {
        if (this.flies == true) {
            return true;
        } else if (this.flies == false && Math.abs(toSquareRow - fromSquareRow) == 1 && Math.abs(toSquareCol - fromSquareCol) == 1) {
            return true;
        } else {
            return false;
        }


    }
    @Override
    public boolean validAttackPath(int fromSquareRow, int fromSquareCol,
                                   int toSquareRow, int toSquareCol){
        if (this.flies == true) {
            return true;
        }
        else if(this.flies == false && fromSquareRow == toSquareRow && Math.abs(toSquareRow - fromSquareRow) == 1){
            return true;
        }
        else{
            return false;
        }
    }
    @Override
    public boolean validRecruitPath(int fromSquareRow, int fromSquareCol,
                                    int toSquareRow, int toSquareCol) {
        if (this.flies == true){
            return true;
        }
        else if (this.flies == false && fromSquareCol == toSquareCol && Math.abs(toSquareCol - fromSquareCol) == 1) {
            return true;
        }
        else{
            return false;
        }
    }

    @Override
    public PieceBlueHen spawn()    {
        PieceBlueHen copyHen =
                new PieceBlueHen(Character.toLowerCase(this.symbol),
                        this.teamColor,this.numAttacks,this.numRecruits,
                        false,false);
        return copyHen;
    }

    public boolean validSpawnPath(int fromSquareRow, int fromSquareCol,
                                  int toSquareRow, int toSquareCol){
        if (this.flies == true){
            return true;
        }
        else if(this.flies == false && Math.abs(toSquareRow - fromSquareRow) == 1 && Math.abs(toSquareCol - fromSquareCol) == 1){
            return true;
        }
        else{
            return false;
        }
    }
}



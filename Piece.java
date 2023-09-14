public abstract class Piece {
    protected char symbol;
    protected String teamColor;
    protected boolean hidden;
    protected boolean original;

    public Piece (char symbol, String teamColor, boolean hidden, boolean original){
        this.symbol = symbol;
        this.teamColor = teamColor;
        this.hidden = hidden;
        this.original = original;
    }
    public char getSymbol(){
        return this.symbol;
    }
    public String getTeamColor(){
        return this.teamColor;
    }
    public boolean isHidden(){
        return this.hidden;
    }

    public boolean isOriginal(){
        return this.original;
    }
    public void setSymbol(){
        this.symbol = symbol;
    }
    public void setTeamColor(){
        this.teamColor = teamColor;
    }
    public void setHidden(){
        this.hidden = hidden;
    }
    public void setOriginal(){
        this.original = original;
    }
    public abstract Piece spawn();

    public abstract void speak();

    public abstract boolean validMovePath(int fromSquareRow, int fromSquareCol,
                                 int toSquareRow, int toSquareCol);

    public abstract boolean validSpawnPath(int fromSquareRow, int fromSquareCol,
                                           int toSquareRow, int toSquareCol);
    @Override
    public String toString(){
        return this.teamColor + " " + this.symbol;
    }


}

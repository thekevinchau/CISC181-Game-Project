public interface Attacker {
    /**
     * this is an interface that consists of 3 abstract methods
     *
     * @author Paul kearney
     * @version 1.0
     */
    public abstract int getNumAttacks();
    public abstract void setNumAttacks(int recruits);
    public abstract boolean validAttackPath (int gameRow,int GameColumn,
                                             int pRow,int pColumn);

}

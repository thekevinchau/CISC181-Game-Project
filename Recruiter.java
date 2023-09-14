public interface Recruiter {
    /**
     * this is an interface that consists of 3 abstract methods
     * @author Paul Kearney
     * @version 1.0
     */
    public abstract int getNumRecruits();
    public abstract void setNumRecruits(int recruits);
    public abstract boolean validRecruitPath (int gameRow,int GameColumn,
                                              int pRow,int pColumn);

}



public class GameS22 extends Game{
    public int who=0;
    public GameS22(int rows,int columns,Team a,Team b){
        super(rows,columns,a,b);
    }
    @Override
    public boolean isAWinner(){
        // we have to figure out what this is/ask discord
        return true;
    }
    @Override
    public Team getWinner(){
        //if(isGameEnded()==true) {
        if (one.getTeamPieces().size() <= 0) {
            return two;

        } else if (two.getTeamPieces().size() <= 0) {
            return one;
        } else {
            return null;
        }
        // }
    }
    public boolean isGameEnded(){
        if((one.getTeamPieces().size() <= 0)||two.getTeamPieces().size() <= 0){
            return true;
        }else {
            return false;
        }
    }

}


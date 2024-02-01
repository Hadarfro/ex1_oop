public class King extends ConcretePiece {
private Position kingPosition;

public King (){

}
    public King(Player owner,Position kingPosition, int numPiece){
       super(owner,"♔",kingPosition,numPiece,0);
     this.kingPosition = kingPosition;
    }

    public Position getKingPosition(){
        return this.kingPosition;
    }
    public void setNumKill(){
        this.setNumKills(0);
    }
    public void setKingPosition(int col,int row){//hadar add************************************
    this.kingPosition = new Position(col,row);
    }
}

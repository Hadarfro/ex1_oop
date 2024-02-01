public class Pawn extends ConcretePiece{
    private Position pawnPosition;
    private int numKill;


    public Pawn(Player owner, Position pawnPosition,int numPiece){
        super(owner,"♙",pawnPosition,numPiece,0);
        this.pawnPosition = pawnPosition;
         this.numKill = 0;
    }
    public Position getPawnPosition(){
        return this.pawnPosition;
    }



}

import java.util.ArrayList;
import java.util.List;

public abstract class  ConcretePiece implements Piece{
    private Player owner;
    private String typePiece; // king or pawn
    private Position piecePosition;
    private int numPiece;
    private int numKill;
    private List<Position> moveHistory;



    public ConcretePiece(){
        owner = this.getOwner();
        typePiece = this.getType();
        piecePosition = this.getPiecePosition();
        numPiece = this.getNumPiece();
        numKill = this.getNumKills();
        moveHistory= new ArrayList<>();
    }

    public ConcretePiece(Player player,String typePiece,Position piecePosition, int numPiece,int numKill){
        this.owner = player;
        this.typePiece = typePiece;
        this.piecePosition = piecePosition;
        this.numPiece= numPiece;
        this.numKill = 0;
        this.moveHistory= new ArrayList<>();
    }

    @Override
    public Player getOwner() {
        Player p = this.owner;
        return p;
    }

    @Override
    public String getType() {
        if("♔".equals(this.typePiece)){
            return "♔";
        }
        if ("♙".equals(this.typePiece)){
            return "♙";
        }
        return "";
    }

    public Position getPiecePosition(){
        return this.piecePosition;
    }

    public int getNumPiece(){
        return this.numPiece;
    }

    public int getNumKills(){
        return this.numKill;
    }

    public void setNumKills(int num){
         this.numKill += num;
    }

    public List<Position> getMoveHistory() {
        return this.moveHistory;
    }

    public int getTotalDistance() {
        int totalDistance = 0;

        for (int i = 1; i < moveHistory.size(); i++) {
            Position currentPosition = moveHistory.get(i);
            Position previousPosition = moveHistory.get(i - 1);
            totalDistance += calculateDistance(previousPosition, currentPosition);
        }

        return totalDistance;
    }

    public int calculateDistance(Position position1, Position position2) {
        return Math.abs(position1.getX() - position2.getX()) + Math.abs(position1.getY() - position2.getY());
    }

}



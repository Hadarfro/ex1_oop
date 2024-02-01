import java.util.ArrayList;
public class PositionComparator {
    private ArrayList<ConcretePiece> pieces_stepped;

    private Position pos;


    public PositionComparator(int row, int col) {
        pieces_stepped = new ArrayList<>();
        this.pos = new Position(row, col);
    }


    public Position getpos() {
        return pos;
    }


    public int getNumOfPieces() {
        return pieces_stepped.size();
    }


}



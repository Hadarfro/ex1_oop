import java.util.Comparator;

public class KillComparator implements Comparator<ConcretePiece> {

    @Override
    public int compare(ConcretePiece piece1, ConcretePiece piece2) {
        // Compare based on the number of kills in descending order
        int killsComparison = Integer.compare(piece2.getNumKills(), piece1.getNumKills());
        if (killsComparison != 0) {
            return killsComparison;
        }

        // If kills are equal, compare based on the piece number in ascending order
        int pieceNumberComparison =  Integer.compare(piece1.getNumPiece(),piece2.getNumPiece());
        if (pieceNumberComparison != 0) {
            return pieceNumberComparison;
        }

        // If piece numbers are equal, compare based on the winning player
        return Boolean.compare(piece1.getOwner().isPlayerOne(), piece2.getOwner().isPlayerOne());
    }
}
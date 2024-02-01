import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class DistanceComparator implements Comparator<ConcretePiece> {

    @Override
    public int compare(ConcretePiece piece1, ConcretePiece piece2) {
        // Compare based on the total distance moved in descending order
        int distanceComparison = Integer.compare(piece2.getTotalDistance(), piece1.getTotalDistance());
        if (distanceComparison != 0) {
            return distanceComparison;
        }

        // If distances are equal, compare based on the piece number in ascending order
        int pieceNumberComparison = Integer.compare(piece1.getNumPiece(), piece2.getNumPiece());
        if (pieceNumberComparison != 0) {
            return pieceNumberComparison;
        }

        // If piece numbers are equal, compare based on the winning player
        return Boolean.compare(piece1.getOwner().isPlayerOne(), piece2.getOwner().isPlayerOne());
    }
}
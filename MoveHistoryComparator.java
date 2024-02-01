import java.util.Comparator;
/**
 * Compares two positions based on their x and y values.
 * The comparison is performed first on the x values and then on the y values if necessary.
 *
 * @param position1 The first position to compare.
 * @param position2 The second position to compare.
 * @return A negative integer, zero, or a positive integer as the first position is less than, equal to,
 *         or greater than the second position, respectively.
 */
public class MoveHistoryComparator implements Comparator<ConcretePiece> {

    @Override
    public int compare(ConcretePiece piece1, ConcretePiece piece2) {
        // Check for null objects
        if (piece1 == null && piece2 == null) {
            return 0; // Both are considered equal
        } else if (piece1 == null) {
            return -1; // Null is considered less than non-null
        } else if (piece2 == null) {
            return 1; // Non-null is considered greater than null
        }

        // Compare based on the number of positions in the move history
        int size1 = piece1.getMoveHistory().size();
        int size2 = piece2.getMoveHistory().size();

        // Use Integer.compare to handle the comparison
        return Integer.compare(size1, size2);
    }
}

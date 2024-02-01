import java.util.*;

public class GameLogic implements PlayableLogic {

    private ConcretePlayer firstPlayer;
    private ConcretePlayer secendPlayer;
    private Player currentPlayer;
    private King king;
    private ConcretePiece[][] board;
    private List<ConcretePiece> piecesList1;
    private List<ConcretePiece> piecesList2;
    private ArrayList<PositionComparator> positionsComp = new ArrayList<PositionComparator>();

    public GameLogic() {
        this.board = new ConcretePiece[11][11];
        this.firstPlayer = new ConcretePlayer(1);
        this.secendPlayer = new ConcretePlayer(2);
        this.currentPlayer = secendPlayer;
        this.king = new King(this.firstPlayer, new Position(5, 5), 7);
        this.piecesList1 = new ArrayList<>();
        this.piecesList2 = new ArrayList<>();
        initBoard();

    }
    public void initBoard() {// placing the board how it should be at the start
        initKing();
        initPawn();
    }
    public void initKing() { //placing the king at the start of the game
        Position kingPositionPlayer1 = new Position(5, 5);
        ConcretePiece player1King = this.king;
        int numPiece= player1King.getNumPiece();
        numPiece = 7;
        board[5][5] = player1King;
        addToPieceList1(player1King);
    }
    private void initPawn(){
        // Attacker pawns
        int pawnNumber = 1;
        for (int i = 3; i <= 7; i++) {
            ConcretePiece piece  = new Pawn(secendPlayer, new Position(i, 0), pawnNumber);
            placePiece(piece,piece.getPiecePosition());
            addToPieceList2(piece);
            pawnNumber++;
        }


        ConcretePiece piece1 = new Pawn(secendPlayer, new Position(5, 1), pawnNumber++);
        placePiece(piece1,piece1.getPiecePosition());
        addToPieceList2(piece1);

        ConcretePiece piece2= new Pawn(secendPlayer, new Position(0, 3), pawnNumber++);
        placePiece(piece2,piece2.getPiecePosition());
        addToPieceList2(piece2);

        ConcretePiece piece3 = new Pawn(secendPlayer, new Position(10, 3), pawnNumber++);
        placePiece(piece3,piece3.getPiecePosition());
        addToPieceList2(piece3);

        ConcretePiece piece4 = new Pawn(secendPlayer, new Position(0, 4), pawnNumber++);
        placePiece(piece4,piece4.getPiecePosition());
        addToPieceList2(piece4);

        ConcretePiece piece5 = new Pawn(secendPlayer, new Position(10, 4), pawnNumber++);
        placePiece(piece5,piece5.getPiecePosition());
        addToPieceList2(piece5);

        ConcretePiece piece6 = new Pawn(secendPlayer, new Position(0, 5), pawnNumber++);
        placePiece(piece6,piece6.getPiecePosition());
        addToPieceList2(piece6);

        ConcretePiece piece7 = new Pawn(secendPlayer, new Position(1, 5), pawnNumber++);
        placePiece(piece7,piece7.getPiecePosition());
        addToPieceList2(piece7);

        ConcretePiece piece8 = new Pawn(secendPlayer, new Position(9, 5), pawnNumber++);
        placePiece(piece8,piece8.getPiecePosition());
        addToPieceList2(piece8);

        ConcretePiece piece9 = new Pawn(secendPlayer, new Position(10, 5), pawnNumber++);
        placePiece(piece9,piece9.getPiecePosition());
        addToPieceList2(piece9);

        ConcretePiece piece10 = new Pawn(secendPlayer, new Position(0, 6), pawnNumber++);
        placePiece(piece10,piece10.getPiecePosition());
        addToPieceList2(piece10);

        ConcretePiece piece11 = new Pawn(secendPlayer, new Position(10, 6), pawnNumber++);
        placePiece(piece11,piece11.getPiecePosition());
        addToPieceList2(piece11);

        ConcretePiece piece12 = new Pawn(secendPlayer, new Position(0, 7), pawnNumber++);
        placePiece(piece12,piece12.getPiecePosition());
        addToPieceList2(piece12);

        ConcretePiece piece13 = new Pawn(secendPlayer, new Position(10, 7), pawnNumber++);
        placePiece(piece13,piece13.getPiecePosition());
        addToPieceList2(piece13);

        ConcretePiece piece14 = new Pawn(secendPlayer, new Position(5, 9), pawnNumber++);
        placePiece(piece14,piece14.getPiecePosition());
        addToPieceList2(piece14);

        for (int i = 3; i <= 7; i++) {
            ConcretePiece piece = new Pawn(secendPlayer, new Position(i, 10), pawnNumber);
            placePiece(piece,piece.getPiecePosition());
            addToPieceList2(piece);
            pawnNumber++;
        }


        // Defender pieces
        pawnNumber = 1;
        ConcretePiece piece15 = new Pawn(firstPlayer, new Position(5, 3), pawnNumber++);
        placePiece(piece15,piece15.getPiecePosition());

        ConcretePiece piece16 = new Pawn(firstPlayer, new Position(4, 4), pawnNumber++);
        placePiece(piece16,piece16.getPiecePosition());

        ConcretePiece piece17 = new Pawn(firstPlayer, new Position(5, 4), pawnNumber++);
        placePiece(piece17,piece17.getPiecePosition());

        ConcretePiece piece18 = new Pawn(firstPlayer, new Position(6, 4), pawnNumber++);
        placePiece(piece18,piece18.getPiecePosition());

        ConcretePiece piece19 = new Pawn(firstPlayer, new Position(3, 5), pawnNumber++);
        placePiece(piece19,piece19.getPiecePosition());

        ConcretePiece piece20 = new Pawn(firstPlayer, new Position(4, 5), pawnNumber++);
        placePiece(piece20,piece20.getPiecePosition());

        pawnNumber++;//hadar add**************************************************************

        ConcretePiece piece21 = new Pawn(firstPlayer, new Position(6, 5), pawnNumber++);
        placePiece(piece21,piece21.getPiecePosition());

        ConcretePiece piece22 = new Pawn(firstPlayer, new Position(7, 5), pawnNumber++);
        placePiece(piece22,piece22.getPiecePosition());

        ConcretePiece piece23 = new Pawn(firstPlayer, new Position(4, 6), pawnNumber++);
        placePiece(piece23,piece23.getPiecePosition());

        ConcretePiece piece24 = new Pawn(firstPlayer, new Position(5, 6), pawnNumber++);
        placePiece(piece24,piece24.getPiecePosition());

        ConcretePiece piece25 = new Pawn(firstPlayer, new Position(6, 6), pawnNumber++);
        placePiece(piece25,piece25.getPiecePosition());

        ConcretePiece piece26 = new Pawn(firstPlayer, new Position(5, 7), pawnNumber);
        placePiece(piece26,piece26.getPiecePosition());


    }
    public void placePiece(ConcretePiece piece, Position position) {
        if (position.isValidPosition()) {
            board[position.getX()][position.getY()] = piece;

            if (piece.getOwner() == getFirstPlayer()) {
                addToPieceList1(piece);
            }
        }
    }


    //*****************************end init board ******************************


    @Override // code the killing of other piece
    public boolean move(Position a , Position b) {
        int positionX = a.getX(); //represent the current position that we are checking of x
        int positionY = a.getY();  //represent the current position that we are checking of y
        ConcretePiece piece = null;
        if(board[b.getX()][b.getY()]!=null){// if in position b there's a piece
            return false;
        }
        else if (a.getY()!=b.getY()&&a.getX()!=b.getX()){//if the player try to move diagonally
            return false;
        }
        else if(a.getY()==b.getY()&&a.getX()==b.getX()){//if position a and position b are the same position
            return true;
        }
        else if (!a.isValidPosition()||!b.isValidPosition()){// if one of the positions aren't on the board
            return false;
        }
        else if(!board[a.getX()][a.getY()].getOwner().equals(getCurrentPlayer())||getPieceAtPosition(a)==null){//if it's not a's piece turn return false or there is no piece at a's position
            return false;
        }
        else if (!board[positionX][positionY].getType().equals("♔")&&((b.getX()==0&&b.getY()==0)||(b.getX()==0&&
                b.getY()==10)||(b.getX()==10&&b.getY()==0)||(b.getX()==10&&b.getY()==10))) {//if the piece want to go to the corners
            return false;
        }
        //while there is no piece in the way to position b and that we didn't make it to position b
        while (piece == null && positionY != b.getY() || positionX != b.getX()) {
            if(positionX == b.getX() && positionY < b.getY()){//if we are on the x-axis and bellow the y of b's position
                positionY++;
            }
            else if(positionX == b.getX() && positionY > b.getY()){//if we are on the x-axis and above the y of b's position
                positionY--;
            }
            else  if(positionY == b.getY() && positionX < b.getX()){//if we are on the y-axis and bellow the x of b's position
                positionX++;
            }
            else if(positionY == b.getY() && positionX > b.getX()){//if we are on the y-axis and above the x of b's position
                positionX--;
            }
            piece = board[positionX][positionY];
        }
        if (positionY == b.getY() && positionX == b.getX()) {//if we make it to b's position with no pieces in the way
           // if(isGameFinished()){//put func that print what we want
              //  if(firstPlayerWin()){
             //       this.firstPlayer.setWins();
             //   }
             //   else if(secondPlayerWin()){
             //       this.secendPlayer.setWins();
            //    }
             //   reset();
          //  }
            board[positionX][positionY] = board[a.getX()][a.getY()];
            board[a.getX()][a.getY()] = null;
            eatingPiece(positionX,positionY);
            // shira's add ******************
            //add to history move for every piece

            ConcretePiece bPiece= getCPieceAtPosition(b);
            if (bPiece.getMoveHistory().isEmpty()) {
                addMoveHistory(bPiece, a);
                addMoveHistory(bPiece, b);
            }
            else {
                addMoveHistory(bPiece, b);
            }
           if (board[positionX][positionY].getType().equals("♔")){
               this.king.setKingPosition(positionX,positionY);
           }
            isGameFinished();
             return true;
        }
        else {
            return false;
        }
    }
    //hadar add to the eatingPiece func***********************************
    public void eatingPiece(int positionX, int positionY) {//get the piece that we want to check if he killed someone
        ConcretePiece piece = board[positionX][positionY];
        if (!piece.getType().equals("♔")) { //if it's not the king because the king can't eat another pawn
            Position pos1 = new Position(positionX + 1, positionY);
            Position pos2 = new Position(positionX - 1, positionY);
            Position pos3 = new Position(positionX, positionY + 1);
            Position pos4 = new Position(positionX, positionY - 1);
            if (positionX + 1 < 11) {
                if (board[positionX + 1][positionY] != null && pos1.isValidPosition()) {
                    if (!piece.getOwner().equals(board[positionX + 1][positionY].getOwner())) {
                        if (checkNeighbour(positionX + 1, positionY)) {
                            if (board[positionX + 1][positionY].getType().equals("♔")){
                                isGameFinished();
                                reset();
                                return;
                            }
                            board[positionX + 1][positionY] = null;
                            piece.setNumKills(1);
                        }
                    }
                }
            }
            if (positionX - 1 > -1) {
                if (board[positionX - 1][positionY] != null && pos2.isValidPosition()) {
                    if (!piece.getOwner().equals(board[positionX - 1][positionY].getOwner())) {
                        if (checkNeighbour(positionX - 1, positionY)) {
                            if (board[positionX - 1][positionY].getType().equals("♔")){
                                isGameFinished();
                                reset();
                                return;
                            }
                            board[positionX - 1][positionY] = null;
                            piece.setNumKills(1);
                        }
                    }
                }
            }
            if (positionY + 1 < 11) {
                if (board[positionX][positionY + 1] != null && pos3.isValidPosition()) {
                    if (!piece.getOwner().equals(board[positionX][positionY + 1].getOwner())) {
                        if (checkNeighbour(positionX, positionY + 1)) {
                            if (board[positionX][positionY+1].getType().equals("♔")){
                                isGameFinished();
                                reset();
                                return;
                            }
                            board[positionX][positionY + 1] = null;
                            piece.setNumKills(1);
                        }
                    }
                }
            }
            if (positionY - 1 > -1) {
                if (board[positionX][positionY - 1] != null && pos4.isValidPosition()) {
                    if (!piece.getOwner().equals(board[positionX][positionY - 1].getOwner())) {
                        if (checkNeighbour(positionX, positionY - 1)) {
                            if (board[positionX][positionY-1].getType().equals("♔")){
                                isGameFinished();
                                reset();
                                return;
                            }
                            board[positionX][positionY - 1] = null;
                            piece.setNumKills(1);
                        }
                    }
                }
            }
        }
        changeTurn();
    }

    public boolean checkKingNeighbour(int posX, int posY) {
        if (posX == 0) {
            if (board[posX + 1][posY] != null && board[posX][posY + 1] != null && board[posX][posY - 1] != null) {
                if (!board[posX + 1][posY].getOwner().isPlayerOne() && !board[posX][posY + 1].getOwner().isPlayerOne() &&
                        !board[posX][posY - 1].getOwner().isPlayerOne()) {
                    return true;
                }
            }
        } else if (posX == 10) {
            if (board[posX - 1][posY] != null && board[posX][posY + 1] != null &&
                    board[posX][posY - 1] != null) {
                if (!board[posX - 1][posY].getOwner().isPlayerOne() && !board[posX][posY + 1].getOwner().isPlayerOne() &&
                        !board[posX][posY - 1].getOwner().isPlayerOne()) {
                    return true;
                }
            }
        } else if (posY == 0) {
            if (board[posX + 1][posY] != null && board[posX - 1][posY] != null &&
                    board[posX][posY + 1] != null) {
                if (!board[posX + 1][posY].getOwner().isPlayerOne() && !board[posX - 1][posY].getOwner().isPlayerOne() &&
                        !board[posX][posY + 1].getOwner().isPlayerOne()) {
                    return true;
                }
            }
        } else if (posY == 10) {
            if (board[posX + 1][posY] != null && board[posX - 1][posY] != null &&
                    board[posX][posY - 1] != null) {
                if (!board[posX + 1][posY].getOwner().isPlayerOne() && !board[posX - 1][posY].getOwner().isPlayerOne() &&
                        !board[posX][posY - 1].getOwner().isPlayerOne()) {
                    return true;
                }
            }
        } else if (board[posX + 1][posY] != null && board[posX - 1][posY] != null && board[posX][posY + 1] != null &&
                board[posX][posY - 1] != null) {
            if (!board[posX + 1][posY].getOwner().isPlayerOne() && !board[posX - 1][posY].getOwner().isPlayerOne() &&
                    !board[posX][posY - 1].getOwner().isPlayerOne() && !board[posX][posY + 1].getOwner().isPlayerOne()) {
                return true;
            }
        }
        return false;
    }

    //check the extreme case when the pawn is near the wall and pawn cant go to the corners
    public boolean checkNeighbour(int posX, int posY) {// return true if the piece in the position is eaten else return false
        if (board[posX][posY] == null) {
            return false;
        }
        int count = 0;
        Player myOwner = board[posX][posY].getOwner();
        int OpponnentLeftRight = 0;
        int OpponnentUpDown = 0;
        int countWall = 0;
        Position neighbour1 = new Position(posX + 1, posY);
        Position neighbour2 = new Position(posX - 1, posY);
        Position neighbour3 = new Position(posX, posY + 1);
        Position neighbour4 = new Position(posX, posY - 1);
        if (board[posX][posY].getType().equals("♔")) {// if the king might be eaten or winning
            if (checkKingNeighbour(posX, posY)) {
               // isGameFinished();
                return true;
            }
            return false;
        }
        if ((neighbour1.getX() > 10 || neighbour1.getX() < 0 ||
                neighbour1.getY() > 10 || neighbour1.getY() < 0)) {
            countWall++;
            OpponnentLeftRight++;

        } else if (board[posX + 1][posY] != null) {
            if (neighbour1.isValidPosition() && !board[posX + 1][posY].getType().equals("♔") &&
                    !myOwner.equals(board[posX + 1][posY].getOwner())) {//if the position is on the board and the two neighbours are opponents
                count++;
                OpponnentLeftRight++;
            }
        }
        if ((neighbour2.getX() > 10 || neighbour2.getX() < 0 || neighbour2.getY() > 10 ||
                neighbour2.getY() < 0)) {
            countWall++;
            OpponnentLeftRight++;


        } else if (board[posX - 1][posY] != null) {
            if (neighbour2.isValidPosition() && !board[posX - 1][posY].getType().equals("♔") && !myOwner.equals(board[posX - 1][posY].getOwner())) {
                count++;
                OpponnentLeftRight++;
            }
        }
        if ((neighbour3.getX() > 10 || neighbour3.getX() < 0 || neighbour3.getY() > 10 ||
                neighbour3.getY() < 0)) {
            countWall++;
            OpponnentUpDown++;

        } else if (board[posX][posY + 1] != null) {
            if (neighbour3.isValidPosition() && !board[posX][posY + 1].getType().equals("♔") && !myOwner.equals(board[posX][posY + 1].getOwner())) {
                count++;
                OpponnentUpDown++;
            }
        }
        if ((neighbour4.getX() > 10 || neighbour4.getX() < 0 || neighbour4.getY() > 10 ||
                neighbour4.getY() < 0)) {
            countWall++;
            OpponnentUpDown++;
        } else if (board[posX][posY - 1] != null) {
            if (neighbour4.isValidPosition() && !board[posX][posY - 1].getType().equals("♔") && !myOwner.equals(board[posX][posY - 1].getOwner())) {
                count++;
                OpponnentUpDown++;
            }
        }
        if (count > 2 | OpponnentUpDown == 2 || OpponnentLeftRight == 2 || (countWall + count > 2) ||
                (OpponnentLeftRight + countWall == 2) || (OpponnentUpDown + countWall == 2)) {
            return true;
        }
        return false;
    }

    public Player getCurrentPlayer(){ //finished
        return this.currentPlayer;
    }

    public void changeTurn(){// finished
        if (this.currentPlayer.equals(getFirstPlayer())){
            this.currentPlayer = getSecondPlayer();
        }
        else {
            this.currentPlayer = getFirstPlayer();
        }
    }


    //***************************end move*****************************************************


    @Override // finished
    public Piece getPieceAtPosition(Position position) {
        return board[position.getX()][position.getY()];
    }

    public ConcretePiece getCPieceAtPosition(Position position) {
        return board[position.getX()][position.getY()];
    }

    @Override  // finished
    public Player getFirstPlayer() {
        return this.firstPlayer;
    }

    @Override  // finished
    public Player getSecondPlayer() {
        return this.secendPlayer;
    }

    //*************************************************************************************************
    @Override
    public boolean isGameFinished() {//continue!!!!!

        if (firstPlayerWin()) {

            //SET WINS i++ !!!!
            //   printMoveHistory(getFirstPlayer(), iterator1);
            //   printMoveHistory(getSecondPlayer(), iterator2);

            printMoveHistory(getFirstPlayer());
            printMoveHistory(getSecondPlayer());
            printStars();  // *
            //
            printKill(getFirstPlayer());
            printKill(getSecondPlayer());
          //  System.out.println();
            printStars();
           // System.out.println();
            printSortedDistance(getFirstPlayer());
            printSortedDistance(getSecondPlayer());

            printStars();



            reset();
            return true;
        }
       else if (secondPlayerWin()) {

            //SET WINS i++ !!!!
            //    printMoveHistory(getSecondPlayer(),iterator2);
            //   printMoveHistory(getFirstPlayer(), iterator1);
            printMoveHistory(getSecondPlayer());
            printMoveHistory(getFirstPlayer());

            printStars();
            //     System.out.println();

            printKill(getSecondPlayer());
            printKill(getFirstPlayer());

            //System.out.println();
            printStars();
          //  System.out.println();

            printSortedDistance(getSecondPlayer());
            printSortedDistance(getFirstPlayer());

            printStars();



            printStars();
            reset();
            return true;
        }
        return false;
    }


    //**************************************** print- part 2 **************************************************************************

    public List<ConcretePiece> getPiecesList1() {
        return piecesList1;
    }

    public List<ConcretePiece> getPiecesList2() {
        return piecesList2;
    }

    public void addToPieceList1(ConcretePiece newPiece1) {
        getPiecesList1().add(newPiece1);
    }

    public void addToPieceList2(ConcretePiece newPiece2) {
        getPiecesList2().add(newPiece2);
    }


    //********* print move history ************************************

    public void printMoveHistory(Player player) {
        List<ConcretePiece> pieceList;

        if(player.isPlayerOne()){
            pieceList= piecesList1;
        }
        else {
            pieceList= piecesList2;
        }

        // Sort pieces based on move history sizes in ascending order
        pieceList.sort(new MoveHistoryComparator());

        // Print the sorted move history for the player's pieces
        printSortedMoveHistory(pieceList);

    }
    private void formatMoveHistory(Iterator<Position> moveHistoryIterator, StringBuilder stringBuilder) {
        while (moveHistoryIterator.hasNext()) {
            Position position = moveHistoryIterator.next();
            stringBuilder.append("(").append(position.getX()).append(", ").append(position.getY()).append(")");
        }
        stringBuilder.append("]");
    }

    private void printSortedMoveHistory(List<ConcretePiece> pieces) {
        // Iterate over the sorted pieces and print their move history
        Iterator<ConcretePiece> pieceIterator = pieces.iterator();

        while (pieceIterator.hasNext()) {
            ConcretePiece piece = pieceIterator.next();
            Iterator<Position> moveHistoryIterator = piece.getMoveHistory().iterator();

            StringBuilder output = new StringBuilder();

            if(piece.getMoveHistory().size() > 1 ) {
                if (piece.getOwner().isPlayerOne()) {
                    if (piece instanceof King) {
                        output.append("K").append(piece.getNumPiece()).append(":[");
                    }
                    else {
                        output.append("D").append(piece.getNumPiece()).append(":[");
                    }
                }
                else {
                    output.append("A").append(piece.getNumPiece()).append(":[");
                }
                // Check if the piece has a move history
                if (moveHistoryIterator.hasNext()) {
                    formatMoveHistory(moveHistoryIterator, output);
                }

                System.out.println(output);
            }

        }
    }
    public void addMoveHistory(ConcretePiece bPiece, Position aPos) {
        if (bPiece != null) {
            List<Position> moveHistory=  bPiece.getMoveHistory();
            bPiece.getMoveHistory().add(aPos);

        }
    }


    //******* print num of kill **************************************
    public void printKill(Player player) {
        List<ConcretePiece> pieceList;
        if(player.isPlayerOne()){
            pieceList= piecesList1;
        }
        else {
            pieceList= piecesList2;
        }

        // Sort the list of pieces using the custom comparator
        pieceList.sort(new KillComparator());

        // Print the sorted kill for the player's pieces
        printSortedKill(pieceList);


    }
    private void formatKill(StringBuilder stringBuilder, ConcretePiece piece) {
        // Append the piece identifier based on the owner
        if(piece.getNumKills()!=0) {//hadar add***********************************************************
            if (piece.getOwner().isPlayerOne()) {
                 if (piece instanceof King) {//hadar add*************************************************************
                    stringBuilder.append("K");
                 } //do nothing
            else {
                stringBuilder.append("D");
            }
        }
            else {
            stringBuilder.append("A");
        }

        // Append the number of kills
            stringBuilder.append(piece.getNumPiece()).append(": ").append(piece.getNumKills()).append(" kills");
        }

        // Add a newline at the end
        System.out.println();
        //   stringBuilder.append(System.lineSeparator());
    }
    private void printSortedKill(List<ConcretePiece> pieces) {
        // Create an iterator for the pieces list
        Iterator<ConcretePiece> pieceIterator = pieces.iterator();

        // Iterate over the sorted pieces and print their kills
        while (pieceIterator.hasNext()) {
            ConcretePiece piece = pieceIterator.next();
            StringBuilder output = new StringBuilder();
            formatKill(output, piece);
            System.out.print(output);
        }
    }



    //******* print distance of kill *********************************

    public void printSortedDistance(Player player) {
        List<ConcretePiece> pieceList;

        if(player.isPlayerOne()){
            pieceList= piecesList1;
        }
        else {
            pieceList= piecesList2;
        }

        // Sort the list of pieces using the custom comparator
        pieceList.sort(new DistanceComparator());

        // Print the sorted pieces based on distance
        printSortedDistancePieces(pieceList);
    }
    private void printSortedDistancePieces(List<ConcretePiece> pieces) {
        // Create an iterator for the pieces list
        Iterator<ConcretePiece> pieceIterator = pieces.iterator();

        // Iterate over the sorted pieces and print their information
        while (pieceIterator.hasNext()) {
            ConcretePiece piece = pieceIterator.next();
            int totalDistance = piece.getTotalDistance();

            // Print information only for pieces that moved at least one square
            if (totalDistance > 0) {
                if (piece.getOwner().isPlayerOne()) {
                    if (piece instanceof King) {
                        System.out.println(piece.getNumPiece() + "K" + ": " + totalDistance + " squares");
                    } else {
                        System.out.println(piece.getNumPiece() + "D" + ": " + totalDistance + " squares");
                    }
                } else {
                    System.out.println(piece.getNumPiece()+ "A" + ": " + totalDistance + " squares");
                }
            }
        }
    }

//*********************************************************position comparator**********************************

    private Comparator<PositionComparator> positionnumstepscompare = new Comparator<PositionComparator>() {
        @Override
        public int compare(PositionComparator o1, PositionComparator o2) {
            if(o1.getNumOfPieces()==o2.getNumOfPieces()){
                if (o1.getpos().getX()==o2.getpos().getY()) {
                    return Integer.compare(o2.getpos().getX(),o1.getpos().getX());
                }
                else {
                    return Integer.compare(o2.getpos().getY(),o1.getpos().getY());
                }

            }

            return  Integer.compare(o1.getNumOfPieces(),o2.getNumOfPieces());
        }
    };



    //*******************************************end*****************************************************
    public boolean firstPlayerWin() {//if the first player wins
        if (this.king.getKingPosition() == null) {
            return false;
        }
        int kingPosX = this.king.getKingPosition().getX();
        int kingPosY = this.king.getKingPosition().getY();
        if (kingPosX == 0 && kingPosY == 0) {
            return true;
        }
        if (kingPosX == 0 && kingPosY == 10) {
            return true;
        }
        if (kingPosX == 10 && kingPosY == 0) {
            return true;
        }
        if (kingPosX == 10 && kingPosY == 10) {
            return true;
        }
        return false;
    }

    public boolean secondPlayerWin() {
        if (this.king.getKingPosition()==null){
            return false;
        }
        int kingPosX = this.king.getKingPosition().getX();
        int kingPosY = this.king.getKingPosition().getY();
        if (checkNeighbour(kingPosX, kingPosY)) {
            return true;
        }
        return false;
    }


    //************************* is finish game **********************************************

    @Override
    public boolean isSecondPlayerTurn() {//finished
        if (!this.currentPlayer.isPlayerOne()){
            return false;
        }
        return true;
    }

    @Override  // finished
    public void reset() {// need to clear the rest of the matrix
        for (int i = 0; i < 11; i++){
            for(int j = 0; j < 11; j++){
                board[i][j] = null;
            }
        }
        this.currentPlayer = secendPlayer;
        initBoard();
    }


    @Override
    public void undoLastMove() {

    }

    @Override  // finished
    public int getBoardSize() {
        return 11;
    }

    public ConcretePiece[][] getBoard() {  // finished
        return this.board;
    }

    public Position getKingPosition() {
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++) {
                if (board[i][j] != null) {
                    if (board[i][j].getType().equals("♔")) {
                        return new Position(i, j);
                    }
                }
            }
        }
        return null;
    }

    public static void printStars() {
        for (int i = 0; i < 75; i++) {
            System.out.print("*");
        }
        System.out.println();
    }
}




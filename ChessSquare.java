public class ChessSquare {
    
    private final int row;
    private final int col;
    private final boolean isWhite;
    private ChessPiece currentPiece;
    
    public ChessSquare(int row, int col) {
        this.row = row;
        this.col = col;
        this.isWhite = (row + col) % 2 == 0;
    }

    public ChessSquare(int row, int col, ChessPiece currentPiece) {
        this(row, col);
        this.currentPiece = currentPiece;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    public boolean isWhite() {
        return isWhite;
    }
    
    public ChessPiece getCurrentPiece() {
        return currentPiece;
    }

    public void setCurrentPiece(ChessPiece currentPiece) {
        this.currentPiece = currentPiece;
    }

    @Override
    public String toString() {
        return "ChessSquare{" +
                "row=" + row +
                ", col=" + col +
                ", isWhite=" + isWhite +
                ", currentPiece=" + (currentPiece != null ? currentPiece.toString() : "None") +
                '}';
    }
}

public class Queen extends ChessPiece {

    private int xPosition;
    private int yPosition;
    private boolean isBlack;

    public Queen(int row, int col, boolean isBlack)
    {
        super(row,col);
        xPosition = row;
        yPosition = col;
        this.isBlack = isBlack;

        if (isBlack)
        {
            this.setPieceIcon("bQueen");
        }
        else
            this.setPieceIcon("wQueen");
    }
}

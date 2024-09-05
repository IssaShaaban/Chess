public class Rook extends ChessPiece {

    private int xPosition;
    private int yPosition;
    private boolean isBlack;

    public Rook(int row, int col, boolean isBlack)
    {
        super(row,col);
        xPosition = row;
        yPosition = col;
        this.isBlack = isBlack;

        if (isBlack)
        {
            this.setPieceIcon("bRook");
        }
        else
            this.setPieceIcon("wRook");
    }
}

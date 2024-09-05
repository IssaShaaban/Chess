public class Bishop extends ChessPiece {

    private int xPosition;
    private int yPosition;
    private boolean isBlack;

    public Bishop(int row, int col, boolean isBlack)
    {
        super(row,col);
        xPosition = row;
        yPosition = col;
        this.isBlack = isBlack;

        if (isBlack)
        {
            this.setPieceIcon("bBishop");
        }
        else
            this.setPieceIcon("wBishop");
    }
}

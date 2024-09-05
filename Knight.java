public class Knight extends ChessPiece {

    private int xPosition;
    private int yPosition;
    private boolean isBlack;

    public Knight(int row, int col, boolean isBlack)
    {
        super(row,col);
        xPosition = row;
        yPosition = col;
        this.isBlack = isBlack;

        if (isBlack)
        {
            this.setPieceIcon("bKnight");
        }
        else
            this.setPieceIcon("wKnight");
    }
}

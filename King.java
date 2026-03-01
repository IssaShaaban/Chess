public class King extends ChessPiece
{
    public King(int row, int col,boolean isBlack,ChessBoard board)
    {
        super(row,col,isBlack,board);

        if (isBlack)
        {
            this.setPieceIcon("bKing");
        }
        else
            this.setPieceIcon("wKing");
    }

    @Override
    public boolean isValidMove(int row, int col, int newRow, int newCol)
    {
        return (newRow == row && newCol == col - 1) ||
                (newRow == row && newCol == col + 1) ||
                (newRow == row - 1 && newCol == col - 1) ||
                (newRow == row - 1 && newCol == col) ||
                (newRow == row - 1 && newCol == col + 1) ||
                (newRow == row + 1 && newCol == col - 1) ||
                (newRow == row + 1 && newCol == col) ||
                (newRow == row + 1 && newCol == col + 1);
    }
}

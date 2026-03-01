public class Rook extends ChessPiece
{
    public Rook(int row, int col,boolean isBlack,ChessBoard board)
    {
        super(row,col,isBlack,board);

        if (isBlack)
        {
            this.setPieceIcon("bRook");
        }
        else
            this.setPieceIcon("wRook");
    }

    @Override
    public boolean isValidMove(int row, int col, int newRow, int newCol)
    {
        if (newRow == row)
        {
            if (col < newCol)
            {
                while (col < newCol)
                {
                    col++;
                    if (col == newCol)
                        return true;
                }
            }

            else if (col > newCol)
            {
                while (col > newCol)
                {
                    col--;
                    if (col == newCol)
                        return true;
                }
            }
        }

        if (newCol == col)
        {
            if (row < newRow)
            {
                while (row < newRow)
                {
                    row++;
                    if (row == newRow)
                        return true;
                }
            }

            else if (row > newRow)
            {
                while (row > newRow)
                {
                    row--;
                    if (row == newRow)
                        return true;
                }
            }
        }
        return false;
    }
}

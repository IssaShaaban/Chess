public class Queen extends ChessPiece
{
    public Queen(int row, int col,boolean isBlack,ChessBoard board)
    {
        super(row,col,isBlack,board);

        if (isBlack)
        {
            this.setPieceIcon("bQueen");
        }
        else
            this.setPieceIcon("wQueen");
    }

    private boolean rightUpDiagonal(int row, int col, int newRow, int newCol)
    {
        while (newRow < row && newCol > col)
        {
            row--;
            col++;

            if (row == newRow && col == newCol)
                return true;
        }
        return false;
    }

    private boolean leftDownDiagonal(int row, int col, int newRow, int newCol)
    {
        while (newRow > row && newCol < col)
        {
            row++;
            col--;

            if (row == newRow && col == newCol)
                return true;
        }
        return false;
    }

    private boolean rightDownDiagonal(int row, int col, int newRow, int newCol)
    {
        while (newRow > row && newCol > col)
        {
            row++;
            col++;

            if (row == newRow && col == newCol)
                return true;
        }
        return false;
    }

    private boolean leftUpDiagonal(int row, int col, int newRow, int newCol)
    {
        while (newRow < row && newCol < col)
        {
            row--;
            col--;

            if (row == newRow && col == newCol)
                return true;
        }
        return false;
    }

    private boolean verticalAndHorizontal(int row, int col, int newRow, int newCol)
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

    @Override
    public boolean isValidMove(int row, int col, int newRow, int newCol)
    {
        if (newRow < row && newCol > col)
            return rightUpDiagonal(row, col, newRow, newCol);

        if (newRow > row && newCol < col)
            return leftDownDiagonal(row, col, newRow, newCol);

        if (newRow > row && newCol > col)
            return rightDownDiagonal(row, col, newRow, newCol);

        if (newRow < row && newCol < col)
            return leftUpDiagonal(row,col,newRow,newCol);

        return verticalAndHorizontal(row,col,newRow,newCol);
    }
}

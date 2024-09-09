public class Bishop extends ChessPiece
{
    public Bishop(int row, int col,boolean isBlack,ChessBoard board)
    {
        super(row,col,isBlack,board);

        if (isBlack)
        {
            this.setPieceIcon("bBishop");
        }
        else
            this.setPieceIcon("wBishop");
    }

    @Override
    public boolean isValidMove(int row, int col, int newRow, int newCol)
    {
        if (blackTakingWhite(newRow, newCol) && getBoard().getBlacksTurn())
        {
            getBoard().setBlacksTurn(false);
            return bishopMove(row,col,newRow,newCol);
        }

        if (whiteTakingBlack(newRow, newCol) && !getBoard().getBlacksTurn())
        {
            getBoard().setBlacksTurn(true);
            return bishopMove(row,col,newRow,newCol);
        }

        return false;
    }

    private boolean rightUpDiagonal(int row, int col, int newRow, int newCol)
    {
        while (newRow < row && newCol > col)
        {
            row--;
            col++;
            if (row == newRow && col == newCol)
                return true;

            if (!(getBoard().getPieceAt(row, col) instanceof EmptyPiece))
                return false;
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

            if (!(getBoard().getPieceAt(row, col) instanceof EmptyPiece))
                return false;
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

            if (!(getBoard().getPieceAt(row, col) instanceof EmptyPiece))
                return false;
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

            if (!(getBoard().getPieceAt(row, col) instanceof EmptyPiece))
                return false;
        }
        return false;
    }

    private boolean bishopMove(int row, int col, int newRow, int newCol)
    {
        if (newRow < row && newCol > col)
            return rightUpDiagonal(row, col, newRow, newCol);

        if (newRow > row && newCol < col)
            return leftDownDiagonal(row, col, newRow, newCol);

        if (newRow > row && newCol > col)
            return rightDownDiagonal(row, col, newRow, newCol);

        if (newRow < row && newCol < col)
            return leftUpDiagonal(row,col,newRow,newCol);

        return false;
    }
}

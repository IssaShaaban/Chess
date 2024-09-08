import java.awt.event.ActionEvent;

public class Knight extends ChessPiece
{
    public Knight(int row, int col,boolean isBlack,ChessBoard board)
    {
        super(row,col,isBlack,board);

        if (isBlack)
        {
            this.setPieceIcon("bKnight");
        }
        else
            this.setPieceIcon("wKnight");
    }
    @Override
    public boolean isValidMove(int row, int col, int newRow, int newCol)
    {
        if (blackTakingWhite(newRow,newCol))
            return knightMove(row,col,newRow,newCol);

        else if (whiteTakingBlack(newRow,newCol))
            return knightMove(row,col,newRow,newCol);

        return false;
    }

    private boolean knightMove(int row, int col, int newRow, int newCol)
    {
        return (newRow == row - 2 && newCol == col - 1) ||
                (newRow == row - 2 && newCol == col + 1) ||
                (newRow == row - 1 && newCol == col - 2) ||
                (newRow == row - 1 && newCol == col + 2) ||
                (newRow == row + 1 && newCol == col - 2) ||
                (newRow == row + 1 && newCol == col + 2) ||
                (newRow == row + 2 && newCol == col - 1) ||
                (newRow == row + 2 && newCol == col + 1);
    }
}

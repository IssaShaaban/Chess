import java.awt.event.ActionEvent;

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
    public boolean isValidMove(int row, int col, int newRow, int newCol) {
        return false;
    }
}

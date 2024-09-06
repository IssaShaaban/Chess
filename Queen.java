import java.awt.event.ActionEvent;

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
}

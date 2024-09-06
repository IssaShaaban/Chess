import java.awt.event.ActionEvent;

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
}

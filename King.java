import java.awt.event.ActionEvent;

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
}

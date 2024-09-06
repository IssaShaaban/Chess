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
}

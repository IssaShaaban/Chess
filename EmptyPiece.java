import java.awt.event.ActionEvent;

public class EmptyPiece extends ChessPiece
{
    public EmptyPiece(int row, int col,ChessBoard board)
    {
        super(row,col,true,board);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        if (this.getBoard().getCurrentPiece() != null)
        {
            this.getBoard().setPiecePos(this.getRow(), this.getCol(), this.getBoard().getCurrentPiece());
            this.getBoard().setCurrentPiece(null);
        }
    }
}

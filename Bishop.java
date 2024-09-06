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
    public void actionPerformed(ActionEvent e)
    {
        if (this.getBoard().getCurrentPiece() == null)
            this.getBoard().setCurrentPiece(this);

        System.out.println("Pressed " + this.getClass().getName() + " " + this.getRow() + " " + this.getCol());
    }
}

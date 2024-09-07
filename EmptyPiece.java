import javax.swing.*;
import java.awt.event.ActionEvent;

public class EmptyPiece extends ChessPiece
{
    ChessPiece newPiece = null;
    public EmptyPiece(int row, int col,ChessBoard board)
    {
        super(row,col,true,board);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        if (this.getBoard().getCurrentPiece() != null)
        {
            newPiece = this.getBoard().getCurrentPiece();
            if (newPiece.isValidMove(newPiece.getRow(), newPiece.getCol(), this.getRow(), this.getCol()))
            {
                this.getBoard().setPiecePos(this.getRow(), this.getCol(), this.getBoard().getCurrentPiece());
                this.getBoard().setCurrentPiece(null);
            }
            else
                JOptionPane.showMessageDialog(this.getBoard(), "Invalid Move");

            newPiece = null;
        }
    }

    @Override
    public boolean isValidMove(int row, int col, int newRow, int newCol) {
        return false;
    }
}

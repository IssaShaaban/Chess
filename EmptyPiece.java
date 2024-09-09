import javax.swing.*;
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
            newPiece = getBoard().getCurrentPiece();
            if (newPiece.isValidMove(newPiece.getRow(), newPiece.getCol(), getRow(), getCol()))
            {
                getBoard().setBlacksTurn(!getBoard().getBlacksTurn());
                getBoard().setPiecePos(getRow(), getCol(), newPiece);
                getBoard().setCurrentPiece(null);
            }
            else
                JOptionPane.showMessageDialog(getBoard(), "Invalid " + newPiece.getClass().getName() + " move!");

            newPiece = null;
        }
        printDebug();
    }

    @Override
    public boolean isValidMove(int row, int col, int newRow, int newCol) {
        return false;
    }
}

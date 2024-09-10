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

            getBoard().checkState(newPiece.isBlack());
            newPiece = null;
        }

        if (getBoard().getIsInCheck().equals("black"))
        {
            System.out.println("In Check Black");
            getBoard().setIsInCheck("");
        }

        else if (getBoard().getIsInCheck().equals("white"))
        {
            System.out.println("In Check white");
        }
    }

    @Override
    public boolean isValidMove(int row, int col, int newRow, int newCol) {
        return false;
    }
}

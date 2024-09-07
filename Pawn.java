import javax.swing.*;
import java.awt.event.ActionEvent;

public class Pawn extends ChessPiece
{
    ChessPiece newPiece = null;
    public Pawn(int row, int col,boolean isBlack,ChessBoard board)
    {
        super(row,col,isBlack,board);

        if (isBlack)
        {
            this.setPieceIcon("bPawn");
        }
        else
            this.setPieceIcon("wPawn");
    }

    public void actionPerformed(ActionEvent e)
    {
        if (this.getBoard().getCurrentPiece() == this)
        {
            this.getBoard().unHighlight(this.getRow(),this.getCol());
            this.getBoard().setCurrentPiece(null);
        }

        else if (this.getBoard().getCurrentPiece() != null)
        {
            newPiece = this.getBoard().getCurrentPiece();
            if (newPiece != null && newPiece.isValidMove(newPiece.getRow(), newPiece.getCol(), this.getRow(), this.getCol()))
            {
                this.getBoard().setPiecePos(this.getRow(), this.getCol(), this.getBoard().getCurrentPiece());
                this.getBoard().setCurrentPiece(null);
            }
            else
                JOptionPane.showMessageDialog(this.getBoard(), "Invalid Move G");

            newPiece = null;
        }

        else if (this.getBoard().getCurrentPiece() == null)
        {
            this.getBoard().highlightPiece(this.getRow(),this.getCol());
            this.getBoard().setCurrentPiece(this);
        }

        System.out.println("Pressed " + this.getClass().getName() + " " + this.getRow() + " " + this.getCol());
    }

    @Override
    public boolean isValidMove(int row,int col,int newRow,int newCol)
    {
        if (this.isBlack() && !this.getBoard().getPieceAt(newRow,newCol).isBlack())
            return newRow == row - 1 && (newCol == col + 1 || newCol == col - 1);

        if (!this.isBlack() && this.getBoard().getPieceAt(newRow,newCol).isBlack())
            return newRow == row + 1 && (newCol == col + 1 || newCol == col - 1);

        if (row == 6 && this.isBlack())
            if ((newRow == row - 2 && newCol == col) || (newRow == row - 1 && newCol == col))
                return true;

        if (this.isBlack())
            return newRow == row - 1 && newCol == col;

        if (row == 1 && !this.isBlack())
            if ((newRow == row + 2 && newCol == col) || (newRow == row + 1 && newCol == col))
                return true;

        if (!this.isBlack())
            return newRow == row + 1 && newCol == col;

        return false;
    }
}

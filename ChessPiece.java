import javax.swing.*;
import java.awt.event.ActionEvent;

public class ChessPiece extends EmptyChessPiece
{
    private final Boolean isBlack;

    public ChessPiece(int row,int col,boolean isBlack,ChessBoard board)
    {
        super(row,col,board);
        this.isBlack = isBlack;
    }

    public ChessPiece(int row,int col,ChessBoard board)
    {
        super(row,col,board);
        isBlack = null;
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        if (isBlack == null) // Moving to an empty square
            {
                newPiece = getBoard().getCurrentPiece();
                if (newPiece != null)
                {
                    if (newPiece.pieceMove(newPiece.getRow(), newPiece.getCol(), getRow(), getCol()))
                    {
                        getBoard().setBlacksTurn(!getBoard().getBlacksTurn());
                        getBoard().setPiecePos(getRow(), getCol(), newPiece);
                        getBoard().setCurrentPiece(null);
                        newPiece = null;
                    }
                    else
                        JOptionPane.showMessageDialog(getBoard(), "Invalid " + newPiece.getClass().getName() + " move!");
                }
            }

        else if (!getBoard().getInCheck(isBlack()))
        {
            if (getBoard().getCurrentPiece() == this)
            {
                getBoard().unHighlight(this.getRow(),this.getCol());
                getBoard().setCurrentPiece(null);
            }

            else if (getBoard().getCurrentPiece() != null)
            {
                newPiece = getBoard().getCurrentPiece();
                if (newPiece.pieceMove(newPiece.getRow(), newPiece.getCol(), getRow(), getCol()))
                {
                    getBoard().setBlacksTurn(!getBoard().getBlacksTurn());
                    getBoard().setPiecePos(getRow(), getCol(), newPiece);
                }
                else
                    JOptionPane.showMessageDialog(getBoard(), "Invalid " + newPiece.getClass().getName() + " move!");

                newPiece = null;
            }

            else if (getBoard().getCurrentPiece() == null)
            {
                if (getBoard().getPieceAt(getRow(),getCol()).isBlack && getBoard().getBlacksTurn())
                {
                    getBoard().highlightPiece(getRow(),getCol());
                    getBoard().setCurrentPiece(this);
                }
                else if (!getBoard().getPieceAt(getRow(),getCol()).isBlack && !getBoard().getBlacksTurn())
                {
                    getBoard().highlightPiece(getRow(),getCol());
                    getBoard().setCurrentPiece(this);
                }
                else
                    JOptionPane.showMessageDialog(getBoard(), "It's " + (isBlack ? "White" : "Black") + "'s turn!");
            }
        }

        else
        {
            if (getBoard().getCurrentPiece() == this)
            {
                getBoard().unHighlight(this.getRow(),this.getCol());
                getBoard().setCurrentPiece(null);
            }

            else if (getBoard().getCurrentPiece() != null)
            {
                newPiece = getBoard().getCurrentPiece();
                if (newPiece.pieceMove(newPiece.getRow(), newPiece.getCol(), getRow(), getCol()))
                {
                    getBoard().setBlacksTurn(!getBoard().getBlacksTurn());
                    getBoard().setPiecePos(getRow(), getCol(), newPiece);
                }
                else if (newPiece.pieceMove(newPiece.getRow(), newPiece.getCol(), getRow(), getCol()) && getBoard().getInCheck(isBlack))
                {
                    JOptionPane.showMessageDialog(getBoard(), "Invalid " + newPiece.getClass().getName() + " move!");
                }
                else
                    JOptionPane.showMessageDialog(getBoard(), "Invalid " + newPiece.getClass().getName() + " move! King is in Check!!");

                getBoard().unHighlight(newPiece.getRow(),newPiece.getCol());
                newPiece = null;
                getBoard().setCurrentPiece(null);
            }

            else if (getBoard().getCurrentPiece() == null)
            {
                if (getBoard().getPieceAt(getRow(),getCol()).isBlack && getBoard().getBlacksTurn())
                {
                    getBoard().highlightPiece(getRow(),getCol());
                    getBoard().setCurrentPiece(this);
                }
                else if (!getBoard().getPieceAt(getRow(),getCol()).isBlack && !getBoard().getBlacksTurn())
                {
                    getBoard().highlightPiece(getRow(),getCol());
                    getBoard().setCurrentPiece(this);
                }
                else
                    JOptionPane.showMessageDialog(getBoard(), "It's " + (isBlack ? "White" : "Black") + "'s turn!");
            }
        }
    }

    public boolean pieceMove(int row, int col, int newRow, int newCol)
    {
        if (blackMove(newRow, newCol) || whiteMove(newRow, newCol))
            return isValidMove(row, col, newRow, newCol);

        return false;
    }

    public boolean isValidMove(int row, int col, int newRow, int newCol)
    {
        return false;
    }

    public Boolean isBlack()
    {
        return isBlack;
    }

    public boolean blackMove(int newRow, int newCol)
    {
        return (isBlack() && (getBoard().getPieceAt(newRow,newCol).isBlack() == null || !getBoard().getPieceAt(newRow, newCol).isBlack()));
    }

    public boolean whiteMove(int newRow, int newCol)
    {
        return (!isBlack() && (getBoard().getPieceAt(newRow,newCol).isBlack() == null ||getBoard().getPieceAt(newRow, newCol).isBlack()));
    }
}

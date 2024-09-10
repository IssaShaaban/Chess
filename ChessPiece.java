import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

public abstract class ChessPiece extends JButton implements ActionListener
{
    private final HashMap<String,Icon> icons;
    private int row, col;
    private final ChessBoard board;
    private final boolean isBlack;
    ChessPiece newPiece = null;
    ChessPiece inCheckAllowed = null;

    public ChessPiece(int row,int col,boolean isBlack,ChessBoard board)
    {
        this.addActionListener(this);
        this.row = row;
        this.col = col;
        this.board = board;
        this.isBlack = isBlack;
        icons = ChessIcons.getIcons();
    }

    public void actionPerformed(ActionEvent e)
    {
        if (getBoard().getIsInCheck().equals("black"))
        {
            System.out.println("In Check Black");
            getBoard().setIsInCheck("");
        }

        else if (getBoard().getIsInCheck().equals("white"))
        {
            System.out.println("In Check white");
        }

        if (getBoard().getCurrentPiece() == this)
        {
            getBoard().unHighlight(this.getRow(),this.getCol());
            getBoard().setCurrentPiece(null);
        }

        else if (getBoard().getCurrentPiece() != null)
        {
            newPiece = getBoard().getCurrentPiece();
            if (newPiece != null && newPiece.isValidMove(newPiece.getRow(), newPiece.getCol(),getRow(),getCol()))
            {
                getBoard().setBlacksTurn(!getBoard().getBlacksTurn());
                getBoard().setPiecePos(getRow(), getCol(), getBoard().getCurrentPiece());
            }
            else
                JOptionPane.showMessageDialog(getBoard(), "Invalid " + newPiece.getClass().getName() + " move!");

            getBoard().checkState(newPiece.isBlack());
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
            {
                String playerMove = "";
                if (isBlack) playerMove = "White";
                else playerMove = "Black";
                JOptionPane.showMessageDialog(getBoard(), "It's " + playerMove + "'s turn!");
            }
        }
    }

    public void setPieceIcon(String icon)
    {
        Icon useIcon = icons.get(icon);
        this.setIcon(useIcon);
    }

    public int getRow() {return row;}
    public int getCol() {return col;}

    public void setPosition(int row, int col)
    {
        this.row = row;
        this.col = col;
    }

    public ChessBoard getBoard()
    {
        return board;
    }

    public abstract boolean isValidMove(int row,int col,int newRow,int newCol);

    public boolean isBlack()
    {
        return isBlack;
    }

    public void printDebug()
    {
        System.out.println("Pressed " + this.getClass().getName() + " " + this.getRow() + " " + this.getCol());
    }

    public boolean blackTakingWhite(int newRow,int newCol)
    {
        return (isBlack() && (!getBoard().getPieceAt(newRow, newCol).isBlack() || getBoard().getPieceAt(newRow,newCol) instanceof EmptyPiece));
    }

    public boolean whiteTakingBlack(int newRow,int newCol)
    {
        return (!isBlack() && (getBoard().getPieceAt(newRow, newCol).isBlack() || getBoard().getPieceAt(newRow,newCol) instanceof EmptyPiece));
    }
}

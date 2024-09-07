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
                JOptionPane.showMessageDialog(this.getBoard(), "Invalid " + newPiece.getClass().getName() + " move!");

            newPiece = null;
            printDebug();
        }

        else if (this.getBoard().getCurrentPiece() == null)
        {
            this.getBoard().highlightPiece(this.getRow(),this.getCol());
            this.getBoard().setCurrentPiece(this);
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
}

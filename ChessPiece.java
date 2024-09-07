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
        if (this.getBoard().getCurrentPiece() == null)
        {
            this.getBoard().highlightPiece(this.getRow(),this.getCol());
            this.getBoard().setCurrentPiece(this);
        }

        System.out.println("Pressed " + this.getClass().getName() + " " + this.getRow() + " " + this.getCol());
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
}

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

public abstract class ChessPiece extends JButton implements ActionListener
{
    private final HashMap<String,Icon> icons;
    private int xPoisiton;
    private int yPoisiton;
    private boolean canMove = false;
    private ChessPiece currentPiece;

    public ChessPiece(int row,int col)
    {
        this.addActionListener(this);
        xPoisiton = row;
        yPoisiton = col;
        icons = ChessIcons.getIcons();
    }

    public void actionPerformed(ActionEvent e)
    {
        System.out.println("Pressed " + this.getClass().getName() + " " + this.getXPoisiton() + " " + this.getYPoisiton());
    }

    public void setPieceIcon(String icon)
    {
        Icon useIcon = icons.get(icon);
        this.setIcon(useIcon);
    }

    public int getXPoisiton()
    {
        return xPoisiton;
    }

    public int getYPoisiton()
    {
        return yPoisiton;
    }
}

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

public class ChessPiece extends JButton implements ActionListener
{
    private final HashMap<String,Icon> icons;
    private final int xPosition;
    private final int yPosition;
    private String icon;

    public ChessPiece(int row,int col)
    {
        xPosition = row;
        yPosition = col;
        this.addActionListener(this);
        icons = ChessIcons.getIcons();
    }

    public void actionPerformed(ActionEvent e)
    {
        System.out.println("Pressed " + icon + ":" + xPosition + "," + yPosition);
    }

    public void setPieceIcon(String icon)
    {
        Icon useIcon = icons.get(icon);
        this.icon = icon;
        this.setIcon(useIcon);
    }
}

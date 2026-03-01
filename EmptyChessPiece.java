import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

public abstract class EmptyChessPiece extends JButton implements ActionListener
{
    private int row, col;
    private final ChessBoard board;
    ChessPiece newPiece = null;
    public EmptyChessPiece(int row, int col, ChessBoard board)
    {
        this.addActionListener(this);
        this.row = row;
        this.col = col;
        this.board = board;
    }

    public void setPieceIcon(String icon)
    {
        Icon useIcon = ChessIcons.getIcons().get(icon);
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

    private static class ChessIcons
    {
        private static final HashMap<String, Icon> icons = new HashMap<>();

        private static Icon resizeIcon(ImageIcon icon)
        {
            Image img = icon.getImage();
            Image resizedImage = img.getScaledInstance(50, 50, Image.SCALE_SMOOTH);
            return new ImageIcon(resizedImage);
        }

        public static HashMap<String,Icon> getIcons()
        {
            icons.put("wPawn",resizeIcon(new ImageIcon("Icons/wPawn.png")));
            icons.put("wKing",resizeIcon(new ImageIcon("Icons/wKing.png")));
            icons.put("wQueen",resizeIcon(new ImageIcon("Icons/wQueen.png")));
            icons.put("wRook",resizeIcon(new ImageIcon("Icons/wRook.png")));
            icons.put("wBishop",resizeIcon(new ImageIcon("Icons/wBishop.png")));
            icons.put("wKnight",resizeIcon(new ImageIcon("Icons/wKnight.png")));

            icons.put("bPawn",resizeIcon(new ImageIcon("Icons/bPawn.png")));
            icons.put("bKing",resizeIcon(new ImageIcon("Icons/bKing.png")));
            icons.put("bQueen",resizeIcon(new ImageIcon("Icons/bQueen.png")));
            icons.put("bRook",resizeIcon(new ImageIcon("Icons/bRook.png")));
            icons.put("bBishop",resizeIcon(new ImageIcon("Icons/bBishop.png")));
            icons.put("bKnight",resizeIcon(new ImageIcon("Icons/bKnight.png")));
            return icons;
        }
    }
}

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;

public class ChessIcons
{
    private static final HashMap<String, Icon> icons = new HashMap<>();

    public ChessIcons()
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
    }

    private static Icon resizeIcon(ImageIcon icon)
    {
        Image img = icon.getImage();
        Image resizedImage = img.getScaledInstance(50, 50, Image.SCALE_SMOOTH);
        return new ImageIcon(resizedImage);
    }

    public static HashMap<String,Icon> getIcons()
    {
        return icons;
    }
}

import javax.swing.*;
import java.awt.*;

public class ChessBoard extends JPanel
{

    public ChessBoard()
    {
        this.setSize(400,400);
        this.setLayout(new GridLayout(8,8));
        for (int i=0;i<64;i++)
        {
            JButton piece = new ChessPiece();
            this.add(piece);
        }
    }

}

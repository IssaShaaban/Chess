import javax.swing.*;
import java.awt.*;

public class RunGame
{
    public static void main(String[] args)
    {
        JFrame frame = new JFrame("Chess Game by Issa Shaaban");
        ChessBoard board = new ChessBoard();
        PlayerHandle player1 = new PlayerHandle("Player1");
        PlayerHandle player2 = new PlayerHandle("Player2");

        frame.setSize(800, 600);
        frame.add(player1,BorderLayout.NORTH);
        frame.add(board,BorderLayout.CENTER);
        frame.add(player2,BorderLayout.SOUTH);

        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

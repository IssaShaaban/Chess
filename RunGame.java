import javax.swing.*;
import java.awt.*;

public class RunGame {

    public static void main(String[] args) {

        JFrame frame = new JFrame("Chess");
        JLabel top = new JLabel("text");
        //ChessBoard g = new ChessBoard();
        frame.add(top);
        //frame.add(g);
        frame.setSize(800, 600);
        frame.setVisible(true);
    }
}

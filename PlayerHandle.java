import javax.swing.*;
import java.awt.*;

public class PlayerHandle extends JLabel
{

    public PlayerHandle(String text)
    {
        super(text,SwingConstants.CENTER);
        setFormat();
    }

    private void setFormat()
    {
        this.setSize(200,100);
        this.setFont(new Font("Serif", Font.BOLD, 30));
        this.setForeground(Color.BLACK);
        this.setBackground(Color.WHITE);
        this.setAlignmentX(Component.CENTER_ALIGNMENT);
    }
}

import java.awt.event.ActionEvent;

public class King extends ChessPiece {

    private int xPosition;
    private int yPosition;
    private boolean isBlack;

    public King(int row, int col, boolean isBlack)
    {
        super(row,col);
        xPosition = row;
        yPosition = col;
        this.isBlack = isBlack;

        if (isBlack)
        {
            this.setPieceIcon("bKing");
        }
        else
            this.setPieceIcon("wKing");
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        System.out.println("Pressed 1");
    }
}

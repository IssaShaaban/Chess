import java.awt.event.ActionEvent;

public class EmptyPiece extends ChessPiece
{
    ChessBoard board;
    private int xPosition;
    private int yPosition;

    public EmptyPiece(int row, int col)
    {
        super(row,col);
        this.board = board;
        xPosition = row;
        yPosition = col;
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        //if (board.getCanMove())
        //TODO move to positon
    }
}

import java.awt.event.ActionEvent;

public class Pawn extends ChessPiece
{
    ChessBoard board;
    private int xPosition;
    private int yPosition;
    private int xNewPosition;
    private int yNewPosition;
    private boolean isBlack;
    private boolean canMove = false;

    public Pawn(int row, int col, boolean isBlack,ChessBoard board)
    {
        super(row,col);
        this.board = board;
        xPosition = row;
        yPosition = col;
        this.isBlack = isBlack;

        if (isBlack)
        {
            this.setPieceIcon("bPawn");
        }
        else
            this.setPieceIcon("wPawn");
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        System.out.println("Pressed " + this.getClass().getName() + " " + this.getXPoisiton() + " " + this.getYPoisiton() + " " + this.isBlack);
    }

    private void moveForward()
    {
        board.setPiecePos(xNewPosition,yNewPosition,this);
    }
}

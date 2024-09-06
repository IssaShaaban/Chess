import java.awt.event.ActionEvent;

public class Pawn extends ChessPiece
{
    public Pawn(int row, int col,boolean isBlack,ChessBoard board)
    {
        super(row,col,isBlack,board);

        if (isBlack)
        {
            this.setPieceIcon("bPawn");
        }
        else
            this.setPieceIcon("wPawn");
    }

    private void moveForward()
    {
        //board.setPiecePos(newRow,newCol,this);
    }
}

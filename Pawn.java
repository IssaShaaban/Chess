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

    public void actionPerformed(ActionEvent e)
    {
        if (this.getBoard().getCurrentPiece() == this)
        {
            this.getBoard().unHighlight(this.getRow(),this.getCol());
            this.getBoard().setCurrentPiece(null);
        }

        else if (this.getBoard().getCurrentPiece() == null)
        {
            this.getBoard().highlightPiece(this.getRow(),this.getCol());
            this.getBoard().setCurrentPiece(this);
        }

        System.out.println("Pressed " + this.getClass().getName() + " " + this.getRow() + " " + this.getCol());
    }

    @Override
    public boolean isValidMove(int row,int col,int newRow,int newCol)
    {
        if (row == 6 && this.isBlack())
            if ((newRow == row - 2 && col == newCol) || (newRow == row - 1 && col == newCol))
                return true;

        if (this.isBlack())
            return newRow == row - 1 && col == newCol;

        if (row == 1 && !this.isBlack())
            if ((newRow == row + 2 && col == newCol) || (newRow == row + 1 && col == newCol))
                return true;

        if (!this.isBlack())
            return newRow == row + 1 && col == newCol;

        return false;
    }
}

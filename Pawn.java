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

    @Override
    public boolean isValidMove(int row,int col,int newRow,int newCol)
    {

        if (this.isBlack() && !getBoard().getPieceAt(newRow,newCol).isBlack() && !(getBoard().getPieceAt(newRow,newCol) instanceof EmptyPiece))
            return newRow == row - 1 && (newCol == col + 1 || newCol == col - 1);

        if (row == 6 && this.isBlack())
            if (((newRow == row - 2 && newCol == col) && (getBoard().getPieceAt(row-1,col) instanceof EmptyPiece)) || (newRow == row - 1 && newCol == col))
                return true;

        if (this.isBlack())
            return newRow == row - 1 && newCol == col;

        if (!this.isBlack() && getBoard().getPieceAt(newRow,newCol).isBlack() && !(getBoard().getPieceAt(newRow,newCol) instanceof EmptyPiece) && !getBoard().getBlacksTurn())
            return newRow == row + 1 && (newCol == col + 1 || newCol == col - 1);

        if (row == 1 && !this.isBlack())
            if (((newRow == row + 2 && newCol == col) && (getBoard().getPieceAt(row+1,col) instanceof EmptyPiece)) || (newRow == row + 1 && newCol == col))
                return true;

        if (!this.isBlack())
            return newRow == row + 1 && newCol == col;

        return false;
    }
}

import java.awt.event.ActionEvent;

public class Knight extends ChessPiece
{
    public Knight(int row, int col,boolean isBlack,ChessBoard board)
    {
        super(row,col,isBlack,board);

        if (isBlack)
        {
            this.setPieceIcon("bKnight");
        }
        else
            this.setPieceIcon("wKnight");
    }
    @Override
    public boolean isValidMove(int row, int col, int newRow, int newCol)
    {
        if (this.isBlack() && (!getBoard().getPieceAt(newRow, newCol).isBlack() || getBoard().getPieceAt(newRow,newCol) instanceof EmptyPiece))
            return bishopMoves(row,col,newRow,newCol);

        else if (!this.isBlack() && (getBoard().getPieceAt(newRow, newCol).isBlack() || getBoard().getPieceAt(newRow,newCol) instanceof EmptyPiece))
            return bishopMoves(row,col,newRow,newCol);

        return false;
    }

    private boolean bishopMoves(int row, int col, int newRow, int newCol)
    {
        return (newRow == row - 2 && newCol == col - 1) ||
                (newRow == row - 2 && newCol == col + 1) ||
                (newRow == row - 1 && newCol == col - 2) ||
                (newRow == row - 1 && newCol == col + 2) ||
                (newRow == row + 1 && newCol == col - 2) ||
                (newRow == row + 1 && newCol == col + 2) ||
                (newRow == row + 2 && newCol == col - 1) ||
                (newRow == row + 2 && newCol == col + 1);
    }
}

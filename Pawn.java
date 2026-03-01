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
    public boolean isValidMove(int row, int col, int newRow, int newCol)
    {
        Boolean newPieceColour = getBoard().getPieceAt(newRow,newCol).isBlack();

        if (isBlack() && newPieceColour == null) // Black moving to an empty square
            {
                if (row == 6) return (newRow == row - 2 && newCol == col) && (getBoard().getPieceAt(row - 1, col).isBlack() == null)
                        || newRow == row - 1 && newCol == col;
                else return newRow == row - 1 && newCol == col;
            }

        if (!isBlack() && newPieceColour == null) // White moving to an empty square
            {
                if (row == 1) return (newRow == row + 2 && newCol == col) && (getBoard().getPieceAt(row + 1, col).isBlack() == null)
                        || newRow == row + 1 && newCol == col;
                else return newRow == row + 1 && newCol == col;
            }

        if (this.isBlack() && !newPieceColour) // Black capturing
            return newRow == row - 1 && (newCol == col + 1 || newCol == col - 1);

        if (!this.isBlack() && getBoard().getPieceAt(newRow,newCol).isBlack()) // White capturing
            return newRow == row + 1 && (newCol == col + 1 || newCol == col - 1);

        return false;
    }
}

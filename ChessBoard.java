import javax.swing.*;
import java.awt.*;

public class ChessBoard extends JPanel
{
    private ChessPiece[][] board = new ChessPiece[8][8];
    private boolean canMove = false;

    public ChessBoard()
    {
        this.setSize(400,400);
        this.setLayout(new GridLayout(8,8));

        for (int row=0; row<8; row++)
        {
            for (int col=0; col<8; col++)
            {
                ChessPiece piece;

                if (row == 1)
                    piece = new Pawn(row,col,false,this);

                else if (row == 6)
                    piece = new Pawn(row,col,true,this);

                else if (row == 0 && (col == 0 || col == 7))
                    piece = new Rook(row,col,false);

                else if (row == 7 && (col == 0 || col == 7))
                    piece = new Rook(row,col,true);

                else if (row == 0 && (col == 1 || col == 6))
                    piece = new Knight(row,col,false);

                else if (row == 7 && (col == 1 || col == 6))
                    piece = new Knight(row,col,true);

                else if (row == 0 && (col == 2 || col == 5))
                    piece = new Bishop(row,col,false);

                else if (row == 7 && (col == 2 || col == 5))
                    piece = new Bishop(row,col,true);

                else if (row == 0 && col == 3)
                    piece = new King(row,col,false);

                else if (row == 7 && col == 3)
                    piece = new King(row,col,true);

                else if (row == 0 && col == 4)
                    piece = new Queen(row,col,false);

                else if (row == 7 && col == 4)
                    piece = new Queen(row,col,true);

                else
                    piece = new EmptyPiece(row,col);

                board[row][col] = piece;

                if ((row + col) % 2 == 0)
                    piece.setBackground(Color.WHITE);
                else
                    piece.setBackground(Color.BLACK);

                this.add(piece);
            }
        }
    }

    public void setCanMove(boolean canMove)
    {
        this.canMove = canMove;
    }

    public boolean getCanMove()
    {
        return canMove;
    }

    public ChessPiece[][] getBoard()
    {
        return board;
    }

    public void setPiecePos(int row, int col, ChessPiece piece)
    {
        board[row][col] = piece;
    }
}

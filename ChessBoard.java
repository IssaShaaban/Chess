import javax.swing.*;
import java.awt.*;

public class ChessBoard extends JPanel
{

    private final ChessPiece[][] board = new ChessPiece[8][8];

    public ChessBoard()
    {
        this.setSize(400,400);
        this.setLayout(new GridLayout(8,8));

        for (int row=0; row<8; row++)
        {
            for (int col=0; col<8; col++)
            {
                ChessPiece piece = new ChessPiece(row, col);
                board[row][col] = piece;

                if ((row + col) % 2 == 0)
                    piece.setBackground(Color.WHITE);
                else
                    piece.setBackground(Color.BLACK);

                this.add(piece);
            }
        }
        setIcons();
    }

    private void setIcons()
    {
        for (int col=0; col<8; col++)
        {
            board[1][col].setPieceIcon("wPawn");
            board[6][col].setPieceIcon("bPawn");
        }

        board[0][0].setPieceIcon("wRook");
        board[0][7].setPieceIcon("wRook");
        board[7][0].setPieceIcon("bRook");
        board[7][7].setPieceIcon("bRook");

        board[0][1].setPieceIcon("wKnight");
        board[0][6].setPieceIcon("wKnight");
        board[7][1].setPieceIcon("bKnight");
        board[7][6].setPieceIcon("bKnight");

        board[0][2].setPieceIcon("wBishop");
        board[0][5].setPieceIcon("wBishop");
        board[7][2].setPieceIcon("bBishop");
        board[7][5].setPieceIcon("bBishop");

        board[0][3].setPieceIcon("wKing");
        board[7][3].setPieceIcon("bKing");

        board[0][4].setPieceIcon("wQueen");
        board[7][4].setPieceIcon("bQueen");
    }
}

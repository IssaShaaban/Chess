import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class ChessBoard extends JPanel
{
    private ChessPiece[][] board = new ChessPiece[8][8];
    private ChessPiece currentPiece = null;
    private boolean blacksTurn = false;
    public ArrayList<int[]> blackKingInCheck = new ArrayList<>();
    public ArrayList<int[]> whiteKingInCheck = new ArrayList<>();
    public boolean[] inCheck = new boolean[2];

    public ChessBoard()
    {
        this.setSize(400,400);
        this.setLayout(new GridLayout(8,8));

        for (int row=0; row<8; row++)
        {
            for (int col=0; col<8; col++)
            {
                if (row == 1)
                    board[row][col] = new Pawn(row,col,false,this);

                else if (row == 6)
                    board[row][col] = new Pawn(row,col,true,this);

                else if (row == 0 && (col == 0 || col == 7))
                    board[row][col] = new Rook(row,col,false,this);

                else if (row == 7 && (col == 0 || col == 7))
                    board[row][col] = new Rook(row,col,true,this);

                else if (row == 0 && (col == 1 || col == 6))
                    board[row][col] = new Knight(row,col,false,this);

                else if (row == 7 && (col == 1 || col == 6))
                    board[row][col] = new Knight(row,col,true,this);

                else if (row == 0 && (col == 2 || col == 5))
                    board[row][col] = new Bishop(row,col,false,this);

                else if (row == 7 && (col == 2 || col == 5))
                    board[row][col] = new Bishop(row,col,true,this);

                else if (row == 0 && col == 3)
                    board[row][col] = new King(row,col,false,this);

                else if (row == 7 && col == 3)
                    board[row][col] = new King(row,col,true,this);

                else if (row == 0 && col == 4)
                    board[row][col] = new Queen(row,col,false,this);

                else if (row == 7 && col == 4)
                    board[row][col] = new Queen(row,col,true,this);

                else
                    board[row][col] = new EmptyPiece(row,col,this);

                addPiece(row,col);
            }
        }
    }

    public void setPiecePos(int newRow, int newCol, ChessPiece piece,int flag)
    {
        int oldRow = piece.getRow();
        int oldCol = piece.getCol();

        board[oldRow][oldCol] = new EmptyPiece(oldRow, oldCol, this);
        board[newRow][newCol] = piece;

        if (flag == 0)
        {
            piece.setPosition(newRow, newCol);
            removeAll();
            for (int row=0; row<8; row++)
            {
                for (int col = 0; col < 8; col++)
                {
                    addPiece(row,col);
                }
            }

            revalidate();
            repaint();
        }

        setCurrentPiece(null);
        gameCheck();
        /*if (inCheck[0])
            JOptionPane.showMessageDialog(this,  "Black king's in check!");
        else if (inCheck[1])
            JOptionPane.showMessageDialog(this,  "White king's in check!");*/
    }

    public void addPiece(int row, int col)
    {
        if ((row + col) % 2 == 0)
            board[row][col].setBackground(Color.WHITE);
        else
            board[row][col].setBackground(Color.BLACK);

        this.add(board[row][col]);
    }

    public ChessPiece getCurrentPiece()
    {
        return currentPiece;
    }

    public void setCurrentPiece(ChessPiece currentPiece)
    {
        this.currentPiece = currentPiece;
    }

    public void highlightPiece(int row, int col)
    {
        board[row][col].setBackground(new Color(236, 240, 194));
    }

    public void unHighlight(int row, int col)
    {
        if ((row + col) % 2 == 0)
            board[row][col].setBackground(Color.WHITE);
        else
            board[row][col].setBackground(Color.BLACK);
    }

    public ChessPiece getPieceAt(int row, int col)
    {
        return board[row][col];
    }

    public void setBlacksTurn(boolean blacksTurn)
    {
        this.blacksTurn = blacksTurn;
    }

    public boolean getBlacksTurn()
    {
        return blacksTurn;
    }

    private int[] getBlackKingLoc()
    {
        for (int row=0; row<8; row++)
        {
            for (int col = 0; col < 8; col++)
            {
                if ((board[row][col] instanceof King && board[row][col].isBlack()))
                    return new int[]{row,col};
            }
        }
        return new int[0];
    }

    private int[] getWhiteKingLoc()
    {
        for (int row=0; row<8; row++)
        {
            for (int col = 0; col < 8; col++)
            {
                if ((board[row][col] instanceof King && !board[row][col].isBlack()))
                    return new int[]{row,col};
            }
        }
        return new int[0];
    }

    public void gameCheck()
    {
        int[] blackKing = getBlackKingLoc();
        int[] whiteKing = getWhiteKingLoc();
        blackKingInCheck.clear();
        whiteKingInCheck.clear();

            for (int row = 0; row < 8; row++) {
                for (int col = 0; col < 8; col++) {
                    if ((board[row][col].isValidMove(row, col, blackKing[0], blackKing[1])) && !board[row][col].isBlack())
                        blackKingInCheck.add(new int[]{row,col});
                }
            }

            for (int row = 0; row < 8; row++) {
                for (int col = 0; col < 8; col++) {
                    if ((board[row][col].isValidMove(row, col, whiteKing[0], whiteKing[1])) && board[row][col].isBlack())
                        whiteKingInCheck.add(new int[]{row,col});
                }
            }

        inCheck[0] = !blackKingInCheck.isEmpty();
        inCheck[1] = !whiteKingInCheck.isEmpty();
    }

    public ChessPiece[][] gameState()
    {
        ChessPiece[][] copiedState = new ChessPiece[8][8];

        for (int row = 0; row < 8; row++)
            System.arraycopy(board[row], 0, copiedState[row], 0, 8);

        return copiedState;
    }

    public void returnState(ChessPiece[][] oldState)
    {
        for (int row = 0; row < 8; row++)
            System.arraycopy(oldState[row], 0, board[row], 0, 8);

        removeAll();
        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                addPiece(row, col);
            }
        }

        revalidate();
        repaint();
    }

    public boolean getInCheck(boolean isBlack)
    {
        if (isBlack)
            return inCheck[0];
        else
            return inCheck[1];
    }
}

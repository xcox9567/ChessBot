package com.game;

import com.engine.Board;
import com.game.pieces.*;
import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.VPos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Control;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Main extends Application {

    public static int PAWN = 1;
    public static int KNIGHT = 2;
    public static int BISHOP = 3;
    public static int ROOK = 4;
    public static int QUEEN = 5;
    public static int KING = 6;
    public static int WHITE = 8;
    public static int BLACK = 16;

    private Tile[][] board = new Tile[8][8];

    private int turn = WHITE;

    private Parent createContent()
    {
        GridPane root = new GridPane();
        final int size = 8 ;
        for (int row = 0; row < size; row++)
        {
            for (int col = 0; col < size; col ++)
            {
                Tile tile = new Tile();
                String color;
                if ((row + col) % 2 == 0)
                {
                    color = "#eeeed2";
                }
                else
                {
                    color = "#769656";
                }
                tile.setStyle("-fx-background-color: " + color + ";");
                root.add(tile, col, row);
                board[row][col] = tile;
            }
        }
        for (int i = 0; i < size; i++) {
            root.getColumnConstraints().add(new ColumnConstraints(5, Control.USE_PREF_SIZE, Double.POSITIVE_INFINITY, Priority.ALWAYS, HPos.CENTER, true));
            root.getRowConstraints().add(new RowConstraints(5, Control.USE_PREF_SIZE, Double.POSITIVE_INFINITY, Priority.ALWAYS, VPos.CENTER, true));
        }
        return root;
    }

    public void movePiece(Tile from, Tile to) throws FileNotFoundException
    {
        if(!from.isEmpty())
        {
            to.setPiece(from.getPiece());
            from.setPiece(null);
        }
    }

    public void loadFromBitboard(Board bitboard) throws FileNotFoundException
    {
        long bPawns = bitboard.getPieces(BLACK | PAWN);
        for(int i = 0; i < 64; i++)
        {
            if(bPawns % 2 != 0)
            {
                board[i / 8][i % 8].setPiece(new Pawn(BLACK, board[i / 8][i % 8], "src/images/bPawn.png"));
            }
            else if(board[i / 8][i % 8].isEmpty())
            {
                board[i / 8][i % 8].getFrame().setImage(null);
            }
            bPawns >>= 1;
        }

        long bKnights = bitboard.getPieces(BLACK | KNIGHT);
        for(int i = 0; i < 64; i++)
        {
            if(bKnights % 2 != 0)
            {
                board[i / 8][i % 8].setPiece(new Knight(BLACK, board[i / 8][i % 8], "src/images/bKnight.png"));
            }
            else if(board[i / 8][i % 8].isEmpty())
            {
                board[i / 8][i % 8].getFrame().setImage(null);
            }
            bKnights >>= 1;
        }

        long bBishops = bitboard.getPieces(BLACK | BISHOP);
        for(int i = 0; i < 64; i++)
        {
            if(bBishops % 2 != 0)
            {
                board[i / 8][i % 8].setPiece(new Bishop(BLACK, board[i / 8][i % 8], "src/images/bBishop.png"));
            }
            else if(board[i / 8][i % 8].isEmpty())
            {
                board[i / 8][i % 8].getFrame().setImage(null);
            }
            bBishops >>= 1;
        }

        long bRooks = bitboard.getPieces(BLACK | ROOK);
        for(int i = 0; i < 64; i++)
        {
            if(bRooks % 2 != 0)
            {
                board[i / 8][i % 8].setPiece(new Rook(BLACK, board[i / 8][i % 8], "src/images/bRook.png"));
            }
            else if(board[i / 8][i % 8].isEmpty())
            {
                board[i / 8][i % 8].getFrame().setImage(null);
            }
            bRooks >>= 1;
        }

        long bQueens = bitboard.getPieces(BLACK | QUEEN);
        for(int i = 0; i < 64; i++)
        {
            if(bQueens % 2 != 0)
            {
                board[i / 8][i % 8].setPiece(new Queen(BLACK, board[i / 8][i % 8], "src/images/bQueen.png"));
            }
            else if(board[i / 8][i % 8].isEmpty())
            {
                board[i / 8][i % 8].getFrame().setImage(null);
            }
            bQueens >>= 1;
        }

        long bKing = bitboard.getPieces(BLACK | KING);
        for(int i = 0; i < 64; i++)
        {
            if(bKing % 2 != 0)
            {
                board[i / 8][i % 8].setPiece(new King(BLACK, board[i / 8][i % 8], "src/images/bKing.png"));
            }
            else if(board[i / 8][i % 8].isEmpty())
            {
                board[i / 8][i % 8].getFrame().setImage(null);
            }
            bKing >>= 1;
        }

        long wPawns = bitboard.getPieces(WHITE | PAWN);
        for(int i = 0; i < 64; i++)
        {
            if(wPawns % 2 != 0)
            {
                board[i / 8][i % 8].setPiece(new Pawn(WHITE, board[i / 8][i % 8], "src/images/wPawn.png"));
            }
            else if(board[i / 8][i % 8].isEmpty())
            {
                board[i / 8][i % 8].getFrame().setImage(null);
            }
            wPawns >>= 1;
        }

        long wKnights = bitboard.getPieces(WHITE | KNIGHT);
        for(int i = 0; i < 64; i++)
        {
            if(wKnights % 2 != 0)
            {
                board[i / 8][i % 8].setPiece(new Knight(WHITE, board[i / 8][i % 8], "src/images/wKnight.png"));
            }
            else if(board[i / 8][i % 8].isEmpty())
            {
                board[i / 8][i % 8].getFrame().setImage(null);
            }
            wKnights >>= 1;
        }

        long wBishops = bitboard.getPieces(WHITE | BISHOP);
        for(int i = 0; i < 64; i++)
        {
            if(wBishops % 2 != 0)
            {
                board[i / 8][i % 8].setPiece(new Bishop(WHITE, board[i / 8][i % 8], "src/images/wBishop.png"));
            }
            else if(board[i / 8][i % 8].isEmpty())
            {
                board[i / 8][i % 8].getFrame().setImage(null);
            }
            wBishops >>= 1;
        }

        long wRooks = bitboard.getPieces(WHITE | ROOK);
        for(int i = 0; i < 64; i++)
        {
            if(wRooks % 2 != 0)
            {
                board[i / 8][i % 8].setPiece(new Rook(WHITE, board[i / 8][i % 8], "src/images/wRook.png"));
            }
            else if(board[i / 8][i % 8].isEmpty())
            {
                board[i / 8][i % 8].getFrame().setImage(null);
            }
            wRooks >>= 1;
        }

        long wQueens = bitboard.getPieces(WHITE | QUEEN);
        for(int i = 0; i < 64; i++)
        {
            if(wQueens % 2 != 0)
            {
                board[i / 8][i % 8].setPiece(new Queen(WHITE, board[i / 8][i % 8], "src/images/wQueen.png"));
            }
            else if(board[i / 8][i % 8].isEmpty())
            {
                board[i / 8][i % 8].getFrame().setImage(null);
            }
            wQueens >>= 1;
        }

        long wKing = bitboard.getPieces(WHITE | KING);
        for(int i = 0; i < 64; i++)
        {
            if(wKing % 2 != 0)
            {
                board[i / 8][i % 8].setPiece(new King(WHITE, board[i / 8][i % 8], "src/images/wKing.png"));
            }
            else if(board[i / 8][i % 8].isEmpty())
            {
                board[i / 8][i % 8].getFrame().setImage(null);
            }
            wKing >>= 1;
        }
    }

    public Board loadBitboard()
    {
        Board bitboard = new Board();

        long wPieces = 0x0;
        for(int r = 7; r >= 0; r--)
        {
            for(int f = 7; f >= 0; f--)
            {
                if(board[r][f].getPiece() != null && board[r][f].getPiece().getType() < BLACK) {
                    wPieces += 1;
                }
                if(f != 0 || r != 0) {
                    wPieces <<= 1;
                }
            }
        }
        bitboard.setwPieces(wPieces);

        long bPieces = 0;
        for(int r = 7; r >= 0; r--)
        {
            for(int f = 7; f >= 0; f--)
            {
                if(board[r][f].getPiece() != null && board[r][f].getPiece().getType() >= BLACK) {
                    bPieces += 1;
                }
                if(f != 0 || r != 0) {
                    bPieces <<= 1;
                }
            }
        }
        bitboard.setbPieces(bPieces);

        long pawns = 0;
        for(int r = 7; r >= 0; r--)
        {
            for(int f = 7; f >= 0; f--)
            {
                if(board[r][f].getPiece() != null && board[r][f].getPiece().getType() % 8 == PAWN) {
                    pawns += 1;
                }
                if(f != 0 || r != 0) {
                    pawns <<= 1;
                }
            }
        }
        bitboard.setPawns(pawns);

        long knights = 0;
        for(int r = 7; r >= 0; r--)
        {
            for(int f = 7; f >= 0; f--)
            {
                if(board[r][f].getPiece() != null && board[r][f].getPiece().getType() % 8 == KNIGHT) {
                    knights += 1;
                }
                if(f != 0 || r != 0) {
                    knights <<= 1;
                }
            }
        }
        bitboard.setKnights(knights);

        long bishops = 0;
        for(int r = 7; r >= 0; r--)
        {
            for(int f = 7; f >= 0; f--)
            {
                if(board[r][f].getPiece() != null && board[r][f].getPiece().getType() % 8 == BISHOP) {
                    bishops += 1;
                }
                if(f != 0 || r != 0) {
                    bishops <<= 1;
                }
            }
        }
        bitboard.setBishops(bishops);

        long rooks = 0;
        for(int r = 7; r >= 0; r--)
        {
            for(int f = 7; f >= 0; f--)
            {
                if(board[r][f].getPiece() != null && board[r][f].getPiece().getType() % 8 == ROOK) {
                    rooks += 1;
                }
                if(f != 0 || r != 0) {
                    rooks <<= 1;
                }
            }
        }
        bitboard.setRooks(rooks);

        long queens = 0;
        for(int r = 7; r >= 0; r--)
        {
            for(int f = 7; f >= 0; f--)
            {
                if(board[r][f].getPiece() != null && board[r][f].getPiece().getType() % 8 == QUEEN) {
                    queens += 1;
                }
                if(f != 0 || r != 0) {
                    queens <<= 1;
                }
            }
        }
        bitboard.setQueens(queens);

        long kings = 0;
        for(int r = 7; r >= 0; r--)
        {
            for(int f = 7; f >= 0; f--)
            {
                if(board[r][f].getPiece() != null && board[r][f].getPiece().getType() % 8 == KING) {
                    kings += 1;
                }
                if(f != 0 || r != 0) {
                    kings <<= 1;
                }
            }
        }
        bitboard.setKings(kings);

        return bitboard;
    }

    public Tile[] makeMove()
    {
        Tile[] move = new Tile[2];
        Board state = loadBitboard();

        return move;
    }

    @Override
    public void start(Stage primaryStage) throws IOException
    {
        Scene scene = new Scene(createContent(),540,540);
        Board gBoard = new Board();
        loadFromBitboard(gBoard);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Chess Bot");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
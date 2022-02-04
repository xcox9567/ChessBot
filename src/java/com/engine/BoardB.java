package com.engine;

import com.game.Main;

public class BoardB {

    public static int[] Squares;

    public BoardB()
    {
        Squares = new int[64];
        setBoardFen("pppppppp/rnbqkbnr/8/8/8/8/PPPPPPPP/RNBQKBNR w KQkq - 0 1");
    }

    public static void setBoardFen(String fen)
    {
        String bFen = fen.split(" ")[0];
        char[] fenArray = new char[bFen.length()];

        for(int i = 0; i < fen.length(); i++)
        {
            fenArray[i] = fen.charAt(i);
        }

        int row = 0, col = 0;

        for (char x : fenArray)
        {
            if(x == '/')
            {
                row++;
                col = 0;
            }
            else
            {
                if(Character.isDigit(x))
                {
                    col += Character.getNumericValue(x);
                }
                else
                {
                    int color = (Character.isUpperCase(x)) ? Main.WHITE : Main.BLACK;
                    int type = 0;

                    switch (Character.toLowerCase(x)) {
                        case 'k' -> type = Main.KING;
                        case 'p' -> type = Main.PAWN;
                        case 'n' -> type = Main.KNIGHT;
                        case 'b' -> type = Main.BISHOP;
                        case 'r' -> type = Main.ROOK;
                        case 'q' -> type = Main.QUEEN;
                    }

                    Squares[row * 8 + col] = color | type;

                    col++;
                }
            }
        }
    }
}

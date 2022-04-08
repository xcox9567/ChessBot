package com.engine;

import java.util.ArrayList;

import static com.game.Main.WHITE;
import static com.game.Main.BLACK;

public class BitBoard {

    private final int[] deBruijn = {
            63,30, 3,32,59,14,11,33,
            60,24,50, 9,55,19,21,34,
            61,29, 2,53,51,23,41,18,
            56,28, 1,43,46,27, 0,35,
            62,31,58, 4, 5,49,54, 6,
            15,52,12,40, 7,42,45,16,
            25,57,48,13,10,39, 8,44,
            20,47,38,22,17,37,36,26,
    };

    private long wPieces;
    private long bPieces;
    private long pawns;
    private long knights;
    private long bishops;
    private long rooks;
    private long queens;
    private long kings;

    /**
     * Initializes the bitboards to represent the standard starting position.
     */
    public BitBoard()
    {
        wPieces = 0xFFFF000000000000L;
        bPieces = 0x000000000000FFFFL;
        pawns = 0x00FF00000000FF00L;
        knights = 0x4200000000000042L;
        bishops = 0x2400000000000024L;
        rooks = 0x8100000000000081L;
        queens = 0x0800000000000008L;
        kings = 0x1000000000000010L;
    }

    /**
     * Initializes a copy of the given Board instance
     * @param board - Board state to be copied.
     */
    public BitBoard(BitBoard board)
    {
        wPieces = board.getwPieces();
        bPieces = board.getbPieces();
        pawns = board.getPawns();
        knights = board.getKnights();
        bishops = board.getBishops();
        rooks = board.getRooks();
        queens = board.getQueens();
        kings = board.getKings();
    }

    /**
     * Finds the bit-index of the LSB of the given bitboard
     *
     * @param bb - Bitboard whose LSB is to be indexed
     * @return - The bit-index of the LSB in bb
     */
    public int bitScanForward(long bb)
    {
        bb ^= (bb - 1);
        int folded = ((int)bb) ^ ((int)(bb >>> 32));
        return deBruijn[(folded * 0x78291ACF) >>> 26];
    }

    /**
     * Converts bb to a 1D list representation of the piece indexes bb was implying
     *
     * @param bb - Bitboard to be converted (serialized)
     * @return - ArrayList<Integer> of the board indexes bb represents
     */
    public ArrayList<Integer> serialize(long bb)
    {
        ArrayList<Integer> indexes = new ArrayList<>();

        while(bb != 0)
        {
            int lsbIdx = bitScanForward(bb); //Get index of LS1B
            indexes.add(lsbIdx);
            bb &= bb - 1; //Reset LS1B
        }
        return indexes;
    }

    public ArrayList<Long> getMoves(int color)
    {
        ArrayList<Long> moves = new ArrayList<>();

        if(color == WHITE | color == BLACK)
        {
            ArrayList<Integer> pawnArr;
            ArrayList<Integer> knightArr;
            ArrayList<Integer> bishopArr;
            ArrayList<Integer> rookArr;
            ArrayList<Integer> queenArr;
            ArrayList<Integer> kingArr;

            if(color == WHITE)
            {
                pawnArr = serialize(getPawns() & getwPieces());
                knightArr = serialize(getKnights() & getwPieces());
                bishopArr = serialize(getBishops() & getwPieces());
                rookArr = serialize(getRooks() & getwPieces());
                queenArr = serialize(getQueens() & getwPieces());
                kingArr = serialize(getKings() & getwPieces());
            }
            else
            {
                pawnArr = serialize(getPawns() & getbPieces());
                knightArr = serialize(getKnights() & getbPieces());
                bishopArr = serialize(getBishops() & getbPieces());
                rookArr = serialize(getRooks() & getbPieces());
                queenArr = serialize(getQueens() & getbPieces());
                kingArr = serialize(getKings() & getbPieces());
            }

        }

        return moves;
    }

    /*
    Returns number of bits set in bitBoard
     */
    public long countPop(long bitBoard)
    {
        int count = 0;
        while (bitBoard != 0)
        {
            count++;
            bitBoard &= bitBoard - 1;
        }
        return count;
    }

    /**
     * Returns a bitboard representing the locations of the given piece int.
     *
     * @param piece - 3-digit Binary int representing the piece.
     * @return - Bitboard representation of the locations of the given piece
     */
    public long getPieces(int piece)
    {
        if (piece > BLACK)
        {
            switch (piece - BLACK)
            {
                case 1: return bPieces & pawns;
                case 2: return bPieces & knights;
                case 3: return bPieces & bishops;
                case 4: return bPieces & rooks;
                case 5: return bPieces & queens;
                case 6: return bPieces & kings;
            }
        }
        else if (piece > WHITE)
        {
            switch (piece - WHITE)
            {
                case 1: return wPieces & pawns;
                case 2: return wPieces & knights;
                case 3: return wPieces & bishops;
                case 4: return wPieces & rooks;
                case 5: return wPieces & queens;
                case 6: return wPieces & kings;
            }
        }
        else if(piece == WHITE)
        {
            return wPieces;
        }
        else if(piece == BLACK)
        {
            return bPieces;
        }
        else
        {
            switch (piece)
            {
                case 0: return ~(wPieces & bPieces);
                case 1: return pawns;
                case 2: return knights;
                case 3: return bishops;
                case 4: return rooks;
                case 5: return queens;
                case 6: return kings;
            }
        }
        return -1;
    }

    public void setwPieces(long bitboard)
    {
        wPieces = bitboard;
    }

    public void setbPieces(long bitboard)
    {
        bPieces = bitboard;
    }

    public void setPawns(long bitboard)
    {
        pawns = bitboard;
    }

    public void setKnights(long bitboard)
    {
        knights = bitboard;
    }

    public void setBishops(long bitboard)
    {
        bishops = bitboard;
    }

    public void setRooks(long bitboard)
    {
        rooks = bitboard;
    }

    public void setQueens(long bitboard)
    {
        queens = bitboard;
    }

    public void setKings(long bitboard)
    {
        kings = bitboard;
    }

    public long getwPieces()
    {
        return wPieces;
    }

    public long getbPieces()
    {
        return bPieces;
    }

    public long getPawns()
    {
        return pawns;
    }

    public long getKnights()
    {
        return knights;
    }

    public long getBishops()
    {
        return bishops;
    }

    public long getRooks()
    {
        return rooks;
    }

    public long getQueens()
    {
        return queens;
    }

    public long getKings()
    {
        return kings;
    }

    //public ArrayList<> getPawnMoves(int color)

    /**
     * @return - 2D string representation of the current board state as represented by the bitboards
     */
    public String[][] getStringArr()
    {
        String[][] board = new String[8][8];

        for(int r = 0; r < 8; r++)
        {
            for(int f = 0; f < 8; f++)
            {
                board[r][f] = "-";
            }
        }

        long wPawns = wPieces & pawns;
        for(int i = 0; i < 64; i++)
        {
            if(wPawns % 2 != 0)
            {
                board[i / 8][i % 8] = "P";
            }
            wPawns >>= 1;
        }

        long wKnights = wPieces & knights;
        for(int i = 0; i < 64; i++)
        {
            if(wKnights % 2 != 0)
            {
                board[i / 8][i % 8] = "N";
            }
            wKnights >>= 1;
        }

        long wBishops = wPieces & bishops;
        for(int i = 0; i < 64; i++)
        {
            if(wBishops % 2 != 0)
            {
                board[i / 8][i % 8] = "B";
            }
            wBishops >>= 1;
        }

        long wRooks = wPieces & rooks;
        for(int i = 0; i < 64; i++)
        {
            if(wRooks % 2 != 0)
            {
                board[i / 8][i % 8] = "R";
            }
            wRooks >>= 1;
        }

        long wQueens = wPieces & queens;
        for(int i = 0; i < 64; i++)
        {
            if(wQueens % 2 != 0)
            {
                board[i / 8][i % 8] = "Q";
            }
            wQueens >>= 1;
        }

        long wKing = wPieces & kings;
        for(int i = 0; i < 64; i++)
        {
            if(wKing % 2 != 0)
            {
                board[i / 8][i % 8] = "K";
            }
            wKing >>= 1;
        }

        long bPawns = bPieces & pawns;
        for(int i = 0; i < 64; i++)
        {
            if(bPawns % 2 != 0)
            {
                board[i / 8][i % 8] = "p";
            }
            bPawns >>= 1;
        }

        long bKnights = bPieces & knights;
        for(int i = 0; i < 64; i++)
        {
            if(bKnights % 2 != 0)
            {
                board[i / 8][i % 8] = "n";
            }
            bKnights >>= 1;
        }

        long bBishops = bPieces & bishops;
        for(int i = 0; i < 64; i++)
        {
            if(bBishops % 2 != 0)
            {
                board[i / 8][i % 8] = "b";
            }
            bBishops >>= 1;
        }

        long bRooks = bPieces & rooks;
        for(int i = 0; i < 64; i++)
        {
            if(bRooks % 2 != 0)
            {
                board[i / 8][i % 8] = "r";
            }
            bRooks >>= 1;
        }

        long bQueens = bPieces & queens;
        for(int i = 0; i < 64; i++)
        {
            if(bQueens % 2 != 0)
            {
                board[i / 8][i % 8] = "q";
            }
            bQueens >>= 1;
        }

        long bKing = bPieces & kings;
        for(int i = 0; i < 64; i++)
        {
            if(bKing % 2 != 0)
            {
                board[i / 8][i % 8] = "k";
            }
            bKing >>= 1;
        }

        return board;
    }

    public String toString()
    {
        StringBuilder bString = new StringBuilder();

        String[][] boardArr = getStringArr();

        for (String[] strings : boardArr)
        {
            for (String string : strings)
            {
                bString.append(string).append("  ");
            }
            bString.append("\n");
        }
        return bString.toString();
    }
}

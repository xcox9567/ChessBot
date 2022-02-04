package com.game.pieces;

import com.game.Piece;
import com.game.Tile;

public class Pawn extends Piece {

    public Pawn(int color, Tile square, String image)
    {
        super(color | 1, square, image);
    }

    public void Move(Tile move)
    {

    }
}

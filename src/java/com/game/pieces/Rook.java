package com.game.pieces;

import com.game.Piece;
import com.game.Tile;

public class Rook extends Piece {

    public Rook(int color, Tile square, String image)
    {
        super(color | 4, square, image);
    }

    public void Move(Tile move)
    {

    }
}

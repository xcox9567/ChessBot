package com.game.pieces;

import com.game.Piece;
import com.game.Tile;

public class Bishop extends Piece {

    public Bishop(int color, Tile square, String image)
    {
        super(color | 3, square, image);
    }

    public void Move(Tile move)
    {

    }
}

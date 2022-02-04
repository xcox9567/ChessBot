package com.game.pieces;

import com.game.Piece;
import com.game.Tile;

public class Knight extends Piece {

    public Knight(int color, Tile square, String image)
    {
        super(color | 2, square, image);
    }

    public void Move(Tile move)
    {

    }
}

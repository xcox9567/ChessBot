package com.game.pieces;

import com.game.Piece;
import com.game.Tile;

public class Queen extends Piece {

    public Queen(int color, Tile square, String image)
    {
        super(color | 5, square, image);
    }

    public void Move(Tile move)
    {

    }
}

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

    @Override
    public boolean isPawn() {
        return false;
    }

    @Override
    public boolean isKnight() {
        return true;
    }

    @Override
    public boolean isBishop() {
        return false;
    }

    @Override
    public boolean isRook() {
        return false;
    }

    @Override
    public boolean isQueen() {
        return false;
    }

    @Override
    public boolean isKing() {
        return false;
    }
}

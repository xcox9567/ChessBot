package com.game.pieces;

import com.game.Piece;
import com.game.Tile;

public class King extends Piece {

    public King(int color, Tile square, String image)
    {
        super(color | 6, square, image);
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
        return false;
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
        return true;
    }
}

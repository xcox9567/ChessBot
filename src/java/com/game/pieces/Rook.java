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
        return true;
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

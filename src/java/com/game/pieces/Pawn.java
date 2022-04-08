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

    @Override
    public boolean isPawn() {
        return true;
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
        return false;
    }
}

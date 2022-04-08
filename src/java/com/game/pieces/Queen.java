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
        return true;
    }

    @Override
    public boolean isKing() {
        return false;
    }
}

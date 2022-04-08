package com.game;

import javafx.scene.layout.StackPane;

public abstract class Piece extends StackPane {

    private Tile square;
    private String image;
    private int type;

    public Piece (int type, Tile square, String image)
    {
        this.square = square;
        this.image = image;
        this.type = type;
    }

    public abstract void Move(Tile move);

    public int getType()
    {
        return type;
    }

    public String getImage()
    {
        return image;
    }

    public Tile getSquare()
    {
        return square;
    }

    public abstract boolean isPawn();
    public abstract boolean isKnight();
    public abstract boolean isBishop();
    public abstract boolean isRook();
    public abstract boolean isQueen();
    public abstract boolean isKing();
}

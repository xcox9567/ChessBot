package com.game;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Tile extends StackPane {

    private Piece piece;
    private ImageView tFrame;

    public Tile()
    {
        tFrame = new ImageView();
        this.getChildren().add(tFrame);
    }

    public boolean isEmpty()
    {
        return piece == null;
    }

    public void setPiece(Piece p) throws FileNotFoundException
    {
        piece = p;

        if(p != null)
            tFrame.setImage(new Image(new FileInputStream(p.getImage())));
        else
            tFrame.setImage(null);
    }

    public Piece getPiece()
    {
        return piece;
    }

    public ImageView getFrame()
    {
        return tFrame;
    }
}

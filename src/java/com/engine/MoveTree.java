package com.engine;

import java.util.ArrayList;

public class MoveTree {

    private ArrayList<MoveTree> children;

    public MoveTree()
    {
        children = new ArrayList<>();
    }

    public MoveTree(ArrayList<MoveTree> childs)
    {
        children = childs;
    }

    public void addChild(MoveTree child)
    {
        children.add(child);
    }

    public ArrayList<MoveTree> getChildren() {
        return children;
    }
}

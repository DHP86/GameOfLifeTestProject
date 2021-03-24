package com.testproject.gameoflife;

public class Location2D implements Location {
    private int x;
    private int y;

    public Location2D(int x, int y)
    {
        this.x = x;
        this.y = y;
    }

    public static Location2D Create(int x, int y)
    {
        return new Location2D(x,y);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}

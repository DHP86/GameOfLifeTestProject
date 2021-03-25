package com.testproject.gameoflife;

import java.util.ArrayList;

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

    public ArrayList<Location2D> GetNeighbourLocations()
    {
        ArrayList<Location2D> result = new ArrayList<>();

        result.add(new Location2D(x - 1, y - 1));
        result.add(new Location2D(x - 1, y ));
        result.add(new Location2D(x - 1, y + 1));
        result.add(new Location2D(x , y - 1 ));
        result.add(new Location2D(x , y + 1));
        result.add(new Location2D(x + 1, y - 1 ));
        result.add(new Location2D(x + 1, y ));
        result.add(new Location2D(x + 1, y + 1));

        return result;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o)
        {
            return true;
        }
        if (!(o instanceof Location2D))
        {
            return false;
        }
        Location2D location = (Location2D) o;
        return location.x == x && location.y == y;
    }

    @Override
    public int hashCode()
    {
        return x + 1000 * y;
    }
}

package com.testproject.gameoflife;

import java.awt.*;
import java.util.HashMap;
import java.util.Set;

public class Cells {
    private HashMap<Location2D, Cell> cells = new HashMap<>();

    Cells(Dimension dimension)
    {
        for (int i = 0; i < dimension.width; i++)
        {
            addVerticalLineOfDeadCells(i, dimension.height);
        }
    }

    private void addVerticalLineOfDeadCells(int i, int height) {
        for (int j = 0; j < height; j++)
        {
            cells.put(new Location2D(i, j), new DeadCell());
        }
    }

    public Cell get(Location2D location)
    {
        return cells.get(location);
    }

    public void SetAliveAt(Location2D location2D)
    {
        cells.replace(location2D, new AliveCell());
    }

    public void SetDeadAt(Location2D location2D)
    {
        cells.replace(location2D, new DeadCell());
    }

    public Set<Location2D> getLocations() {
        return cells.keySet();
    }
}

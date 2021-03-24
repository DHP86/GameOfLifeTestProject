package com.testproject.gameoflife;

import java.awt.*;
import java.util.ArrayList;

public class World {
    private ArrayList<Location2D> aliveCells;

    public World(Dimension dimension)
    {
        aliveCells = new ArrayList<>();
    }

    public void Tick(GameOfLifeListener listener)
    {
        for (Location2D location2D : aliveCells)
        {
            listener.CellDiedAt(location2D);
        }
    }

    public void SetAliveAt(Location2D location2D) {

        aliveCells.add(location2D);
    }
}

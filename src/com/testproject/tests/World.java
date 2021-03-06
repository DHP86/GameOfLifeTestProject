package com.testproject.tests;

import com.testproject.gameoflife.Cells;
import com.testproject.gameoflife.DeadCell;
import com.testproject.gameoflife.GameOfLifeListener;
import com.testproject.gameoflife.Location2D;

import java.awt.*;

public class World {
    private final Cells cells;

    public World(Dimension dimension) {
        cells = new Cells();
        for (int i = 0; i < dimension.width; i++) {
            addVerticalLineOfDeadCells(i, dimension.height);
        }
        cells.ConnectNeighbours();
    }

    private void addVerticalLineOfDeadCells(int i, int height) {
        for (int j = 0; j < height; j++) {
            cells.InsertAt(new Location2D(i, j), new DeadCell());
        }
    }

    public void Tick(GameOfLifeListener listener) {
        cells.Tick(listener);
    }

    public void SetAliveAt(Location2D location2D) {
        cells.SetAliveAt(location2D);
    }
}

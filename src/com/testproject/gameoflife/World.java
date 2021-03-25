package com.testproject.gameoflife;

import java.awt.*;
import java.util.ArrayList;

public class World {
    private final Cells cells;

    public World(Dimension dimension) {
        cells = new Cells(dimension);
    }

    public void Tick(GameOfLifeListener listener) {
        ArrayList<Location2D> deadCells = new ArrayList<>();
        ArrayList<Location2D> bornCells = new ArrayList<>();
        for (Location2D location2D : cells.getLocations()) {
            Cell cell = cells.get(location2D);
            CellEventsListener cellEventsListener = getCellEventsListener(listener, location2D, deadCells, bornCells);
            int numAliveNeighbours = GetNumAliveNeighbours(location2D);
            cell.Tick(cellEventsListener, numAliveNeighbours);
        }
        for (Location2D location : deadCells) {
            cells.SetDeadAt(location);
        }
        for (Location2D location : bornCells) {
            cells.SetAliveAt(location);
        }
    }

    private CellEventsListener getCellEventsListener(GameOfLifeListener listener, Location2D location2D, ArrayList<Location2D> deadCells, ArrayList<Location2D> bornCells) {
        return new CellEventsListener() {
            @Override
            public void CellDied() {
                listener.CellDiedAt(location2D);
                deadCells.add(location2D);
            }

            @Override
            public void CellBorn() {
                listener.CellCreatedAt(location2D);
                bornCells.add(location2D);
            }
        };
    }

    private int GetNumAliveNeighbours(Location2D location2D) {
        int result = 0;
        for (Location2D other : location2D.GetNeighbourLocations()) {
            result += OneIfAlive(other);
        }
        return result;
    }

    private int OneIfAlive(Location2D other) {
        Cell cell = cells.get(other);
        if (cell != null && cell.IsAlive()) {
            return 1;
        }
        return 0;
    }

    public void SetAliveAt(Location2D location2D) {
        cells.SetAliveAt(location2D);
    }
}

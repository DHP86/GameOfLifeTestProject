package com.testproject.gameoflife;

import java.awt.*;
import java.util.ArrayList;

public class World {
    private final Cells cells;

    public World(Dimension dimension) {
        cells = new Cells();
        for (int i = 0; i < dimension.width; i++) {
            addVerticalLineOfDeadCells(i, dimension.height);
        }
    }

    private void addVerticalLineOfDeadCells(int i, int height) {
        for (int j = 0; j < height; j++) {
            cells.InsertAt(new Location2D(i, j), new DeadCell());
        }
    }

    public void Tick(GameOfLifeListener listener) {
        ArrayList<Location> deadCells = new ArrayList<>();
        ArrayList<Location> bornCells = new ArrayList<>();
        for (Location location : cells.GetLocations()) {
            Cell cell = cells.Get(location);
            CellEventsListener cellEventsListener = getCellEventsListener(listener, location, deadCells, bornCells);
            int numAliveNeighbours = GetNumAliveNeighbours(location);
            cell.Tick(cellEventsListener, numAliveNeighbours);
        }
        for (Location location : deadCells) {
            cells.SetDeadAt(location);
        }
        for (Location location : bornCells) {
            cells.SetAliveAt(location);
        }
    }

    private CellEventsListener getCellEventsListener(GameOfLifeListener listener, Location location, ArrayList<Location> deadCells, ArrayList<Location> bornCells) {
        return new CellEventsListener() {
            @Override
            public void CellDied() {
                listener.CellDiedAt(location);
                deadCells.add(location);
            }

            @Override
            public void CellBorn() {
                listener.CellCreatedAt(location);
                bornCells.add(location);
            }
        };
    }

    private int GetNumAliveNeighbours(Location location) {
        int result = 0;
        for (Location other : location.GetNeighbourLocations()) {
            result += OneIfAlive(other);
        }
        return result;
    }

    private int OneIfAlive(Location other) {
        Cell cell = cells.Get(other);
        if (cell != null && cell.IsAlive()) {
            return 1;
        }
        return 0;
    }

    public void SetAliveAt(Location2D location2D) {
        cells.SetAliveAt(location2D);
    }
}

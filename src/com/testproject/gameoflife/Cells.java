package com.testproject.gameoflife;

import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.function.BiConsumer;

public class Cells {
    private final HashMap<Location, Cell> cells = new HashMap<>();

    Cells() {
    }

    public void InsertAt(Location location, Cell cell) {
        cells.put(location, cell);
    }

    public void SetAliveAt(Location location) {
        cells.replace(location, new AliveCell());
    }

    public void SetDeadAt(Location location) {
        cells.replace(location, new DeadCell());
    }

    public void SetDeadAt(@NotNull CollectionOfLocations deadLocations) {
        deadLocations.setDead(this);
    }

    public void SetAliveAt(CollectionOfLocations bornLocations) {
        bornLocations.setAlive(this);
    }

    private void forEach(BiConsumer<Location, Cell> action) {
        for (Location location : cells.keySet()) {
            action.accept(location, cells.get(location));
        }
    }

    public boolean IsAliveAt(Location location) {
        Cell cell = cells.get(location);
        if (cell == null) {
            return false;
        }
        return cell.IsAlive();
    }

    public void Tick(GameOfLifeListener listener) {
        var deadLocations = new CollectionOfLocations();
        var bornLocations = new CollectionOfLocations();
        forEach((location, cell) -> cell.Tick(getCellEventsListener(listener, location, deadLocations, bornLocations), getNumAliveNeighbours(location)));
        SetDeadAt(deadLocations);
        SetAliveAt(bornLocations);
    }

    private CellEventsListener getCellEventsListener(GameOfLifeListener listener, Location location, CollectionOfLocations deadLocations, CollectionOfLocations bornLocations) {
        return new CellEventsListener() {
            @Override
            public void CellDied() {
                listener.CellDiedAt(location);
                deadLocations.add(location);
            }

            @Override
            public void CellBorn() {
                listener.CellCreatedAt(location);
                bornLocations.add(location);
            }
        };
    }

    private int getNumAliveNeighbours(Location location) {
        return location.GetNumAliveNeighbours(this);
    }
}

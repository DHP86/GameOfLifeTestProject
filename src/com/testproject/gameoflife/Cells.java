package com.testproject.gameoflife;

import java.util.HashMap;
import java.util.Set;

public class Cells {
    private final HashMap<Location, Cell> cells = new HashMap<>();

    Cells() {
    }

    public Cell Get(Location location) {
        return cells.get(location);
    }

    public void InsertAt(Location location, Cell cell) { cells.put(location, cell); }

    public void SetAliveAt(Location location) {
        cells.replace(location, new AliveCell());
    }

    public void SetDeadAt(Location location) {
        cells.replace(location, new DeadCell());
    }

    public Set<Location> GetLocations() {
        return cells.keySet();
    }
}

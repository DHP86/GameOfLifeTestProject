package com.testproject.gameoflife;

import java.util.ArrayList;
import java.util.function.Consumer;

public class CollectionOfLocations {
    ArrayList<Location> locations = new ArrayList<>();

    public void add(Location location) {
        locations.add(location);
    }

    private void forEach(Consumer<Location> fn)
    {
        for (Location location : locations)
        {
            fn.accept(location);
        }
    }

    public void setDead(Cells cells)
    {
        forEach(cells::SetDeadAt);
    }

    public void setAlive(Cells cells)
    {
        forEach(cells::SetAliveAt);
    }

    public int GetNumAliveCells(Cells cells)
    {
        var ref = new Object() {
            int result = 0;
        };
        forEach(location -> ref.result += cells.IsAliveAt(location) ? 1 : 0);
        return ref.result;
    }
}

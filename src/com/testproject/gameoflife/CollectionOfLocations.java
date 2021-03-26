package com.testproject.gameoflife;

import java.util.ArrayList;
import java.util.function.Consumer;

public class CollectionOfLocations {
    ArrayList<Location> locations = new ArrayList<>();

    public void add(Location location) {
        locations.add(location);
    }

    public void forEach(Consumer<Location> fn) {
        for (Location location : locations) {
            fn.accept(location);
        }
    }

    public void setDead(Cells cells) {
        forEach(cells::SetDeadAt);
    }

    public void setAlive(Cells cells) {
        forEach(cells::SetAliveAt);
    }

}

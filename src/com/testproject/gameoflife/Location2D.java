package com.testproject.gameoflife;

import java.util.ArrayList;

public class Location2D implements Location {
    private final int x;
    private final int y;

    public Location2D(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public ArrayList<Location> GetNeighbourLocations() {
        ArrayList<Location> result = new ArrayList<>();

        result.add(new Location2D(subtract1(x), subtract1(y)));
        result.add(new Location2D(subtract1(x), y));
        result.add(new Location2D(subtract1(x), add1(y)));
        result.add(new Location2D(x, subtract1(y)));
        result.add(new Location2D(x, add1(y)));
        result.add(new Location2D(add1(x), subtract1(y)));
        result.add(new Location2D(add1(x), y));
        result.add(new Location2D(add1(x), add1(y)));

        return result;
    }

    private int subtract1(int i) {
        return (i - 1 + 1000) % 1000;
    }

    private int add1(int i) {
        return (i + 1) % 1000;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Location2D)) {
            return false;
        }
        Location2D location = (Location2D) o;
        return location.x == x && location.y == y;
    }

    @Override
    public int hashCode() {
        return x + 1000 * y;
    }
}

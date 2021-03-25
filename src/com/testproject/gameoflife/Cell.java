package com.testproject.gameoflife;

public interface Cell {
    void Tick(CellEventsListener listener, int numAliveNeighbours);

    boolean IsAlive();
}

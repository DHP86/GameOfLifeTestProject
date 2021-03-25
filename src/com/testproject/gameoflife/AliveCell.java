package com.testproject.gameoflife;

public class AliveCell implements Cell {
    @Override
    public void Tick(CellEventsListener listener, int numAliveNeighbours) {
        if (numAliveNeighbours != 2 && numAliveNeighbours != 3) {
            listener.CellDied();
        }
    }

    @Override
    public boolean IsAlive() {
        return true;
    }
}

package com.testproject.gameoflife;

public class DeadCell implements Cell {
    @Override
    public void Tick(CellEventsListener listener, int numAliveNeighbours) {
        if (numAliveNeighbours == 3)
        {
            listener.CellBorn();
        }
    }

    @Override
    public boolean IsAlive() {
        return false;
    }
}

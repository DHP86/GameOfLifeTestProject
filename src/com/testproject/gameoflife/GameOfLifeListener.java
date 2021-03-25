package com.testproject.gameoflife;

public interface GameOfLifeListener {
    void CellCreatedAt(Location location);

    void CellDiedAt(Location location);
}

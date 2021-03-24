package com.testproject.gameoflife;

public interface GameOfLifeListener {
    void CellCreatedAt(Location2D location);

    void CellDiedAt(Location2D location);
}

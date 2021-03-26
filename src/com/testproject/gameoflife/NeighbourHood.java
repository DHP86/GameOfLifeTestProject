package com.testproject.gameoflife;

import java.util.ArrayList;

public class NeighbourHood {
    private final ArrayList<CellWithNeighbours> cells = new ArrayList<>();

    public void Add(CellWithNeighbours cell) {
        cells.add(cell);
    }

    public int GetNumAlive() {
        var result = 0;
        for (var cell : cells) {
            if (cell.IsAlive()) {
                result++;
            }
        }
        return result;
    }
}

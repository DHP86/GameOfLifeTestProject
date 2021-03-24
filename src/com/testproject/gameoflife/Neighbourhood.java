package com.testproject.gameoflife;

import java.util.ArrayList;

public class Neighbourhood {
    private ArrayList<Cell> neighbours = new ArrayList<>();

    public void AddNeighbour(Cell cell)
    {
        neighbours.add(cell);
    }

    public void InformNeighboursAboutNewBornCell() {
        for (Cell cell : neighbours)
        {
            cell.NeighbourBorn();
        }
    }
}

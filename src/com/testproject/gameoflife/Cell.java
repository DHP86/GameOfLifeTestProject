package com.testproject.gameoflife;

public class Cell {
    private Neighbourhood neighbourhood = new Neighbourhood();
    private boolean alive = false;
    private int numNeighbours = 0;

    public Cell() {
    }

    public void Tick(CellEventsListener listener) {
        if (alive && numNeighbours != 2) {
            listener.CellDied();
        }
    }

    public void AddNeighbour(Cell cell) {
        neighbourhood.AddNeighbour(cell);
    }

    public void SetAlive() {
        alive = true;
        neighbourhood.InformNeighboursAboutNewBornCell();
    }

    public void NeighbourBorn() {
        numNeighbours++;
    }
}

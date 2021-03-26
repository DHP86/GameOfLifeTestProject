package com.testproject.gameoflife;

public class CellWithNeighbours {
    private final NeighbourHood neighbours = new NeighbourHood();
    private Cell cell;

    public CellWithNeighbours(Cell cell) {
        this.cell = cell;
    }

    public boolean IsAlive() {
        return cell.IsAlive();
    }

    public void Tick(CellEventsListener cellEventsListener) {
        int numAliveNeighbours = neighbours.GetNumAlive();
        cell.Tick(cellEventsListener, numAliveNeighbours);
    }

    public void SetAlive() {
        cell = new AliveCell();
    }

    public void SetDead() {
        cell = new DeadCell();
    }

    public void AddNeighbour(CellWithNeighbours cell) {
        neighbours.Add(cell);
    }
}

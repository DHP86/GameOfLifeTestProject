package com.testproject.gameoflife;

import java.util.HashMap;
import java.util.function.BiConsumer;

public class Cells {
    private final HashMap<Location, CellWithNeighbours> cells = new HashMap<>();

    public Cells() {
    }

    public void InsertAt(Location location, Cell cell) {
        cells.put(location, new CellWithNeighbours(cell));
    }

    public void ConnectNeighbours() {
        for (var location : cells.keySet()) {
            var neighbours = location.GetNeighbourLocations();
            neighbours.forEach(otherLocation -> {
                var cell1 = cells.get(location);
                var cell2 = cells.get(otherLocation);
                cell1.AddNeighbour(cell2);
            });
        }
    }

    public void SetAliveAt(Location location) {
        var cell = cells.get(location);
        cell.SetAlive();
    }

    public void SetDeadAt(Location location) {
        var cell = cells.get(location);
        cell.SetDead();
    }

    public void SetDeadAt(CollectionOfLocations deadLocations) {
        deadLocations.setDead(this);
    }

    public void SetAliveAt(CollectionOfLocations bornLocations) {
        bornLocations.setAlive(this);
    }

    private void forEach(BiConsumer<Location, CellWithNeighbours> action) {
        for (Location location : cells.keySet()) {
            action.accept(location, cells.get(location));
        }
    }

    public void Tick(GameOfLifeListener listener) {
        var deadLocations = new CollectionOfLocations();
        var bornLocations = new CollectionOfLocations();
        var factory = new CellEventsListenerFactory(listener, deadLocations, bornLocations);
        forEach((location, cell) -> cell.Tick(factory.GetCellEventsListener(location)));
        SetDeadAt(deadLocations);
        SetAliveAt(bornLocations);
    }
}

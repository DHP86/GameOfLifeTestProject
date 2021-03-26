package com.testproject.gameoflife;

public class CellEventsListenerFactory {
    private final GameOfLifeListener listener;
    private final CollectionOfLocations deadLocations;
    private final CollectionOfLocations bornLocations;

    public CellEventsListenerFactory(GameOfLifeListener listener, CollectionOfLocations deadLocations, CollectionOfLocations bornLocations) {
        this.listener = listener;
        this.deadLocations = deadLocations;
        this.bornLocations = bornLocations;
    }

    public CellEventsListener GetCellEventsListener(Location location) {
        return new CellEventsListener() {
            @Override
            public void CellDied() {
                listener.CellDiedAt(location);
                deadLocations.add(location);
            }

            @Override
            public void CellBorn() {
                listener.CellCreatedAt(location);
                bornLocations.add(location);
            }
        };
    }
}

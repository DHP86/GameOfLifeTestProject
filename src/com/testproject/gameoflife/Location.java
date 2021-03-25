package com.testproject.gameoflife;

import java.util.ArrayList;

public interface Location {
    ArrayList<Location> GetNeighbourLocations();
}

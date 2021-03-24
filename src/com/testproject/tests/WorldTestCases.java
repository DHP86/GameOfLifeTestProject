package com.testproject.tests;

import com.testproject.gameoflife.Location2D;
import com.testproject.gameoflife.GameOfLifeListener;
import com.testproject.gameoflife.World;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import java.awt.*;

import static org.mockito.Mockito.*;

public class WorldTestCases {
    private World world;
    private GameOfLifeListener mock;
    @BeforeEach
    public void SetUp()
    {
        world = new World(new Dimension(1000, 1000));
        mock = mock(GameOfLifeListener.class);

    }

    @Test
    public void ACellDiesIfNoNeighbours()
    {
        Location2D location2D = new Location2D(10, 10);
        world.SetAliveAt(location2D);

        world.Tick(mock);
        verify(mock).CellDiedAt(location2D);
    }

//    @Test
//    public void ACellSurvivesIfItHasTwoNeighbours()
//    {
//        Location aliveLocation = Location.Create(10, 10);
//        world.SetAliveAt(aliveLocation);
//        world.SetAliveAt(Location.Create(10, 11));
//        world.SetAliveAt(Location.Create(11, 10));
//
//        world.Tick(mock);
//        verify(mock, never()).CellDiedAt(aliveLocation);
//    }
}

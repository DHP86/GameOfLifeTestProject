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
        world.SetAliveAt( new Location2D(10, 10));

        world.Tick(mock);
        verify(mock).CellDiedAt( new Location2D(10, 10));
    }

    @Test
    public void ACellWithOnly1NeighbourDies()
    {
        world.SetAliveAt(new Location2D(10,10));
        world.SetAliveAt(new Location2D(10,11));

        world.Tick(mock);

        verify(mock).CellDiedAt( new Location2D(10, 10));
    }

    @Test
    public void ALiveCellWithTwoNeighboursStaysAlive()
    {
        Location2D aliveLocation = Location2D.Create(10, 10);
        world.SetAliveAt(aliveLocation);
        world.SetAliveAt(Location2D.Create(10, 11));
        world.SetAliveAt(Location2D.Create(10, 9));

        world.Tick(mock);
        verify(mock).CellDiedAt(Location2D.Create(10, 11));
        verify(mock).CellDiedAt(Location2D.Create(10, 9));
        verify(mock, never()).CellDiedAt(aliveLocation);
    }

    @Test
    public void ALiveCellWithMoreThanThreeNeighboursDies()
    {
        world.SetAliveAt(new Location2D(10,10));
        world.SetAliveAt(new Location2D(10,11));
        world.SetAliveAt(new Location2D(11,11));
        world.SetAliveAt(new Location2D(9,10));
        world.SetAliveAt(new Location2D(9,11));

        world.Tick(mock);
        verify(mock).CellDiedAt(new Location2D(10,10));
    }

    @Test
    public void ADeadCellComesToLifeIfItHasExactlyThreeNeighbours()
    {
        world.SetAliveAt(new Location2D(10,9));
        world.SetAliveAt(new Location2D(10,11));
        world.SetAliveAt(new Location2D(11,11));

        world.Tick(mock);
        verify(mock).CellCreatedAt(new Location2D(10, 10));
    }

    @Test
    public void ALiveCellWithThreeNeighboursStaysAlive()
    {
        world.SetAliveAt(new Location2D(10, 10));
        world.SetAliveAt(new Location2D(10, 11));
        world.SetAliveAt(new Location2D(11, 11));
        world.SetAliveAt(new Location2D(11, 10));

        world.Tick(mock);
        verify(mock, never()).CellDiedAt(new Location2D(10, 10));
        verify(mock, never()).CellDiedAt(new Location2D(10, 11));
        verify(mock, never()).CellDiedAt(new Location2D(11, 11));
        verify(mock, never()).CellDiedAt(new Location2D(11, 10));
    }

    @Test
    public void TicksChangeTheWorld()
    {
        world.SetAliveAt(new Location2D(10, 10));

        world.Tick(mock);
        verify(mock).CellDiedAt(new Location2D(10,10));
        mock = mock(GameOfLifeListener.class);
        world.Tick(mock);
        verify(mock, never()).CellDiedAt(any());
    }
}

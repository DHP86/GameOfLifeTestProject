package com.testproject.tests;

import com.testproject.gameoflife.Cell;
import com.testproject.gameoflife.CellEventsListener;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

public class CellTestCases {
    private Cell cell = new Cell();
    private Cell neighbourCell1 = new Cell();
    private Cell neighbourCell2 = new Cell();
    CellEventsListener mock = mock(CellEventsListener.class);

    private void link(Cell cell1, Cell cell2)
    {
        cell1.AddNeighbour(cell2);
        cell2.AddNeighbour(cell1);
    }

    @BeforeEach
    public void SetUp()
    {
        link(neighbourCell1, cell);
        link(cell, neighbourCell2);
    }

    @Test
    public void ACellStartsOutDead()
    {
        cell.Tick(mock);
        verify(mock, never()).CellDied();
        verify(mock, never()).CellBorn();
    }

    @Test
    public void ACellDiesIfNoNeighbours()
    {
        cell.SetAlive();
        cell.Tick(mock);
        verify(mock).CellDied();
    }

    @Test
    public void ACellNotifiesNeighboursWhenBeingBorn()
    {
        Cell mockCell = mock(Cell.class);
        link(cell, mockCell);
        cell.SetAlive();
        verify(mockCell).NeighbourBorn();
    }

    @Test
    public void ACellStaysAliveIfTwoAliveNeighbours()
    {
        cell.SetAlive();
        neighbourCell1.SetAlive();
        neighbourCell2.SetAlive();

        cell.Tick(mock);
        verify(mock, never()).CellDied();
    }
}

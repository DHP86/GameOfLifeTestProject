package com.testproject.gameoflife;

public class GameOfLifeConfig {
    public static void ConfigureWorld(World world) {
        for (int i = 0; i < 1000; i++) {
            world.SetAliveAt(new Location2D(i, 500));
            world.SetAliveAt(new Location2D(i, 510));
            world.SetAliveAt(new Location2D(i, 490));
        }

        for (int i = 0; i < 1000; i++)
        {
            world.SetAliveAt(new Location2D(i, 950));
            world.SetAliveAt(new Location2D(i, 955));
            world.SetAliveAt(new Location2D(i, 960));
        }

        for (int j = 0; j < 750; j++) {
            world.SetAliveAt(new Location2D(500, j));
            world.SetAliveAt(new Location2D(150, j));
            world.SetAliveAt(new Location2D(800, j));
        }


        for (int i = 0; i < 1000; i += 137) {
            for (int j = 0; j < 1000; j += 78) {
                world.SetAliveAt(new Location2D(i, j));
                world.SetAliveAt(new Location2D(i - 1, j));
                world.SetAliveAt(new Location2D(i, j - 1));
                world.SetAliveAt(new Location2D(i, j + 1));
                world.SetAliveAt(new Location2D(i + 1, j + 1));
            }
        }

        world.SetAliveAt(new Location2D(10, 10));
        world.SetAliveAt(new Location2D(9, 10));
        world.SetAliveAt(new Location2D(10, 9));
        world.SetAliveAt(new Location2D(10, 11));
        world.SetAliveAt(new Location2D(11, 11));
    }
}

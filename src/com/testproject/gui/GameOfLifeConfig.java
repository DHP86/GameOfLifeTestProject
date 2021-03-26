package com.testproject.gui;

import com.testproject.gameoflife.Cells;

import java.awt.image.BufferedImage;

public class GameOfLifeConfig {
    public static void ConfigureWorld(Cells world, BufferedImage img) {
        for (int i = 0; i < 1000; i++) {
            world.SetAliveAt(new GuiLocation2D(i, 500, img));
            world.SetAliveAt(new GuiLocation2D(i, 510, img));
            world.SetAliveAt(new GuiLocation2D(i, 490, img));
        }

        for (int i = 0; i < 1000; i++) {
            world.SetAliveAt(new GuiLocation2D(i, 950, img));
            world.SetAliveAt(new GuiLocation2D(i, 955, img));
            world.SetAliveAt(new GuiLocation2D(i, 960, img));
        }

        for (int j = 0; j < 750; j++) {
            world.SetAliveAt(new GuiLocation2D(500, j, img));
            world.SetAliveAt(new GuiLocation2D(150, j, img));
            world.SetAliveAt(new GuiLocation2D(800, j, img));
        }


        for (int i = 0; i < 1000; i += 137) {
            for (int j = 0; j < 1000; j += 78) {
                world.SetAliveAt(new GuiLocation2D(i, j, img));
                world.SetAliveAt(new GuiLocation2D(i - 1, j, img));
                world.SetAliveAt(new GuiLocation2D(i, j - 1, img));
                world.SetAliveAt(new GuiLocation2D(i, j + 1, img));
                world.SetAliveAt(new GuiLocation2D(i + 1, j + 1, img));
            }
        }

        world.SetAliveAt(new GuiLocation2D(10, 10, img));
        world.SetAliveAt(new GuiLocation2D(9, 10, img));
        world.SetAliveAt(new GuiLocation2D(10, 9, img));
        world.SetAliveAt(new GuiLocation2D(10, 11, img));
        world.SetAliveAt(new GuiLocation2D(11, 11, img));
    }
}

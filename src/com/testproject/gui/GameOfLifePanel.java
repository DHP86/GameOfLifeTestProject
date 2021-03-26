package com.testproject.gui;

import com.testproject.gameoflife.Cells;
import com.testproject.gameoflife.DeadCell;
import com.testproject.gameoflife.GameOfLifeListener;
import com.testproject.gameoflife.Location;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

public class GameOfLifePanel extends JPanel implements GameOfLifeListener {
    private static final int AliveRgbColor = Color.BLACK.getRGB();
    private static final int DeadRgbColor = Color.WHITE.getRGB();
    private final BufferedImage img;

    GameOfLifePanel(int width, int height) {
        img = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

        var cells = new Cells();
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                cells.InsertAt(new GuiLocation2D(i, j, img), new DeadCell());
            }
        }
        cells.ConnectNeighbours();

        GameOfLifeConfig.ConfigureWorld(cells, img);

        int delay = 50; //milliseconds
        ActionListener taskPerformer = evt -> {
            cells.Tick(this);
            Draw();
        };
        new Timer(delay, taskPerformer).start();

        initializeAllCellsAsDeadCells();
    }

    private void initializeAllCellsAsDeadCells() {
        for (int i = 0; i < img.getWidth(); i++) {
            drawVerticalLineAtCoordinate(i);
        }
    }

    private void drawVerticalLineAtCoordinate(int i) {
        for (int j = 0; j < img.getHeight(); j++) {
            img.setRGB(i, j, DeadRgbColor);
        }
    }

    public void Draw() {
        getGraphics().drawImage(img, 0, 0, this);
    }

    @Override
    public void CellCreatedAt(Location location) {
        ((GuiLocation2D) location).SetRGBPixel(AliveRgbColor);
    }

    @Override
    public void CellDiedAt(Location location) {
        ((GuiLocation2D) location).SetRGBPixel(DeadRgbColor);
    }

    public BufferedImage img() {
        return img;
    }
}

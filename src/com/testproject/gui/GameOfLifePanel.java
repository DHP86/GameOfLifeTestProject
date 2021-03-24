package com.testproject.gui;
import com.testproject.gameoflife.Location2D;
import com.testproject.gameoflife.GameOfLifeListener;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.image.BufferedImage;

public class GameOfLifePanel extends JPanel implements GameOfLifeListener {
    private static final int AliveRgbColor = Color.BLACK.getRGB();
    private static final int DeadRgbColor = Color.WHITE.getRGB();
    private final BufferedImage img;

    GameOfLifePanel(int width, int height)
    {
        img =  new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB );
        initializeAllCellsAsDeadCells();
    }

    private void initializeAllCellsAsDeadCells() {
        for (int i = 0; i < img.getWidth(); i++)
        {
            for (int j = 0; j < img.getHeight(); j++)
            {
                img.setRGB(i, j, DeadRgbColor);
            }
        }
    }

    public void Draw()
    {
        getGraphics().drawImage(img, 0,0, this);
    }

    @Override
    public void CellCreatedAt(Location2D location2D) {
        img.setRGB(location2D.getX(), location2D.getY(), AliveRgbColor);
    }

    @Override
    public void CellDiedAt(Location2D location2D) {
        img.setRGB(location2D.getX(), location2D.getY(), DeadRgbColor);
    }
}

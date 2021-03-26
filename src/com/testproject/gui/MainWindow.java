package com.testproject.gui;

import com.testproject.gameoflife.GameOfLifeConfig;
import com.testproject.gameoflife.World;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class MainWindow extends JFrame {
    private final GameOfLifePanel panel;

    public MainWindow() {
        super("Conway's Game of Life");
        setSize(1100, 1100);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        int width = 1000;
        int height = 1000;
        panel = new GameOfLifePanel(width, height);
        panel.setPreferredSize(new Dimension(width, height));

        World world = new World(new Dimension(1000, 1000));

        GameOfLifeConfig.ConfigureWorld(world);

        int delay = 200; //milliseconds
        ActionListener taskPerformer = evt -> {
            world.Tick(panel);
            panel.Draw();
        };
        new Timer(delay, taskPerformer).start();

        add(panel, BorderLayout.WEST);
    }
}

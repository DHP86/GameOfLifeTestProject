package com.testproject.gui;

import com.testproject.gameoflife.World;

import javax.swing.*;
import java.awt.*;

public class MainWindow extends JFrame {
    public MainWindow()
    {
        super("Conway's Game of Life");
        setSize(1100,1100);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        int width = 1000;
        int height = 1000;
        panel = new GameOfLifePanel(width, height);
        panel.setPreferredSize(new Dimension(width, height));
        JButton button = new JButton("Tick");

        World world = new World(new Dimension(1000, 1000));

        button.addActionListener(e -> {
            world.Tick(panel);
            panel.Draw();
        });

        add(button, BorderLayout.EAST);
        add(panel, BorderLayout.WEST);
    }

    private final GameOfLifePanel panel;
}

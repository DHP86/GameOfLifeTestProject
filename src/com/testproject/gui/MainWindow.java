package com.testproject.gui;

import com.testproject.gameoflife.Location2D;
import com.testproject.gameoflife.World;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.Timer;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionListener;

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

        for (int i = 0; i < 1000; i++)
        {
            world.SetAliveAt(new Location2D(i, 500));
            world.SetAliveAt(new Location2D(i, 510));
            world.SetAliveAt(new Location2D(i, 490));
        }

        for (int j = 250; j < 750; j++)
        {
            world.SetAliveAt(new Location2D(500, j));
            world.SetAliveAt(new Location2D(100, j));
            world.SetAliveAt(new Location2D(150, j));
            world.SetAliveAt(new Location2D(800, j));
        }

        world.SetAliveAt(new Location2D(10,10));
        world.SetAliveAt(new Location2D(9,10));
        world.SetAliveAt(new Location2D(10,9));
        world.SetAliveAt(new Location2D(10,11));
        world.SetAliveAt(new Location2D(11,11));

        button.addActionListener(e -> {
            world.Tick(panel);
            panel.Draw();
        });

        int delay = 200; //milliseconds
        ActionListener taskPerformer = evt -> {
            world.Tick(panel);
            panel.Draw();
        };
        new Timer(delay, taskPerformer).start();

        add(button, BorderLayout.EAST);
        add(panel, BorderLayout.WEST);
    }

    private final GameOfLifePanel panel;
}

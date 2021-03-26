package com.testproject.gui;

import javax.swing.*;
import java.awt.*;

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


        add(panel, BorderLayout.WEST);
    }
}

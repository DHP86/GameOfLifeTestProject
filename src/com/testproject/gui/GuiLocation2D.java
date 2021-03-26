package com.testproject.gui;

import com.testproject.gameoflife.Location2D;

import java.awt.image.BufferedImage;

public class GuiLocation2D extends Location2D {
    private final BufferedImage img;

    public GuiLocation2D(int x, int y, BufferedImage img) {
        super(x, y);
        this.img = img;
    }

    public void SetRGBPixel(int rgbValue) {
        img.setRGB(x, y, rgbValue);
    }
}

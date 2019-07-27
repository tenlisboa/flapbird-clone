package com.devthunder.entities;

import com.devthunder.main.Game;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Tube extends Entity {

    private boolean scored = false;

    public Tube(double x, double y, int width, int height, BufferedImage sprite) {
        super(x, y, width, height, sprite);
    }

    @Override
    public void tick() {
        x--;

        if ((x + width) < Game.player.getX()) {
            if (!scored) {
                Game.score += 0.5;
            }
            scored = true;
        }

        if (x + width <= 0) {
            Game.entities.remove(this);
        }
    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.green);
        g.fillRect((int) x, (int) y, width, height);
    }
}

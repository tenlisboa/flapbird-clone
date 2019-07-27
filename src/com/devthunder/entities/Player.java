package com.devthunder.entities;

import com.devthunder.main.Game;
import com.devthunder.world.Camera;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Player extends Entity {

    public boolean isPressed = false;

    public Player(int x, int y, int width, int height, BufferedImage sprite) {
        super(x, y, width, height, sprite);
    }

    @Override
    public void tick() {
        depth = 2;
        if (!isPressed) {
            y += 2;
        } else {
            if (y > 0)
                y -= 2;
        }

        if (y > Game.HEIGHT - 16) {
            Game.restartGame();
            return;
        }

        for (int i = 0; i < Game.entities.size(); i++) {
            Entity current = Game.entities.get(i);
            if (current != this) {
                if (isColidding(this, current)) {
                    Game.restartGame();
                }

            }
        }
    }

    @Override
    public void render(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;

        g2.rotate(Math.toRadians(isPressed ? -5 : 20), getX() + width / 2, getY() + height / 2);
        g2.drawImage(sprite, getX() - Camera.x, getY() - Camera.y, null);
        g2.rotate(Math.toRadians(isPressed ? 5 : -20), getX() + width / 2, getY() + height / 2);

//        g2.setColor(Color.red);
//        g2.fillRect(getX(), getY(), width, height);
    }
}

package com.devthunder.graphics;

import com.devthunder.main.Game;

import java.awt.*;

public class UI {

    public void render(Graphics g) {
        g.setColor(Color.white);
        g.setFont(new Font("aria", Font.PLAIN, 18));
        g.drawString("Score: " + (int) Game.score, 10, 20);
    }
}

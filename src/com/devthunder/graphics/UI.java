package com.devthunder.graphics;

import java.awt.*;

public class UI {

    public void render(Graphics g) {
        g.setColor(Color.white);
        g.setFont(new Font("aria", Font.PLAIN, 18));
        g.drawString("Score: 0", 10, 20);
    }
}

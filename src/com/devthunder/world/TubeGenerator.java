package com.devthunder.world;

import com.devthunder.entities.Entity;
import com.devthunder.entities.Tube;
import com.devthunder.main.Game;

public class TubeGenerator {

    public int time = 0;
    public int targetTime = 60;

    public void tick() {
        time++;
        if (time == targetTime) {
            time = 0;

            int height1 = Entity.rand.nextInt(60 - 30) + 30;
            Tube tube1 = new Tube(Game.WIDTH, 0, 20, height1, null);

            int height2 = Entity.rand.nextInt(60 - 30) + 30;
            Tube tube2 = new Tube(Game.WIDTH, Game.HEIGHT - height2, 20, height2, null);

            Game.entities.add(tube1);
            Game.entities.add(tube2);
        }
    }
}

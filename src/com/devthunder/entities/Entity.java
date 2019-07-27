package com.devthunder.entities;

import com.devthunder.world.Camera;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Comparator;
import java.util.Random;

public class Entity {


    protected double x;
    protected double y;
    protected int width;
    protected int height;

    public int depth;

    public boolean debug = false;

    protected BufferedImage sprite;

    public static Random rand = new Random();

    public Entity(double x, double y, int width, int height, BufferedImage sprite) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.sprite = sprite;
    }

    public static Comparator<Entity> nodeSorter = new Comparator<Entity>() {

        @Override
        public int compare(Entity n0, Entity n1) {
            if (n1.depth < n0.depth)
                return +1;
            if (n1.depth > n0.depth)
                return -1;
            return 0;
        }

    };

    public void setX(int newX) {
        x = newX;
    }

    public void setY(int newY) {
        y = newY;
    }

    public int getX() {
        return (int) x;
    }

    public int getY() {
        return (int) y;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public void tick() {
    }

    public double calculateDistance(int x1, int y1, int x2, int y2) {
        return Math.sqrt((x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2));
    }

    public static boolean isColidding(Entity e1, Entity e2) {
        Rectangle e1Mask = new Rectangle(e1.getX(), e1.getY(), e1.getWidth(), e1.getHeight());
        Rectangle e2Mask = new Rectangle(e2.getX(), e2.getY(), e2.getWidth(), e2.getHeight());

        return e1Mask.intersects(e2Mask);
    }

    public void render(Graphics g) {
        g.drawImage(sprite, getX() - Camera.x, getY() - Camera.y, null);
        //g.setColor(Color.red);
        //g.fillRect(this.getX() + maskx - Camera.x,this.getY() + masky - Camera.y,mwidth,mheight);
    }

}

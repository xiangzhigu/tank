package com.mashibing.tank;

import java.awt.*;

public class Explode {
    private int x,y;
    public static int WIDTH = ResourceMgr.explode[0].getWidth();
    public static int HEIGHT = ResourceMgr.explode[0].getHeight();

    private boolean living = true;
    TankFrame tankFrame = null;

    private int step = 0;


    public Explode(int x, int y, TankFrame tankFrame) {
        this.x = x;
        this.y = y;
        this.tankFrame = tankFrame;

        new Audio("audio/explode.wav").play();
    }


    public void paint(Graphics g){
        g.drawImage(ResourceMgr.explode[step++], x, y, null);
        if(step>=ResourceMgr.explode.length)
            step = 0;
    }
}

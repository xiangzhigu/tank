package com.mashibing.tank;

import java.awt.*;

public class Explode extends GameObject{
//    private int x,y;
    public static int WIDTH = ResourceMgr.explode[0].getWidth();
    public static int HEIGHT = ResourceMgr.explode[0].getHeight();

//    TankFrame tankFrame = null;
//    GameModel gameModel = null;

    private int step = 0;


    public Explode(int x, int y) {
        this.x = x;
        this.y = y;
//        new Thread(()->new Audio("audio/explode.wav").play()).start();  //爆炸声
       GameModel.getInstance().add(this);
    }


    public void paint(Graphics g){
        g.drawImage(ResourceMgr.explode[step++], x, y, null);
        if(step >= ResourceMgr.explode.length)
           GameModel.getInstance().remove(this);
    }

    @Override
    public int getWidth() {
        return WIDTH;
    }

    @Override
    public int getHeight() {
        return HEIGHT;
    }
}

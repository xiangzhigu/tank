package com.mashibing.tank;

import java.awt.*;

public class Explode {
    private int x,y;
    public static int WIDTH = ResourceMgr.explode[0].getWidth();
    public static int HEIGHT = ResourceMgr.explode[0].getHeight();

//    TankFrame tankFrame = null;
    GameModel gameModel = null;

    private int step = 0;


    public Explode(int x, int y, GameModel gameModel) {
        this.x = x;
        this.y = y;
        this.gameModel = gameModel;

//        new Thread(()->new Audio("audio/explode.wav").play()).start();  //爆炸声
    }


    public void paint(Graphics g){
        g.drawImage(ResourceMgr.explode[step++], x, y, null);
        if(step >= ResourceMgr.explode.length)
           gameModel.explodes.remove(this);
    }
}

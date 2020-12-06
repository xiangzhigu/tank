package com.mashibing.tank;

import java.awt.*;

public class Bullet {
    private static final int SPEED = 10;
    private int x,y;
    private Dir dir;
    private static int WIDTH = 20, HEIGHT = 20;

    private boolean live = true;
    TankFrame tankFrame = null;

    public Bullet(int x, int y, Dir dir, TankFrame tankFrame) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.tankFrame = tankFrame;
    }

    public void paint(Graphics g){
        if (!live){
            tankFrame.bullets.remove(this);
        }
        switch (dir){
            case LEFT:
                g.drawImage(ResourceMgr.bulletL,x,y,null);
                break;
            case UP:
                g.drawImage(ResourceMgr.bulletU,x,y,null);
                break;
            case RIGHT:
                g.drawImage(ResourceMgr.bulletR,x,y,null);
                break;
            case DOWN:
                g.drawImage(ResourceMgr.bulletD,x,y,null);
                break;
        }

//        Color c = g.getColor();
//        g.setColor(Color.RED);
//        g.fillOval(x,y,WIDTH,HEIGHT);
//        g.setColor(c);
        move();
    }
    private void move() {
        switch (dir){
            case LEFT:
                x-=SPEED;
                break;
            case RIGHT:
                x+=SPEED;
                break;
            case UP:
                y-=SPEED;
                break;
            case DOWN:
                y+=SPEED;
                break;
        }

        if(x<0||y<0||x>TankFrame.GAME_WIDTH||y>TankFrame.GAME_HEIGHT){
            live=false;
        }
    }
}

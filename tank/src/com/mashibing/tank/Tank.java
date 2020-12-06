package com.mashibing.tank;

import java.awt.*;

public class Tank {
    private int x,y;
    private Dir dir = Dir.DOWN;
    private final static int SPEED = 5;

    public static int WIDTH = ResourceMgr.tankL.getWidth();
    public static int HEIGHT = ResourceMgr.tankL.getHeight();

    private boolean moving = false;
    private boolean living = true;

    private TankFrame tankFrame =null;

    public Tank(int x, int y, Dir dir, TankFrame tankFrame) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.tankFrame = tankFrame;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Dir getDir() {
        return dir;
    }

    public void setDir(Dir dir) {
        this.dir = dir;
    }

    public boolean isMoving() {
        return moving;
    }

    public void setMoving(boolean moving) {
        this.moving = moving;
    }

    public void paint(Graphics g){
        if(!living) tankFrame.tanks.remove(this);
        switch (dir){
            case LEFT:
                g.drawImage(ResourceMgr.tankL,x,y,null);
                break;
            case UP:
                g.drawImage(ResourceMgr.tankU,x,y,null);
                break;
            case RIGHT:
                g.drawImage(ResourceMgr.tankR,x,y,null);
                break;
            case DOWN:
                g.drawImage(ResourceMgr.tankD,x,y,null);
                break;
        }
//        g.setColor(Color.YELLOW);
//        g.fillRect(x,y,50,50);
//        g.setColor(color);
        move();
    }

    private void move() {
        if(!moving) return;;
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
    }

    public void fire() {
        int bX = this.x + Tank.WIDTH/2 - Bullet.WIDTH/2;
        int bY = this.y + Tank.HEIGHT/2 - Bullet.HEIGHT/2;
        tankFrame.bullets.add(new Bullet(bX,bY,this.dir,this.tankFrame));
    }

    public void die() {
        this.living = false;
    }
}

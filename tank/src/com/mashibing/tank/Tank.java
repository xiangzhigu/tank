package com.mashibing.tank;

import com.mashibing.tank.abstractfactory.BaseTank;

import java.awt.*;
import java.util.Random;

public class Tank extends BaseTank {
    int x,y;
    Dir dir = Dir.DOWN;
    private final static int SPEED = 5;
//    Group group = Group.BAD;

    private Random random  = new Random();

//    public  Rectangle rectangle = new Rectangle();

    public static int WIDTH = ResourceMgr.goodTankU.getWidth();
    public static int HEIGHT = ResourceMgr.goodTankU.getHeight();

    private boolean moving = true;
    private boolean living = true;

    TankFrame tankFrame =null;

//    FireStrategy fireStrategy = new DefaultFireStrategy();

    public Tank(int x, int y, Dir dir,Group group, TankFrame tankFrame) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.group = group;
        this.tankFrame = tankFrame;

        rectangle.x = this.x;
        rectangle.y = this.y;
        rectangle.width = WIDTH;
        rectangle.height = HEIGHT;

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

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public void paint(Graphics g){
        if(!living) tankFrame.tanks.remove(this);
        switch (dir){
            case LEFT:
                g.drawImage(this.group ==Group.GOOD ? ResourceMgr.goodTankL : ResourceMgr.badTankL,x,y,null);
                break;
            case UP:
                g.drawImage(this.group ==Group.GOOD ? ResourceMgr.goodTankU : ResourceMgr.badTankU,x,y,null);
                break;
            case RIGHT:
                g.drawImage(this.group ==Group.GOOD ? ResourceMgr.goodTankR : ResourceMgr.badTankR,x,y,null);
                break;
            case DOWN:
                g.drawImage(this.group ==Group.GOOD ? ResourceMgr.goodTankD : ResourceMgr.badTankD,x,y,null);
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

        if(this.group == Group.BAD && random.nextInt(100) > 95)
            this.fire();
        if(this.group == Group.BAD && random.nextInt(100)>95)
            randomDir();
        //边界检测
        boundsCheck();
        rectangle.x = this.x;
        rectangle.y = this.y;
    }

    private void boundsCheck() {
        if(this.x < 0) x=0;
        if(this.y < 30) y = 30;
        if(this.x > TankFrame.GAME_WIDTH - Tank.WIDTH) x = TankFrame.GAME_WIDTH - Tank.WIDTH;
        if(this.y > TankFrame.GAME_HEIGHT - Tank.HEIGHT) y = TankFrame.GAME_HEIGHT - Tank.HEIGHT;
    }

    private void randomDir() {
        this.dir = Dir.values()[random.nextInt(4)];
    }

    public void fire() {
//        DefaultFireStrategy.getInstance().fire(this);
        if (this.group != Group.GOOD) {
            DefaultFireStrategy.getInstance().fire(this);
        } else {
            FourDirFireStrategy.getInstance().fire(this);
        }
//        int bX = this.x + Tank.WIDTH/2 - Bullet.WIDTH/2;
//        int bY = this.y + Tank.HEIGHT/2 - Bullet.HEIGHT/2;
//        Dir[] dirs = Dir.values();
//        for (Dir dir: dirs) {
////            new Bullet(bX,bY,dir,t.group,t.tankFrame);
//            this.tankFrame.gameFactory.createBullet(bX,bY,dir,this.group,this.tankFrame);
//        }
    }

    public void die() {
        this.living = false;
    }
}

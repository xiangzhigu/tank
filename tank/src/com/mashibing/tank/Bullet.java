package com.mashibing.tank;

import java.awt.*;

public class Bullet extends GameObject{
    private static final int SPEED = 10;
    private int x,y;
    private Dir dir;
    public static int WIDTH = ResourceMgr.bulletD.getWidth();
    public static int HEIGHT = ResourceMgr.bulletD.getHeight();

    Rectangle rectangle = new Rectangle();

    private boolean living = true;
//    TankFrame tankFrame = null;
    GameModel gameModel = null;
    private Group group = Group.BAD;

    public Bullet(int x, int y, Dir dir, Group group,GameModel gameModel) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.group = group;
        this.gameModel = gameModel;

        rectangle.x = this.x;
        rectangle.y = this.y;
        rectangle.width = WIDTH;
        rectangle.height = HEIGHT;

        gameModel.add(this);
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public void paint(Graphics g){
        if (!living){
            gameModel.remove(this);
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
        //update rectangle
        rectangle.x = this.x;
        rectangle.y = this.y;

        if(x<0||y<0||x>TankFrame.GAME_WIDTH||y>TankFrame.GAME_HEIGHT){
            living=false;
        }
    }

    public boolean collidewith(Tank tank) {
        if(this.group == tank.getGroup()) return false;

        //TODO:用一个rectangle来记录子弹的位置
//        Rectangle rectangle1 = new Rectangle(this.x,this.y,WIDTH,HEIGHT);
//        Rectangle rectangle2 = new Rectangle(tank.getX(),tank.getY(),Tank.WIDTH,Tank.HEIGHT);
        if(rectangle.intersects(tank.rectangle)){
            tank.die();
            this.die();
            int eX = tank.getX() + Tank.WIDTH/2 - Explode.WIDTH/2;
            int eY = tank.getY() + Tank.HEIGHT/2 - Explode.HEIGHT/2;
            gameModel.add(new Explode(eX,eY,gameModel));
            return true;
        }
        return false;
    }

    private void die() {
        this.living = false;
    }
}

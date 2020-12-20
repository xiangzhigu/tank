package com.mashibing.tank;

import com.mashibing.tank.cor.BulletTankCollider;
import com.mashibing.tank.cor.Collider;
import com.mashibing.tank.cor.ColliderChain;
import com.mashibing.tank.cor.TankTankCollider;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class GameModel {

    private static final GameModel INSTANCE = new GameModel();

    static {
        INSTANCE.init();
    }

    private void init(){
        myTank = new Tank(200,400,Dir.DOWN,Group.GOOD);

        int initTankCount = Integer.parseInt((String) PropertMgr.get("initTankCount")) ;

        //初始化敌方坦克
        for (int i = 0; i < initTankCount; i++) {
            new Tank(50 + i*80,200,Dir.DOWN,Group.BAD);
        }
        add(new Wall(150,150,200,50));
        add(new Wall(550,150,200,50));
        add(new Wall(300,300,50,250));
        add(new Wall(550,300,50,250));
    }

    public static GameModel getInstance(){
        return INSTANCE;
    }

    Tank myTank;

    ColliderChain colliderChain = new ColliderChain();

//    Collider collider = new BulletTankCollider();
//    Collider collider2 = new TankTankCollider();
//    List<Bullet> bullets = new ArrayList<>();
//    List<Tank> tanks = new ArrayList<>();
//    List<Explode> explodes = new ArrayList<>();

    private List<GameObject> objects = new ArrayList<>();

    public void add(GameObject gameObject){
        this.objects.add(gameObject);
    }
    public void remove(GameObject gameObject){
        this.objects.remove(gameObject);
    }

    private GameModel() {

    }

    public void print(Graphics g) {
        Color c= g.getColor();
        g.setColor(Color.WHITE);
//        g.drawString("子弹的数量"+bullets.size(),10,60);
//        g.drawString("敌人的数量"+tanks.size(),10,80);
//        g.drawString("爆炸的数量"+tanks.size(),10,100);
        g.setColor(c);
        myTank.paint(g);
//        bullets.stream().forEach(bullet1 -> bullet1.paint(g));
//        for (int i = 0; i < bullets.size(); i++) {
//            bullets.get(i).paint(g);
//        }
//        for (int i = 0; i < tanks.size(); i++) {
//            tanks.get(i).paint(g);
//        }
//        for (int i = 0; i < explodes.size(); i++) {
//            explodes.get(i).paint(g);
//        }
        for (int i = 0; i < objects.size(); i++) {
            objects.get(i).paint(g);
        }

        //碰撞检测
//        for (int i = 0; i < bullets.size(); i++) {
//            for (int j = 0; j < tanks.size(); j++) {
//                bullets.get(i).collidewith(tanks.get(j));
//            }
//        }
        for (int i = 0; i < objects.size(); i++) {
            for (int j = i+1; j < objects.size(); j++) {
                GameObject o1 = objects.get(i);
                GameObject o2 = objects.get(j);
//                collider.collide(o1,o2);
//                collider2.collide(o1,o2);
                //for
                colliderChain.collide(o1,o2);
            }
        }
    }

    public Tank getMainTank() {
        return myTank;
    }
}

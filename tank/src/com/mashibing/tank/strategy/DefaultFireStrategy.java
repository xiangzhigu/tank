package com.mashibing.tank.strategy;

import com.mashibing.tank.Bullet;
import com.mashibing.tank.GameModel;
import com.mashibing.tank.Tank;
import com.mashibing.tank.decorator.RectDecorator;
import com.mashibing.tank.decorator.TailDecorator;

public class DefaultFireStrategy implements FireStrategy {
    public static volatile DefaultFireStrategy INSTANCE;
    private DefaultFireStrategy(){};
    public static DefaultFireStrategy getInstance(){
        if(INSTANCE == null){
            synchronized (DefaultFireStrategy.class){
                if(INSTANCE == null){
                    INSTANCE = new DefaultFireStrategy();
                }
            }
        }
        return INSTANCE;
    }
    @Override
    public void fire(Tank t) {
        int bX = t.x + Tank.WIDTH/2 - Bullet.WIDTH/2;
        int bY = t.y + Tank.HEIGHT/2 - Bullet.HEIGHT/2;

        //BUG new Bullet把自己又加了一遍
        GameModel.getInstance().add(new RectDecorator(new TailDecorator(new Bullet(bX,bY,t.dir,t.group))));
    }
}

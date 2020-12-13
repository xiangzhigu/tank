package com.mashibing.tank;

import com.mashibing.tank.abstractfactory.BaseTank;

public class FourDirFireStrategy implements FireStrategy{

    private FourDirFireStrategy(){}

    public static class FourDirFireStrategyHolder{
        private final static FourDirFireStrategy INSTANCE = new FourDirFireStrategy();
    }
    public static FourDirFireStrategy getInstance(){
        return FourDirFireStrategyHolder.INSTANCE;
    }

    @Override
    public void fire(Tank t) {
        int bX = t.x + Tank.WIDTH/2 - Bullet.WIDTH/2;
        int bY = t.y + Tank.HEIGHT/2 - Bullet.HEIGHT/2;
        Dir[] dirs = Dir.values();
        for (Dir dir: dirs) {
//            new Bullet(bX,bY,dir,t.group,t.tankFrame);
            t.tankFrame.gameFactory.createBullet(bX,bY,dir,t.group,t.tankFrame); //工厂+策略
        }
    }
}

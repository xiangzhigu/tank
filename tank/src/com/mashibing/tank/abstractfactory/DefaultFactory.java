package com.mashibing.tank.abstractfactory;

import com.mashibing.tank.*;

public class DefaultFactory extends GameFactory{
    @Override
    public BaseTank createTank(int x, int y, Dir dir, Group group, TankFrame tankFrame) {
        return new Tank(x,y,dir,group,tankFrame);
    }

    @Override
    public BaseExplode createExplode(int x, int y, TankFrame tankFrame) {
        return new Explode(x,y,tankFrame);
    }

    @Override
    public BaseBullet createBullet(int x, int y, Dir dir, Group group, TankFrame tankFrame) {
        return new Bullet(x,y,dir,group,tankFrame);
    }

}

package com.mashibing.tank.abstractfactory;

import com.mashibing.tank.Dir;
import com.mashibing.tank.Group;
import com.mashibing.tank.TankFrame;

public class RectFactory extends GameFactory{
    @Override
    public BaseTank createTank(int x, int y, Dir dir, Group group, TankFrame tankFrame) {
        return new RectTank(x,y,dir,group,tankFrame);
    }

    @Override
    public BaseExplode createExplode(int x, int y, TankFrame tankFrame) {
        return new RectExplode(x,y,tankFrame);
    }

    @Override
    public BaseBullet createBullet(int x, int y, Dir dir, Group group, TankFrame tankFrame) {
        return new RectBullet(x,y,dir,group,tankFrame);
    }

}

package com.mashibing.tank.abstractfactory;

import com.mashibing.tank.Dir;
import com.mashibing.tank.Group;
import com.mashibing.tank.TankFrame;

public abstract class GameFactory {
    public abstract BaseTank createTank(int x, int y, Dir dir, Group group, TankFrame tankFrame);
    public abstract BaseExplode createExplode(int x, int y, TankFrame tankFrame);
    public abstract BaseBullet createBullet(int x, int y,Dir dir, Group group, TankFrame tankFrame);
}

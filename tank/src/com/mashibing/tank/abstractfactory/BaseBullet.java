package com.mashibing.tank.abstractfactory;

import com.mashibing.tank.Tank;

import java.awt.*;

public abstract class BaseBullet {
    public abstract void collidewith(BaseTank tank);

    public abstract void paint(Graphics g);
}

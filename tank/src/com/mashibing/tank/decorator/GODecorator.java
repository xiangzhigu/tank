package com.mashibing.tank.decorator;

import com.mashibing.tank.GameObject;

import java.awt.*;

public abstract class GODecorator extends GameObject {
    GameObject gameObject;

    public GODecorator(GameObject gameObject) {
        this.x = gameObject.x;
        this.y = gameObject.y;
        this.gameObject = gameObject;
    }

    @Override
    public abstract void  paint(Graphics g);

}

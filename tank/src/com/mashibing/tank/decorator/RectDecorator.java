package com.mashibing.tank.decorator;

import com.mashibing.tank.GameObject;

import java.awt.*;

public class RectDecorator extends GODecorator{
    public RectDecorator(GameObject gameObject) {
        super(gameObject);
    }

    @Override
    public void paint(Graphics g) {
        gameObject.paint(g);

        Color c = g.getColor();
        g.setColor(Color.YELLOW);
        g.drawRect(super.gameObject.x,super.gameObject.y,super.gameObject.getWidth()+2,super.gameObject.getHeight()+2);
        g.setColor(c);
    }

    @Override
    public int getWidth() {
        return super.gameObject.getWidth();
    }

    @Override
    public int getHeight() {
        return super.gameObject.getHeight();
    }
}

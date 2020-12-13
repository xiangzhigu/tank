package com.mashibing.tank.abstractfactory;

import com.mashibing.tank.ResourceMgr;
import com.mashibing.tank.TankFrame;

import java.awt.*;

public class RectExplode extends BaseExplode{
    private int x,y;
    public static int WIDTH = ResourceMgr.explode[0].getWidth();
    public static int HEIGHT = ResourceMgr.explode[0].getHeight();

    TankFrame tankFrame = null;

    private int step = 0;


    public RectExplode(int x, int y, TankFrame tankFrame) {
        this.x = x;
        this.y = y;
        this.tankFrame = tankFrame;

//        new Thread(()->new Audio("audio/explode.wav").play()).start();  //爆炸声
    }


    @Override
    public void paint(Graphics g){
//        g.drawImage(ResourceMgr.explode[step++], x, y, null);
        Color c = g.getColor();
        g.setColor(Color.RED);
        g.fillRect(x,y,10*step,10*step);
        step++;
//        if(step >= ResourceMgr.explode.length)
//            tankFrame.explodes.remove(this);
        if(step >= 5)
            tankFrame.explodes.remove(this);
        g.setColor(c);
    }
}

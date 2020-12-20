package com.mashibing.tank.cor;

import com.mashibing.tank.*;

public class BulletTankCollider implements Collider{
    @Override
    public boolean collide(GameObject o1, GameObject o2) {
        if(o1 instanceof Bullet && o2 instanceof Tank){
           Bullet bullet = (Bullet) o1;
           Tank tank = (Tank) o2;
           //TODO
            if(bullet.getGroup() == tank.getGroup()) return true;
            if(bullet.rectangle.intersects(tank.rectangle)){
                tank.die();
                bullet.die();
                int eX = tank.getX() + Tank.WIDTH/2 - Explode.WIDTH/2;
                int eY = tank.getY() + Tank.HEIGHT/2 - Explode.HEIGHT/2;
                new Explode(eX,eY);
                return false;
            }
        }else if(o1 instanceof Tank && o2 instanceof Bullet) {
            return collide(o2, o1);
        }
            return true;
    }
}

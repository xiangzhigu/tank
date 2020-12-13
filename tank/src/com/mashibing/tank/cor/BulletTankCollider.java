package com.mashibing.tank.cor;

import com.mashibing.tank.Bullet;
import com.mashibing.tank.GameObject;
import com.mashibing.tank.Tank;

public class BulletTankCollider implements Collider{
    @Override
    public boolean collide(GameObject o1, GameObject o2) {
        if(o1 instanceof Bullet && o2 instanceof Tank){
           Bullet bullet = (Bullet) o1;
           Tank tank = (Tank) o2;
           if(bullet.collidewith(tank)){
               return false;
           }
        }else if(o1 instanceof Tank && o2 instanceof Bullet) {
            return collide(o2, o1);
        }
            return true;
    }
}

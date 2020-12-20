package com.mashibing.tank.cor;

import com.mashibing.tank.Bullet;
import com.mashibing.tank.GameObject;
import com.mashibing.tank.Tank;
import com.mashibing.tank.Wall;

public class BulletWallCollider implements Collider{
    @Override
    public boolean collide(GameObject o1, GameObject o2) {
        if(o1 instanceof Bullet && o2 instanceof Wall){
           Bullet bullet = (Bullet) o1;
           Wall wall = (Wall) o2;
           if(bullet.rectangle.intersects(wall.rectangle)){
               bullet.die();
           }
        } else if(o1 instanceof Wall && o2 instanceof Bullet){
            return collide(o2,o1);
        }
        return true;
    }
}

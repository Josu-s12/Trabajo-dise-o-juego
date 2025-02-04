package com.balitechy.spacewar.main;

public class VectorBulletFactory implements BulletFactory {
    @Override
    public Bullet createBullet(int x, int y) {
        return new VectorBullet(x, y);
    }
}

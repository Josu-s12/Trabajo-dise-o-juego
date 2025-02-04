package com.balitechy.spacewar.main;

public class SpriteBulletFactory implements BulletFactory {
    private Game game;

    public SpriteBulletFactory(Game game) {
        this.game = game;
    }

    @Override
    public Bullet createBullet(int x, int y) {
        return new SpriteBullet(x, y, game); // ✅ Ahora pasamos Game como tercer parámetro
    }
}

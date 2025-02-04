package com.balitechy.spacewar.main;

public class VectorGameFactory implements GameFactory {
    private Game game;

    public VectorGameFactory(Game game) {
        this.game = game;
    }

    @Override
    public Player createPlayer() { // ✅ Implementar el método
        return new VectorPlayer((Game.WIDTH * Game.SCALE - Player.WIDTH) / 2, Game.HEIGHT * Game.SCALE - 50, game);
    }

    @Override
    public Bullet createBullet(int x, int y) { // ✅ Implementar el método
        return new VectorBullet(x, y);
    }

    @Override
    public BackgroundRenderer createBackgroundRenderer() { // ✅ Implementar el método
        return new VectorBackgroundRenderer();
    }
}

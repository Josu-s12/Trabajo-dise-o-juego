package com.balitechy.spacewar.main;

public class SpriteGameFactory implements GameFactory {
    private Game game;

    public SpriteGameFactory(Game game) {
        this.game = game;
    }

    @Override
    public Player createPlayer() {
        return new SpritePlayer((Game.WIDTH * Game.SCALE - Player.WIDTH) / 2, Game.HEIGHT * Game.SCALE - 50, game);
    }

    @Override
    public Bullet createBullet(int x, int y) {
        return new SpriteBullet(x, y, game);
    }

    @Override
    public BackgroundRenderer createBackgroundRenderer() {
        return new BitmapBackgroundRenderer(game.getSprites()); // Pasa correctamente la referencia del sprite
    }

}

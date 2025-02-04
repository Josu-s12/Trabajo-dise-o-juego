package com.balitechy.spacewar.main;

public interface GameFactory {
    Player createPlayer();
    Bullet createBullet(int x, int y);
    BackgroundRenderer createBackgroundRenderer();
}

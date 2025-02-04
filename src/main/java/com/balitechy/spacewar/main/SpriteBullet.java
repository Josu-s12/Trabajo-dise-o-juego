package com.balitechy.spacewar.main;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class SpriteBullet extends Bullet {
    private BufferedImage bulletImage;

    public SpriteBullet(int x, int y, Game game) {
        super(x, y);

        // Coordenadas y tamaño del sprite de la bala
        this.bulletImage = game.getSprites().getImage(130, 400, 10, 20); // Ajustar coordenadas según sprites.png
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(bulletImage, x, y, null); // Renderiza la bala
    }
}


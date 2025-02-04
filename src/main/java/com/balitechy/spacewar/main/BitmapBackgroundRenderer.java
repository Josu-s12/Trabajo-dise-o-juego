package com.balitechy.spacewar.main;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class BitmapBackgroundRenderer implements BackgroundRenderer {
    private BufferedImage background;

    public BitmapBackgroundRenderer(SpritesImageLoader bgLoader) {
        // Asegúrate de que las dimensiones no excedan los límites de sprites.png
        int spriteWidth = bgLoader.getFullImage().getWidth();  // Ancho del sprite completo
        int spriteHeight = bgLoader.getFullImage().getHeight(); // Alto del sprite completo

        // Limita las dimensiones a las disponibles en la hoja de sprites
        this.background = bgLoader.getImage(0, 0, Math.min(640, spriteWidth), Math.min(480, spriteHeight));
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(background, 0, 0, Game.WIDTH * Game.SCALE, Game.HEIGHT * Game.SCALE, null);
    }
}

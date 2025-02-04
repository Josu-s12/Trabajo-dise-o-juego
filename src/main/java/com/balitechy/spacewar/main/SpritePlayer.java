package com.balitechy.spacewar.main;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class SpritePlayer extends Player {
    private BufferedImage playerImage;

    public SpritePlayer(double x, double y, Game game) {
        super(x, y, game);

        // Coordenadas y tamaño del sprite del jugador (ajustar si es necesario)
        this.playerImage = game.getSprites().getImage(219, 304, 56, 28);
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(playerImage, (int) x, (int) y, null); // Renderiza el sprite del jugador
    }
}

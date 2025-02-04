package com.balitechy.spacewar.main;

import java.awt.Color;
import java.awt.Graphics;

public class VectorPlayer extends Player { // ✅ Cambiar "implements" por "extends"

    public VectorPlayer(double x, double y, Game game) {
        super(x, y, game);
    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.BLUE); // Color del jugador
        g.fillPolygon(new int[]{(int) x, (int) x + 10, (int) x - 10},
                new int[]{(int) y, (int) y + 20, (int) y + 20}, 3);
    }
}

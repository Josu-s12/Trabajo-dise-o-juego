package com.balitechy.spacewar.main;

import java.awt.Color;
import java.awt.Graphics;

public class VectorBullet extends Bullet { // ✅ Cambiar "implements" por "extends"

    public VectorBullet(int x, int y) {
        super(x, y); // ✅ Llamar al constructor de Bullet
    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.RED);
        g.fillOval(x, y, 10, 10); // Dibuja la bala como un círculo rojo
    }
}

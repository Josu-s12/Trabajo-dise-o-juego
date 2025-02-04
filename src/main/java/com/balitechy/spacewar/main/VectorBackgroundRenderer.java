package com.balitechy.spacewar.main;

import java.awt.Color;
import java.awt.Graphics; // ✅ Asegúrate de importar esto

public class VectorBackgroundRenderer implements BackgroundRenderer {
    @Override
    public void render(Graphics g) {
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, 800, 600);
        g.setColor(Color.GRAY);
        g.drawLine(0, 0, 800, 600);
        g.drawLine(800, 0, 0, 600);
    }
}

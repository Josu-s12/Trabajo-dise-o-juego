package com.balitechy.spacewar.main;

import java.awt.Graphics;

public abstract class Bullet { // ✅ Clase abstracta para las balas
	protected int x, y;
	protected int speed = 5; // Velocidad de la bala

	public Bullet(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public abstract void render(Graphics g);

	// ✅ Agregar método update() para mover la bala
	public void update() {
		y -= speed; // Mueve la bala hacia arriba
	}

	public int getY() {
		return y;
	}
}

package com.balitechy.spacewar.main;

import java.awt.Graphics;
import java.util.LinkedList;

public class BulletController {
	private LinkedList<Bullet> bullets;

	public BulletController() {
		this.bullets = new LinkedList<>();
	}

	public void tick() { // ✅ Agregar método tick()
		for (int i = 0; i < bullets.size(); i++) {
			Bullet bullet = bullets.get(i);
			bullet.update(); // ✅ Llamar al método update() de Bullet
			if (bullet.getY() < 0) {
				bullets.remove(i); // ✅ Corregido para evitar ConcurrentModificationException
				i--; // Ajustar índice después de eliminar
			}
		}
	}

	public void render(Graphics g) {
		for (Bullet bullet : bullets) {
			bullet.render(g);
		}
	}

	public void addBullet(Bullet bullet) {
		bullets.add(bullet);
	}

	public LinkedList<Bullet> getBullets() {
		return bullets;
	}
}

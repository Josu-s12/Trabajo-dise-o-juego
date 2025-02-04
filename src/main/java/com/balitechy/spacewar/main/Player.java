package com.balitechy.spacewar.main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Player {

	protected double x;
	protected double y;

	protected double velX;
	protected double velY;

	public static final int WIDTH = 56;
	public static final int HEIGHT = 28;

	private BufferedImage image;
	private Game game;

	public Player(double x, double y, Game game){
		this.x = x;
		this.y = y;
		this.game = game;

		image = game.getSprites().getImage(219, 304, WIDTH, HEIGHT);
	}

	public void tick(){
		x += velX;
		y += velY;
	}

	public void render(Graphics g){
		g.setColor(Color.white);
		g.drawImage(image, (int) x, (int) y, null);
	}

	public void setVelX(double velX) {
		this.velX = velX;
	}

	public void setVelY(double velY) {
		this.velY = velY;
	}

	// ✅ Agregar método shoot()
	public void shoot(){
		Bullet b = game.getBulletFactory().createBullet((int) (x + (WIDTH / 2) - 5), (int) (y - 18));
		game.getBullets().addBullet(b);
	}
}

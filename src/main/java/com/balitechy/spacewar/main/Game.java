package com.balitechy.spacewar.main;

import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import javax.swing.JFrame;

public class Game extends Canvas implements Runnable {
	private static final long serialVersionUID = 1L;
	public static final int WIDTH = 320;
	public static final int HEIGHT = WIDTH / 12 * 9;
	public static final int SCALE = 2;
	public final String TITLE = "Space War 2D";

	private boolean running = false;
	private Thread thread;
	private BufferedImage image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);

	private SpritesImageLoader sprites;
	private GameFactory gameFactory;
	private BulletFactory bulletFactory;

	// Componentes del juego
	private Player player;
	private BulletController bullets;
	private BackgroundRenderer backgRenderer;

	public void init() {
		requestFocus();
		sprites = new SpritesImageLoader("/sprites.png");
		gameFactory = new SpriteGameFactory(this); // ✅ Inicializar correctamente la fábrica
		bulletFactory = new SpriteBulletFactory(this);

		addKeyListener(new InputHandler(this));

		player = gameFactory.createPlayer(); // ✅ Ahora el jugador se crea desde la fábrica
		bullets = new BulletController();
		backgRenderer = gameFactory.createBackgroundRenderer();
	}

	public SpritesImageLoader getSprites() {
		return sprites;
	}

	public BulletController getBullets() {
		return bullets;
	}

	public BulletFactory getBulletFactory() {
		return bulletFactory;
	}

	public void handleKeyPressed(KeyEvent e) {
		int key = e.getKeyCode();

		switch (key) {
			case KeyEvent.VK_RIGHT:
				player.setVelX(5);
				break;
			case KeyEvent.VK_LEFT:
				player.setVelX(-5);
				break;
			case KeyEvent.VK_UP:
				player.setVelY(-5);
				break;
			case KeyEvent.VK_DOWN:
				player.setVelY(5);
				break;
			case KeyEvent.VK_SPACE:
				player.shoot();
				break;
		}
	}

	public void handleKeyReleased(KeyEvent e) {
		int key = e.getKeyCode();

		switch (key) {
			case KeyEvent.VK_RIGHT:
			case KeyEvent.VK_LEFT:
				player.setVelX(0);
				break;
			case KeyEvent.VK_UP:
			case KeyEvent.VK_DOWN:
				player.setVelY(0);
				break;
		}
	}

	private synchronized void start() {
		if (running) return;
		running = true;
		thread = new Thread(this);
		thread.start();
	}

	private synchronized void stop() {
		if (!running) return;
		running = false;
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.exit(1);
	}

	@Override
	public void run() {
		init();
		long lastTime = System.nanoTime();
		final double numOfTicks = 60.0;
		double ns = 1000000000 / numOfTicks;
		double delta = 0;
		int updates = 0;
		int frames = 0;
		long timer = System.currentTimeMillis();

		while (running) {
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;
			if (delta >= 1) {
				tick();
				updates++;
				delta--;
			}
			render();
			frames++;

			if (System.currentTimeMillis() - timer > 1000) {
				timer += 1000;
				System.out.println(updates + " ticks, fps " + frames);
				updates = 0;
				frames = 0;
			}
		}
		stop();
	}

	public void tick() {
		player.tick();
		bullets.tick();
	}

	public void render() {
		BufferStrategy bs = this.getBufferStrategy();
		if (bs == null) {
			createBufferStrategy(3); // Triple buffering para evitar parpadeos
			return;
		}

		Graphics g = bs.getDrawGraphics();

		try {
			backgRenderer.render(g); // Renderizar el fondo primero
			player.render(g);        // Renderizar el jugador
			bullets.render(g);       // Renderizar las balas
		} catch (Exception e) {
			e.printStackTrace();
		}

		g.dispose();
		bs.show(); // Mostrar el buffer en pantalla
	}



	public static void main(String args[]) {
		Game game = new Game();
		game.setPreferredSize(new Dimension(WIDTH * SCALE, HEIGHT * SCALE));
		game.setMaximumSize(new Dimension(WIDTH * SCALE, HEIGHT * SCALE));
		game.setMinimumSize(new Dimension(WIDTH * SCALE, HEIGHT * SCALE));

		JFrame frame = new JFrame(game.TITLE);
		frame.add(game);
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);

		game.start();
	}
}


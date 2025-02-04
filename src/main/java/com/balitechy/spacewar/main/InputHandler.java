package com.balitechy.spacewar.main;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class InputHandler extends KeyAdapter {
	private Game game;

	public InputHandler(Game game) {
		this.game = game;
	}

	@Override
	public void keyPressed(KeyEvent e) {
		game.handleKeyPressed(e); // ✅ Ahora este método existe en Game
	}

	@Override
	public void keyReleased(KeyEvent e) {
		game.handleKeyReleased(e); // ✅ También debe existir en Game
	}
}

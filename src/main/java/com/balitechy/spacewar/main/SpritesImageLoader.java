package com.balitechy.spacewar.main;

import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.IOException;

public class SpritesImageLoader {
	private BufferedImage spriteSheet;

	public SpritesImageLoader(String path) {
		try {
			spriteSheet = ImageIO.read(getClass().getResource(path));
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(1);
		}
	}

	// Método para recortar imágenes desde la hoja de sprites
	public BufferedImage getImage(int x, int y, int width, int height) {
		// Validar si las coordenadas están dentro del tamaño de la hoja de sprites
		if (x + width > spriteSheet.getWidth() || y + height > spriteSheet.getHeight()) {
			throw new IllegalArgumentException(
					"Las coordenadas y dimensiones exceden el tamaño de la hoja de sprites: " +
							"x=" + x + ", y=" + y + ", width=" + width + ", height=" + height +
							", spriteSheetWidth=" + spriteSheet.getWidth() +
							", spriteSheetHeight=" + spriteSheet.getHeight()
			);
		}
		return spriteSheet.getSubimage(x, y, width, height);
	}

	// Método para obtener toda la hoja de sprites
	public BufferedImage getFullImage() {
		return spriteSheet;
	}
}

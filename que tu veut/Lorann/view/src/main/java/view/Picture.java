package view;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.imageio.ImageIO;

// TODO: Auto-generated Javadoc
/**
 * The Class Picture.
 */
public class Picture {
	
	/** The cache. */
	private static Map<String, BufferedImage> cache = new HashMap<String, BufferedImage>();

	/**
	 * Draw.
	 *
	 * @param g the g
	 * @param filepath the filepath
	 * @param x the x
	 * @param y the y
	 */
	public static void draw(final Graphics g, final String filepath, final int x, final int y) {
		try {
			BufferedImage img;
			if (cache.containsKey(filepath)) {
				img = cache.get(filepath);
			} else {
				img = ImageIO.read(new File(filepath));
				cache.put(filepath, img);
			}
			g.drawImage(img, x, y, null);
		} catch (final IOException e) {
			System.err.println(e.getMessage());
		}
	}
}

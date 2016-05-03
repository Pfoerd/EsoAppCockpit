package de.fs.esoapp.cockpit.ui;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class BackgroundPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private BufferedImage image;

	public BackgroundPanel() {
		super(null);
		try {
			image = ImageIO.read(BackgroundPanel.class
					.getResourceAsStream("Background.png"));
		} catch (IOException e) {
			assert (true);
		}
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(image, 0, 0, null);
	}
}

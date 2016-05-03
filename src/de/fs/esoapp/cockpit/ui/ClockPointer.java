package de.fs.esoapp.cockpit.ui;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import de.fs.esoapp.cockpit.ui.animation.Animated;
import de.fs.esoapp.cockpit.ui.animation.ClockPointerAnimation;

public class ClockPointer extends Animated<ClockPointerAnimation> {

	private static final long serialVersionUID = 1L;
	private BufferedImage image;
	private double rotationRequired;

	public ClockPointer(ClockPointerAnimation animation, int x, int y) {
		super(animation);
		try {
			image = ImageIO.read(BackgroundPanel.class
					.getResourceAsStream("Pointer.png"));
		} catch (IOException e) {
			assert (true);
		}
		this.setBounds(x, y, 255, 255);
		this.setOpaque(false);
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;
		double locationX = -image.getWidth() / 2 + getSize().width / 2;
		double locationY = getSize().height / 2;

		AffineTransform tx = new AffineTransform();
		tx.translate(locationX, locationY);
		tx.rotate(rotationRequired, image.getWidth() / 2, image.getWidth() / 2);
		g2d.drawImage(image, tx, null);
	}

	@Override
	protected void animate(ClockPointerAnimation animation) {
		rotationRequired = Math.toRadians(animation.getRotation());
	}
}

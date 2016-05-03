package de.fs.esoapp.cockpit.ui;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import de.fs.esoapp.cockpit.ui.animation.Animated;

public class ClockPointer extends JPanel implements Animated {

	private static final long serialVersionUID = 1L;
	private BufferedImage image;
	private int frequency;
	private double targetRotation = 0;
	private Queue<Double> rotations = new LinkedList<>();

	public ClockPointer(AnimationHandler animationHander, int x, int y) {
		super(null);
		frequency = animationHander.getFrequency();
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
		double rotation = Math
				.toRadians(rotations.poll() == null ? targetRotation
						: rotations.poll());
		tx.rotate(rotation, image.getWidth() / 2, image.getWidth() / 2);
		g2d.drawImage(image, tx, null);
	}

	public void setRotation(double rotation) {
		Double currentRotation = rotations.poll() == null ? targetRotation
				: rotations.poll();
		rotations.clear();
		targetRotation = rotation;
		for (int i = 0; i < frequency; i++) {
			rotations.add(((targetRotation - currentRotation) / frequency) * i
					+ currentRotation);
		}
	}

	@Override
	public void animate() {
		this.repaint();
	}
}

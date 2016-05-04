package de.fs.esoapp.cockpit.ui;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
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
	private ClockPointerRotationProvider dataProvider;
	private int startRotation;

	public ClockPointer(ClockPointerRotationProvider dataProvider,
			AnimationHandler animationHander, int x, int y, int startRotation) {
		super(null);
		this.dataProvider = dataProvider;
		this.startRotation = startRotation;
		frequency = animationHander.getFrequency();
		try {
			image = ImageIO.read(BackgroundPanel.class
					.getResourceAsStream("Pointer.png"));
		} catch (IOException e) {
			assert (true);
		}
		this.setBounds(x, y, 335, 335);
		this.setOpaque(false);
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;
		double locationX = -image.getWidth() / 2 + getSize().width / 2;
		double locationY = getSize().height / 2;

		AffineTransform tx = new AffineTransform();
		tx.translate(locationX, locationY + 104);
		updateRotation();
		double rotation = +Math
				.toRadians(startRotation
						+ (rotations.poll() == null ? targetRotation
								: rotations.poll()));
		tx.rotate(rotation, image.getWidth() / 2, image.getWidth() / 2 - 104);
		RenderingHints rh = new RenderingHints(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_DEFAULT);
		g2d.setRenderingHints(rh);
		g2d.drawImage(image, tx, null);
	}

	private void updateRotation() {
		double rotation = dataProvider.getRotation();
		if (rotation != targetRotation) {
			Double currentRotation = rotations.poll() == null ? targetRotation
					: rotations.poll();
			rotations.clear();
			targetRotation = rotation;
			for (int i = 0; i < frequency; i++) {
				rotations.add(((targetRotation - currentRotation) / frequency)
						* i + currentRotation);
			}
		}
	}

	@Override
	public void animate() {
		this.repaint();
	}
}

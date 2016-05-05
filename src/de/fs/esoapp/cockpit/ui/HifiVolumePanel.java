package de.fs.esoapp.cockpit.ui;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import de.fs.esoapp.cockpit.ui.animation.Animated;

public class HifiVolumePanel extends JPanel implements Animated {

	private static final long serialVersionUID = 1L;

	private BufferedImage[] images = new BufferedImage[5];
	private DiscreteValueProvider dataProvider;
	private Queue<Float> fadeIn = new LinkedList<>(Arrays.asList(0.2f, 0.4f,
			0.6f, 0.8f));
	private Queue<Float> fadeOut = new LinkedList<>(Arrays.asList(0.2f, 0.4f,
			0.6f, 0.8f));
	private int counter;
	private int frequency;
	private int currentVolume;

	public HifiVolumePanel(AnimationHandler animationHandler,
			DiscreteValueProvider dataProvider) {
		super(null);
		this.dataProvider = dataProvider;
		frequency = animationHandler.getFrequency();
		counter = 0;
		currentVolume = 0;
		try {
			images[0] = ImageIO.read(HifiVolumePanel.class
					.getResourceAsStream("Volume0.png"));
			images[1] = ImageIO.read(HifiVolumePanel.class
					.getResourceAsStream("Volume1.png"));
			images[2] = ImageIO.read(HifiVolumePanel.class
					.getResourceAsStream("Volume2.png"));
			images[3] = ImageIO.read(HifiVolumePanel.class
					.getResourceAsStream("Volume3.png"));
			images[4] = ImageIO.read(HifiVolumePanel.class
					.getResourceAsStream("Volume4.png"));
		} catch (IOException e) {
			assert (true);
		}
		this.setBounds(420, 120, 180, 120);
		this.setOpaque(false);
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;

		int newVolume = dataProvider.getDiscreteValue();

		if (currentVolume != newVolume) {
			counter = frequency * 2; // show for 3 seconds
			currentVolume = newVolume;
		} else {
			if (counter > 0) {
				counter--;
			}
		}

		if (counter > 0) {
			g2d.drawImage(images[newVolume], 0, 0, null);
		}
	}

	@Override
	public void animate() {
		this.repaint();
	}
}

package de.fs.esoapp.cockpit.ui;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class GearIndicatorPanel extends JPanel {

	private static final long serialVersionUID = 1L;

	private BufferedImage[] images = new BufferedImage[10];

	private DiscreteValueProvider dataProvider;

	public GearIndicatorPanel(DiscreteValueProvider dataProvider) {
		super(null);
		this.dataProvider = dataProvider;
		try {
			images[0] = ImageIO.read(GearIndicatorPanel.class
					.getResourceAsStream("GearN.png"));
			images[1] = ImageIO.read(GearIndicatorPanel.class
					.getResourceAsStream("Gear1.png"));
			images[2] = ImageIO.read(GearIndicatorPanel.class
					.getResourceAsStream("Gear2.png"));
			images[3] = ImageIO.read(GearIndicatorPanel.class
					.getResourceAsStream("Gear3.png"));
			images[4] = ImageIO.read(GearIndicatorPanel.class
					.getResourceAsStream("Gear4.png"));
			images[5] = ImageIO.read(GearIndicatorPanel.class
					.getResourceAsStream("Gear5.png"));
			images[6] = ImageIO.read(GearIndicatorPanel.class
					.getResourceAsStream("Gear6.png"));
			images[7] = ImageIO.read(GearIndicatorPanel.class
					.getResourceAsStream("Gear7.png"));
			images[8] = ImageIO.read(GearIndicatorPanel.class
					.getResourceAsStream("Gear8.png"));
			images[9] = ImageIO.read(GearIndicatorPanel.class
					.getResourceAsStream("Gear9.png"));
		} catch (IOException e) {
			assert (true);
		}
		this.setBounds(155, 155, 50, 60);
		this.setOpaque(false);
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(images[dataProvider.getDiscreteValue()], 0, 0, null);
	}
}

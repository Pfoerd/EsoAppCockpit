package de.fs.esoapp.cockpit.ui;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import de.fs.esoapp.cockpit.ui.animation.AnimationLoop;
import de.fs.esoapp.cockpit.ui.animation.ClockPointerAnimation;

public class VirtualCockpitView extends JFrame implements CarModelListener {

	private static final long serialVersionUID = 1L;

	private VirtualCockpitController controller;
	private CarModel model;

	public VirtualCockpitView(VirtualCockpitController controller,
			CarModel model) {
		super("ferdis e.solutions application cockpit");

		initLAF();

		this.controller = controller;
		this.model = model;

		BackgroundPanel bgPanel = new BackgroundPanel();

		ClockPointer clockPointerSpeed = new ClockPointer(
				new ClockPointerAnimation() {
					int i = 0;

					@Override
					public double getRotation() {
						return i++;
					}
				}, 70, 98);
		bgPanel.add(clockPointerSpeed);

		ClockPointer clockPointerTorque = new ClockPointer(
				new ClockPointerAnimation() {
					int i = 0;

					@Override
					public double getRotation() {
						return i++;
					}
				}, 480, 98);
		bgPanel.add(clockPointerTorque);

		this.getContentPane().add(bgPanel);
		this.pack();
		this.setSize(new Dimension(819, 460));
		this.setLocation(100, 100);
		this.setPreferredSize(new Dimension(819, 460));
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);

		AnimationLoop animationLoop = new AnimationLoop();
		animationLoop.add(clockPointerSpeed);
		animationLoop.add(clockPointerTorque);
		animationLoop.start();
	}

	private void initLAF() {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}

		SwingUtilities.updateComponentTreeUI(this);
	}
}

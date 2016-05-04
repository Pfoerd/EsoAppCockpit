package de.fs.esoapp.cockpit.ui;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import de.fs.esoapp.cockpit.ui.animation.AnimationLoop;

public class VirtualCockpitView extends JFrame implements CarModelListener {

	private static final long serialVersionUID = 1L;

	private VirtualCockpitController controller;
	private CarModel model;

	private ClockPointer clockPointerSpeed;

	private ClockPointer clockPointerTorque;

	public VirtualCockpitView(VirtualCockpitController controller,
			CarModel model) {
		super("ferdis e.solutions application cockpit");

		initLAF();

		this.controller = controller;
		this.model = model;

		BackgroundPanel bgPanel = new BackgroundPanel();

		AnimationLoop animationLoop = new AnimationLoop();

		clockPointerSpeed = new ClockPointer(animationLoop, 11, 14);
		bgPanel.add(clockPointerSpeed);

		clockPointerTorque = new ClockPointer(animationLoop, 660, 14);
		bgPanel.add(clockPointerTorque);

		this.getContentPane().add(bgPanel);
		this.pack();
		this.setSize(new Dimension(1005, 420));
		this.setLocation(100, 100);
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);

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

	public void setRotation(double rotation) {
		clockPointerSpeed.setRotation(rotation);
		clockPointerTorque.setRotation(rotation);
	}
}

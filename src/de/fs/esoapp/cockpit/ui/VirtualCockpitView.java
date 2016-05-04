package de.fs.esoapp.cockpit.ui;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import de.fs.esoapp.cockpit.model.CarModel;
import de.fs.esoapp.cockpit.model.CarModelListener;
import de.fs.esoapp.cockpit.ui.animation.AnimationLoop;

public class VirtualCockpitView extends JFrame implements CarModelListener {

	private class RotationProvider implements ClockPointerRotationProvider {

		private double rotation;

		@Override
		public double getRotation() {
			return rotation;
		}

		synchronized public void setRotation(double rotation) {
			this.rotation = rotation;
		}
	}

	private static final long serialVersionUID = 1L;

	private VirtualCockpitController controller;
	private CarModel model;

	private RotationProvider speedRotationProvider;
	private RotationProvider torqueRotationProvider;
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

		speedRotationProvider = new RotationProvider();
		clockPointerSpeed = new ClockPointer(speedRotationProvider,
				animationLoop, 660, 14, 41);
		bgPanel.add(clockPointerSpeed);

		torqueRotationProvider = new RotationProvider();
		clockPointerTorque = new ClockPointer(torqueRotationProvider,
				animationLoop, 11, 14, 54);
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

	@Override
	public void onEngineSpeedChanged(double engineSpeed) {
		torqueRotationProvider.setRotation(engineSpeed/30);
	}

	@Override
	public void onCarSpeedChanged(double kmh) {
		speedRotationProvider.setRotation(kmh);
	}
}

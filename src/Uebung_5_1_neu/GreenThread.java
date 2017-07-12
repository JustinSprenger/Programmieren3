package Uebung_5_1_neu;

import javax.swing.plaf.synth.SynthSpinnerUI;

import javafx.scene.paint.Color;

public class GreenThread implements Runnable {
	private boolean g, r, y, ry;
	TrafficLight traffic;

	GreenThread(TrafficLight a) {
		this.traffic = a;
	}

	@Override
	public void run() {
		synchronized (traffic) {
			if (traffic.getGreen().getFill()==Color.GREEN) {

			} else {
				synchronized (this) {
					//traffic.yellow.setFill(Color.YELLOW);	
					traffic.setYellow(true);
					//System.out.println("set yellow");
	
				}
				try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				synchronized (traffic.getRed()) {
					traffic.setRed(false);
				}
				synchronized (traffic.getYellow()) {
					traffic.setYellow(false);
				}
				synchronized (traffic.getGreen()) {
					traffic.setGreen(true);
				}
			}
		}
	}
}

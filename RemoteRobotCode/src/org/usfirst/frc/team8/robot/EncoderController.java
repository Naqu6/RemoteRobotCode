package org.usfirst.frc.team8.robot;

import edu.wpi.first.wpilibj.networktables.NetworkTable;

import java.util.HashMap;

import edu.wpi.first.wpilibj.Encoder;


public class EncoderController implements SensorController {
	private NetworkTable EncoderTable = NetworkTable.getTable(CONSTANTS.ENCODER_TABLE_NAME);
	private HashMap<Integer, Encoder> encoders = new HashMap<Integer, Encoder>();

	private void updateValues() {
		for (int i = CONSTANTS.ENCODER_LOW_PORT_BOUNDS; i<CONSTANTS.ENCODER_HIGH_PORT_BOUNDS; i++) {
			int difference = (int) EncoderTable.getNumber(String.valueOf(i), CONSTANTS.ARBITRARY_NUMBER);
			if (difference != CONSTANTS.ARBITRARY_NUMBER) {
				int portA = i - difference;
				if (!encoders.containsKey(i)) {
					encoders.put(portA, new Encoder(portA, i));
					encoders.get(portA).reset();
				}
				EncoderTable.putNumber(String.valueOf(portA), encoders.get(portA).getDistance());
			}
		}
	}
	
	private void zero() {
		for (Integer port : encoders.keySet()) {
			if (EncoderTable.getBoolean(String.valueOf(port), false)) {
				encoders.get(port).reset();
				EncoderTable.putBoolean(String.valueOf(port), false);
			}
		}
	}
	
	@Override
	public void update() {
		zero();
		updateValues();
	}

}

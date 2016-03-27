package org.usfirst.frc.team8.robot;

import java.util.HashMap;

import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.TalonSRX;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.networktables.NetworkTable;

public class MotorController {
	private HashMap<Integer, Talon> talonValues = new HashMap<Integer, Talon>();
	private HashMap<Integer, TalonSRX> talonSRXValues = new HashMap<Integer, TalonSRX>();
	private HashMap<Integer, Victor> victorValues = new HashMap<Integer, Victor>();

	
	private NetworkTable talonTable = NetworkTable.getTable(CONSTANTS.TALON_TABLE_NAME);
	private NetworkTable talonSRXTable = NetworkTable.getTable(CONSTANTS.TALONSRX_TABLE_NAME);
	private NetworkTable victorTable = NetworkTable.getTable(CONSTANTS.VICTOR_TABLE_NAME);
	
	
	
	public void update() {
		updateTalons();
		updateTalonSRXs();
		updateVictors();
	}
	
	private void updateTalons() {
		for (int i = CONSTANTS.MOTOR_LOW_PORT_BOUNDS; !(i>CONSTANTS.MOTOR_HIGH_PORT_BOUNDS);  i++) {
			double speed = talonTable.getNumber(String.valueOf(i), CONSTANTS.ARBITRARY_NUMBER);
			if (speed != CONSTANTS.ARBITRARY_NUMBER) {
				if (!talonValues.containsKey(i)) {
					talonValues.put(i, new Talon(i));
				}
				talonValues.get(i).set(speed);
			}
		}
	}
	
	private void updateTalonSRXs() {
		for (int i = CONSTANTS.MOTOR_LOW_PORT_BOUNDS; !(i>CONSTANTS.MOTOR_HIGH_PORT_BOUNDS);  i++) {
			double speed = talonSRXTable.getNumber(String.valueOf(i), CONSTANTS.ARBITRARY_NUMBER);
			if (speed != CONSTANTS.ARBITRARY_NUMBER) {
				if (!talonSRXValues.containsKey(i)) {
					talonSRXValues.put(i, new TalonSRX(i));
				}
				talonSRXValues.get(i).set(speed);
			}
		}
	}
	
	private void updateVictors() {
		for (int i = CONSTANTS.MOTOR_LOW_PORT_BOUNDS; !(i>CONSTANTS.MOTOR_HIGH_PORT_BOUNDS);  i++) {
			double speed = victorTable.getNumber(String.valueOf(i), CONSTANTS.ARBITRARY_NUMBER);
			if (speed != CONSTANTS.ARBITRARY_NUMBER) {
				if (!victorValues.containsKey(i)) {
					victorValues.put(i, new Victor(i));
				}
				victorValues.get(i).set(speed);
			}
		}
	}
	
}

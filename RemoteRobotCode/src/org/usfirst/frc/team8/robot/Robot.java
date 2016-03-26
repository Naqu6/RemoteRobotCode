
package org.usfirst.frc.team8.robot;

import edu.wpi.first.wpilibj.networktables.*;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.TalonSRX;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;


public class Robot extends IterativeRobot {
	
	private TalonSRX leftDrive1 = new TalonSRX(0);
	private TalonSRX leftDrive2 = new TalonSRX(0);
	private TalonSRX rightDrive1 = new TalonSRX(0);
	private TalonSRX rightDrive2 = new TalonSRX(0);

	private NetworkTable hardware = NetworkTable.getTable("Hardware");

	
    public void robotInit() {
    	
    }
  
    public void autonomousInit() {

    }

  
    public void autonomousPeriodic() {
    }
    
    public void teleopInit() {
    	
    }


    public void teleopPeriodic() {
        leftDrive1.set(hardware.getNumber("left1", 0));
        leftDrive2.set(hardware.getNumber("left2", 0));
        
        rightDrive1.set(hardware.getNumber("right1", 0));
        rightDrive2.set(hardware.getNumber("right2", 0));
    }
    

    public void testPeriodic() {
    
    }
    
}

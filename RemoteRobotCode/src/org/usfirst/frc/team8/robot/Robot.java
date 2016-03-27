
package org.usfirst.frc.team8.robot;

import edu.wpi.first.wpilibj.networktables.*;


import edu.wpi.first.wpilibj.IterativeRobot;


public class Robot extends IterativeRobot {
	
	private MotorController motors;
	
	
    public void robotInit() {
    	this.motors = new MotorController();
    }
  
    public void autonomousInit() {
    	motors.update();
    }

  
    public void autonomousPeriodic() {
    	motors.update();
    }
    
    public void teleopInit() {
    	motors.update();
    }


    public void teleopPeriodic() {
    	motors.update();
    }
    

    public void testPeriodic() {
    	motors.update();
    }
    
}

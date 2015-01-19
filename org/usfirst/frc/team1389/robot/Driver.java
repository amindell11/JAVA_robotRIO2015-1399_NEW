package org.usfirst.frc.team1389.robot;
import edu.wpi.first.wpilibj.*;

public class Driver implements phaseMethods{

	
	static Talon leftDrive = Motors_Sensors.leftDrive;
	static Talon rightDrive = Motors_Sensors.rightDrive;
	static Joystick driver = Motors_Sensors.drive;
	
	/**
	 * Drive train Teleoperated setup
	 */
	public void teleopConfig(){}
	
	/**
	 * Teleoperated control for the drive train
	 */
	public void teleopTick()
	{
		float x = (float) driver.getRawAxis(Constants.LeftX);
		float y = (float) driver.getRawAxis(Constants.LeftY);
		leftDrive.set((x + y) / Constants.LIMITER);
		rightDrive.set((x - y) / Constants.LIMITER);
	}
	
	/**
	 * Drive train Autonomous setup
	 */
	public void autonConfig(){}
	
	/**
	 * Instructions for drive train at each autonomous tick. 
	 */
	public void autonTick(){}

	public void test() {}
	
}

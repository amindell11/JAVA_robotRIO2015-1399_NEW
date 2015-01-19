package org.usfirst.frc.team1389.robot;
import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Driver implements phaseMethods{

	
	static Talon leftDrive = Motors_Sensors.leftDrive;
	static Talon rightDrive = Motors_Sensors.rightDrive;
	static Joystick driver = Motors_Sensors.drive;
	static DigitalInput limitOne = Motors_Sensors.limitOne;
	static DigitalInput limitTwo = Motors_Sensors.limitTwo;
	
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
		SmartDashboard.putNumber("Driver LeftX", x);
		SmartDashboard.putNumber("Driver LeftY", y);
		x += selfTurn();
		leftDrive.set((y - x) / Constants.LIMITER);
		rightDrive.set((y - x) / Constants.LIMITER);
	}
	
	public float selfTurn()
	{
		if (limitOne.get() ^ limitTwo.get())
		{
			if (limitOne.get())
				return (float) -.5;
			if (limitTwo.get())
				return (float) .5;
		}
		return 0;
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

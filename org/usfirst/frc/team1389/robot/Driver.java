package org.usfirst.frc.team1389.robot;
import edu.wpi.first.wpilibj.*;

public class Driver {

	
	static Talon leftDrive = Motors_Sensors.leftDrive;
	static Talon rightDrive = Motors_Sensors.rightDrive;
	static Joystick driver = Motors_Sensors.drive;
	public void tick()
	{
		float x = (float) driver.getRawAxis(Constants.LeftX);
		float y = (float) driver.getRawAxis(Constants.LeftY);
		leftDrive.set((x + y) / Constants.LIMITER);
		rightDrive.set((x - y) / Constants.LIMITER);
	}
	
}

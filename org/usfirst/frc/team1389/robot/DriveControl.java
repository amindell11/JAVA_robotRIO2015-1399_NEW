package org.usfirst.frc.team1389.robot;
import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class DriveControl extends Component{

	
	static Talon RFDrive = Motors_Sensors.RFDrive;
	static Talon RBDrive = Motors_Sensors.RBDrive;
	static Talon LFDrive = Motors_Sensors.LFDrive;
	static Talon LBDrive = Motors_Sensors.LBDrive;
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
		float y = (float) driver.getRawAxis(Constants.LeftY) * -1;
		SmartDashboard.putNumber("Driver LeftX", x);
		SmartDashboard.putNumber("Driver LeftY", y);
		
		SmartDashboard.putNumber("Left Power", (y + x) / Constants.LIMITER);
		SmartDashboard.putNumber("Right Power", (y - x) / Constants.LIMITER);
		
		x += selfTurn();
		LFDrive.set((y + x) / Constants.LIMITER);
		LBDrive.set((y + x) / Constants.LIMITER);
		RFDrive.set((y - x) / Constants.LIMITER);
		RBDrive.set((y - x) / Constants.LIMITER);
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
	public void test(){
		
	}
}

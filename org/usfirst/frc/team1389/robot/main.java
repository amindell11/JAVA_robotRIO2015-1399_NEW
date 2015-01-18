package org.usfirst.frc.team1389.robot;

import edu.wpi.first.wpilibj.SampleRobot;


public class main extends SampleRobot {
	
	Driver fourCIMDrive;
	
	public main()
	{
		Motors_Sensors.initMotors();
		fourCIMDrive = new Driver();
	}
	
	public void operatorControl()
	{
		fourCIMDrive.tick();
	}
	
	public void autonomous() {
	
	}
}

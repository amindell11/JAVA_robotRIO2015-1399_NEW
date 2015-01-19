package org.usfirst.frc.team1389.robot;

import edu.wpi.first.wpilibj.SampleRobot;

/**
 * robotRIO code 2015 for FRC team 1389 now in Java!
 * This year we are attempting to organize the code through the object oriented capabilities java has. The code is organized as follows:
 * All constants (i.e port numbers and joystick input values) are final members of the Constants class.
 * All static Object used (Motor controllers, sensors, joysticks, etc.) are declared/initialized by the Motors_Sensors object
 * All individual robot components (i.e. drive train, lift system, etc.) are separate objects.
 * For both the autonomous and teleoperated phases of the match, the each component as a config method and tick method.
 * Config is called at the beginning of the phase, which tick is called every tick during the phase. 
 * @author Paul LoBuglio
 */

public class main extends SampleRobot {
	
	Driver fourCIMDrive;
	Elevator lift;
	/**
	 * Instantiates all static motors and sensors. 
	 * Instantiates all component objects
	 */
	public main()
	{
		Motors_Sensors.init();
		fourCIMDrive = new Driver();
		lift = new Elevator();
	}
	
	
	/**
	 * Teleoperated configuration
	 * Update each component each iteration through the ".teleopTick()" method
	 */
	public void operatorControl()
	{
		fourCIMDrive.teleopConfig();
		lift.teleopConfig();
		while (isOperatorControl())
		{
		fourCIMDrive.teleopTick();
		lift.teleopTick();
		}
	}
	
	/**
	 * Autonomous configuration
	 * Update each component through the ".autonTick()" method
	 */
	public void autonomous() {
		fourCIMDrive.autonConfig();
		lift.autonConfig();
		while (isAutonomous())
		{
			fourCIMDrive.autonConfig();
			lift.autonConfig();
		}
	
	}
}
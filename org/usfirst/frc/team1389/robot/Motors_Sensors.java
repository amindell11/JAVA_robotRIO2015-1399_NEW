package org.usfirst.frc.team1389.robot;
import edu.wpi.first.wpilibj.*;

public class Motors_Sensors {
	static Joystick drive;
	static Joystick manip;
	static Talon rightDrive;
	static Talon leftDrive;
	static Victor elevatorOne;

	public static void initMotors(){
		rightDrive = new Talon(Constants.RIGHT_PWM_DRIVE);
		leftDrive = new Talon(Constants.LEFT_PWM_DRIVE);
		elevatorOne = new Victor(Constants.ELEVATOR_PWM);

		drive = new Joystick(Constants.DRIVE_JOY);
		manip = new Joystick(Constants.MANIP_JOY);
	}
}

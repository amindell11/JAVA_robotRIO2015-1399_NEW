package org.usfirst.frc.team1389.robot;
import edu.wpi.first.wpilibj.*;

public class Motors_Sensors {
	static Joystick drive, manip;
	static Talon rightDrive, leftDrive;
	static Victor elevatorOne;
	static DigitalInput IRa, IRb, IRc, IRd, IRe;

	/**
	 * Initialize all static components
	 */
	public static void init(){
		rightDrive = new Talon(Constants.RIGHT_PWM_DRIVE);
		leftDrive = new Talon(Constants.LEFT_PWM_DRIVE);
		elevatorOne = new Victor(Constants.ELEVATOR_PWM);

		drive = new Joystick(Constants.DRIVE_JOY);
		manip = new Joystick(Constants.MANIP_JOY);
		
		IRa = new DigitalInput(Constants.INFRARED_ONE);
		IRb = new DigitalInput(Constants.INFRARED_TWO);
		IRc = new DigitalInput(Constants.INFRARED_THREE);
		IRd = new DigitalInput(Constants.INFRARED_FOUR);
		IRe = new DigitalInput(Constants.INFRARED_FIVE);
	}
}

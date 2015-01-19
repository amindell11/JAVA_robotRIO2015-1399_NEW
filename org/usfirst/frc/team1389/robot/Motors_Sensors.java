package org.usfirst.frc.team1389.robot;
import edu.wpi.first.wpilibj.*;

public class Motors_Sensors {
	static Joystick drive, manip;
	static Talon rightDrive, leftDrive;
	static Victor elevatorOne;
	static DigitalInput IRa, IRb, IRc, IRd, IRe, limitOne, limitTwo;
	static Encoder encodeOne, encodeTwo;

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
		
		limitOne = new DigitalInput(Constants.LIMIT_ONE);
		limitTwo = new DigitalInput(Constants.LIMIT_TWO);
		
		encodeOne = new Encoder(Constants.ENCODER_ONE / 10, Constants.ENCODER_ONE - Constants.ENCODER_TWO / 10 * 10);
		encodeTwo = new Encoder(Constants.ENCODER_TWO / 10, Constants.ENCODER_TWO - Constants.ENCODER_TWO / 10 * 10);
	
	}
}

package org.usfirst.frc.team1389.robot;
import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.hal.AccelerometerJNI;

public class Motors_Sensors {
	static Joystick drive, manip;
	static Talon RFDrive, RBDrive, LFDrive, LBDrive;
	static Victor elevatorOne;
	static DigitalInput IRa, IRb, IRc, IRd, IRe, limitOne, limitTwo;
	static Encoder encodeOne, encodeTwo;
	static Gyro gyro;
	static AnalogAccelerometer accel;

	/**
	 * Initialize all static components
	 */
	public static void init(){
		RFDrive = new Talon(Constants.RF_PWM_DRIVE);
		RBDrive = new Talon(Constants.RB_PWM_DRIVE);
		LFDrive = new Talon(Constants.LF_PWM_DRIVE);
		LBDrive = new Talon(Constants.LB_PWM_DRIVE);
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
		
		gyro = new Gyro(0);
		accel = new AnalogAccelerometer(1);
		//encodeOne = new Encoder(Constants.ENCODER_ONE / 10, Constants.ENCODER_ONE - Constants.ENCODER_TWO / 10 * 10);
		//encodeTwo = new Encoder(Constants.ENCODER_TWO / 10, Constants.ENCODER_TWO - Constants.ENCODER_TWO / 10 * 10);
	
	}
}

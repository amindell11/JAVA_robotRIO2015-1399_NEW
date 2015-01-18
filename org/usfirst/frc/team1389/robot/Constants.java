package org.usfirst.frc.team1389.robot;

public class Constants {

	//Motor + Joystick ports
	static final int RIGHT_PWM_DRIVE    = 0;
	static final int LEFT_PWM_DRIVE     = 1;
	static final int ELEVATOR_PWM       = 2;
	static final int DRIVE_JOY          = 1;
	static final int MANIP_JOY          = 1;

	//Joystick input values


	static final int ButtonX 			= 3; // XBox Controller X Button number for getRawButton= or getRawAxis=
	static final int ButtonA			= 1; // XBox Controller A Button number
	static final int ButtonB			= 2; // XBox Controller B Button number
	static final int ButtonY			= 4; // XBox Controller Y Button number
	static final int BumperL			= 5; // XBox Controller  Left Bumper number
	static final int BumperR			= 6; // XBox Controller Right Bumper number

	static final int LeftY				= 1; // XBox Controller  Left Y Axis number
	static final int LeftX				= 0; // XBox Controller  Left X Axis number
	static final int LeftTrigger		= 3; // XBox Controller  Left Trigger Axis number
	static final int RightTrigger		= 4; // XBox Controller  Right Trigger Axis number
	static final int RightY				= 5; // XBox Controller Right Y Axis number
	static final int RightX				= 4; // XBox Controller Right X Axis number


	//Values
	static final float LIMITER          = (float) Math.sqrt(2); 

}

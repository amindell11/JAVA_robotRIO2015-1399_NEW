package org.usfirst.frc.team1389.robot;
import edu.wpi.first.wpilibj.*;
public class Elevator implements phaseMethods{

	static Joystick manip = Motors_Sensors.manip;
	static Victor elevator = Motors_Sensors.elevatorOne;
	
	static int direction;
	
	static DigitalInput IRa = Motors_Sensors.IRa;
	static DigitalInput IRb = Motors_Sensors.IRb;
	static DigitalInput IRc = Motors_Sensors.IRc;
	static DigitalInput IRd = Motors_Sensors.IRd;
	static DigitalInput IRe = Motors_Sensors.IRe;

	//Our IR sensors output low when an object is within 2cm - 10cm of an object (e. g. !IRa.get() equates to true when there is an object in front of sensor one) 
	//Sense stores the boolean returns of each IR sensor, updating each tick. Last sense is the same as sense,
	//but values only update when a IR sensor is passed
	boolean [] lastSense = {!IRa.get(), !IRb.get(), !IRc.get(), !IRd.get(), !IRe.get()};
	boolean []sense = new boolean [5];

	public void teleopConfig(){}
	
	public void teleopTick()
	{
		
		sense[0] = !IRa.get(); sense[1] = !IRb.get(); sense[2] = !IRc.get(); sense[3] = !IRd.get(); sense[4] = !IRe.get(); 
		if (!IRa.get() || !IRb.get() || !IRc.get() || !IRd.get() || !IRe.get())
		{
			lastSense[0] = !IRa.get(); lastSense[1] = !IRb.get(); lastSense[2] = !IRc.get(); lastSense[3] = !IRd.get(); lastSense[4] = !IRe.get();
		}
		
		if (manip.getRawAxis(Constants.LeftY) > .4 && !sense[4])
		{
			direction = 1;
			elevator.set(direction * Constants.ELEVATOR_SPEED_MOD);
		}
		if (manip.getRawAxis(Constants.LeftY) < -.4 && !sense[0])
		{
			direction = -1;
			elevator.set(direction * Constants.ELEVATOR_SPEED_MOD);
		}
		if (manip.getRawButton(Constants.ButtonA) && !sense[1])
		{
			direction = getDirection(1);
			elevator.set(direction * Constants.ELEVATOR_SPEED_MOD);
		}
		if (manip.getRawButton(Constants.ButtonX) && !sense[2])
		{
			direction = getDirection(2);
			elevator.set(direction * Constants.ELEVATOR_SPEED_MOD);
		}
		if (manip.getRawButton(Constants.ButtonB) && !sense[3])
		{
			direction = getDirection(3);
			elevator.set(direction * Constants.ELEVATOR_SPEED_MOD);
		}
			

	}

/** 
 * When input is given to bring the elevator to a specified level, this function provides the direction necessary to do so.
 * @param senseID represents the desired level you want to go to (Integers 0 - 4)
 * @param direction represents the direction of the input last pressed so we are able to know where to send the elevator in the case that the desired level
	is the same as the last IR recognized
 * @return -1 represents down, 
 */
	public int getDirection(int senseID)
	{
		for (int i = 0; i < lastSense.length; i++)
		{
			if (lastSense[i])
			{
				if (i < senseID)
					return 1;
				if (i > senseID)
					return -1;
				if (i == senseID)
					return direction * -1;
			}
		}
		return 0;

	}

	public void autonConfig(){}
	public void autonTick(){}

	public void test() {}

}

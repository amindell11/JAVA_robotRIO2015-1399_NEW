package org.usfirst.frc.team1389.robot;

import edu.wpi.first.wpilibj.AnalogAccelerometer;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Gyro;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.Victor;

public class InputState implements Cloneable{
	private XBoxController drive;
	//private XBoxController manip;
	/**
	 * Initialize all static components
	 */
	public InputState(){
		drive = new XBoxController(0);
		drive = new XBoxController(1);
	}
	
	public void tick() {
		
	}
	 protected InputState clone() throws CloneNotSupportedException {
	        return (InputState) super.clone();
	 }

}

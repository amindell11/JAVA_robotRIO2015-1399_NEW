package org.usfirst.frc.team1389.robot;
import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
public class ElevatorComponent extends Component{
	
	int lastSensor;
	DigitalInput[] sensors;
	public ElevatorComponent(){
		componentType="Elevator";
		sensors=Storage.state.infared;
	}
	
	SpeedController elevator= new Victor(Constants.ELEVATOR_PWM);
	//Our IR sensors output low when an object is within 2cm - 10cm of an object (e. g. !IRa.get() equates to true when there is an object in front of sensor one) 
	//Sense stores the boolean returns of each IR sensor, updating each tick. Last sense is the same as sense,
	//but values only update when a IR sensor is passed
	
	public void move(int direction){

		elevator.set(direction* Constants.ELEVATOR_SPEED_MOD);
	}
	
	public void goTo(int loc){
		elevator.set(whereToGo(loc, lastSensor)*Constants.ELEVATOR_SPEED_MOD);
	}
	
	public void updateLastSensor(){
		for(int d=0;d<sensors.length;d++){
			if(!sensors[d].get())lastSensor=d;
		}
	}
	
/** 
 * When input is given to bring the elevator to a specified level, this function provides the direction necessary to do so.
 * @param senseID represents the desired level you want to go to (Integers 0 - 4)
 * @param direction represents the direction of the input last pressed so we are able to know where to send the elevator in the case that the desired level
	is the same as the last IR recognized
 * @return +/- direction in which to move
 */
	public int whereToGo(int senseID, int lastSensor)
	{
		if (lastSensor > senseID){ //above the requested spot
			return 1;
		}
		else if (lastSensor < senseID){ //below the requested spot
			return -1;
		}
		else{
			return 0;
		}

	}

}

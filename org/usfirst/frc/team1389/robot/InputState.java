package org.usfirst.frc.team1389.robot;

public class InputState implements Cloneable{
	private XBoxController drive;
	private XBoxController manip;
	
	private DigitalSwitch limit1;
	private DigitalSwitch limit2;
	
	private DigitalSwitch[] infared;
	
	public InputState(){
		drive = new XBoxController(Constants.DRIVE_JOY);
		manip = new XBoxController(Constants.MANIP_JOY);
		
		limit1 = new DigitalSwitch(Constants.LIMIT_ONE);
		limit2 = new DigitalSwitch(Constants.LIMIT_TWO);
		
		infared = new DigitalSwitch[5];
		
		infared[0]= new DigitalSwitch(Constants.INFRARED_ONE);
		infared[1]= new DigitalSwitch(Constants.INFRARED_TWO);
		infared[2]= new DigitalSwitch(Constants.INFRARED_THREE);
		infared[3]= new DigitalSwitch(Constants.INFRARED_FOUR);
		infared[4]= new DigitalSwitch(Constants.INFRARED_FIVE);
	}
	
	public void tick() {
		drive.tick();
		//TODO
	}
	 protected InputState clone() throws CloneNotSupportedException {
	        InputState newState = (InputState) super.clone();
	        newState.drive = drive.clone();
	        newState.manip = manip.clone();
	        newState.limit1 = limit1.clone();
	        newState.limit2 = limit2.clone();
	        return newState;
	 }
	 

	public DigitalSwitch[] getInfared() {
		return infared;
	}

	public DigitalSwitch getLimit1() {
		return limit1;
	}

	public DigitalSwitch getLimit2() {
		return limit2;
	}

	public XBoxController getDrive() {
		return drive;
	}

	public XBoxController getManip() {
		return manip;
	}
	 

}

package org.usfirst.frc.team1389.robot;

	import edu.wpi.first.wpilibj.BuiltInAccelerometer;
	import edu.wpi.first.wpilibj.DigitalInput;
	import edu.wpi.first.wpilibj.Encoder;
	import edu.wpi.first.wpilibj.interfaces.Accelerometer;

	public class InputState{
		public XBoxController drive;
		public XBoxController manip;
		
		public Encoder encoder1;
		public Encoder encoder2;
		
		public Accelerometer accelerometer;
		
		public DigitalInput limit1;
		public DigitalInput limit2;
		
		
		public DigitalInput[] infared;
		
		public InputState(){
			accelerometer= new BuiltInAccelerometer();
			drive = new XBoxController(Constants.DRIVE_JOY);
			manip = new XBoxController(Constants.MANIP_JOY);
			
			encoder1 = new Encoder(Constants.ENCODER_1A,Constants.ENCODER_1B);
			encoder1 = new Encoder(Constants.ENCODER_2A,Constants.ENCODER_2B);
			
			limit1 = new DigitalInput(Constants.LIMIT_ONE);
			limit2 = new DigitalInput(Constants.LIMIT_TWO);
			
			infared = new DigitalInput[5];
			
			infared[0]= new DigitalInput(Constants.INFRARED_ONE);
			infared[1]= new DigitalInput(Constants.INFRARED_TWO);
			infared[2]= new DigitalInput(Constants.INFRARED_THREE);
			infared[3]= new DigitalInput(Constants.INFRARED_FOUR);
			infared[4]= new DigitalInput(Constants.INFRARED_FIVE);
		}
		public void tick(){
			drive.tick();
			manip.tick();
		}
} 


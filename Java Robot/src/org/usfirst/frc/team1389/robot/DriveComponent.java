package org.usfirst.frc.team1389.robot;
import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class DriveComponent extends Component{
	final AssistedRampUp rampUpState=AssistedRampUp.COMPUTER_ASSISTED;
	final boolean encoderVerified=false;
	double actualLeft = 0, actualRight = 0;
	double leftCoef=1,rightCoef=1;
	Talon RFDrive;
	Talon RBDrive;
	Talon LFDrive;
	Talon LBDrive;
	public DriveComponent() {
		componentType="Drive";
		RFDrive = new Talon(Constants.RF_PWM_DRIVE);
		RBDrive = new Talon(Constants.RB_PWM_DRIVE);
		LFDrive = new Talon(Constants.LF_PWM_DRIVE);
		LBDrive = new Talon(Constants.LB_PWM_DRIVE);
	}	

	public void drive(double x,double y){
		double leftPower=(y + x) / Constants.LIMITER;
		double rightPower=(y - x) / Constants.LIMITER * -1;
		verifyEncoders(leftPower,rightPower);
		leftPower*=leftCoef;
		rightPower*=rightCoef;
		controlAcceleration(leftPower,actualLeft);
		controlAcceleration(rightPower,actualRight);
		LFDrive.set(actualLeft);
		LBDrive.set(actualLeft);
		RFDrive.set(actualRight);
		RBDrive.set(actualRight);
		SmartDashboard.putNumber("average Power", (double)((int)(100*((actualLeft + actualRight) / 2)))/100);
	}
	
	private void verifyEncoders(double leftPower, double rightPower) {
		final double addend=.1;
		Encoder leftEncoder=Storage.state.encoder1;
		Encoder rightEncoder=Storage.state.encoder2;
		double powerRatio=leftPower/rightPower;
		double encoderRatio=leftEncoder.getRate()/rightEncoder.getRate();
		if(powerRatio>encoderRatio){
			leftCoef-=addend*leftPower!=0?(Math.abs(leftPower)/leftPower):0;
			rightCoef+=addend*leftPower!=0?(Math.abs(rightPower)/rightPower):0;
		}
		else if(powerRatio<encoderRatio){
			leftCoef+=addend*leftPower!=0?(Math.abs(leftPower)/leftPower):0;
			rightCoef-=addend*leftPower!=0?(Math.abs(rightPower)/rightPower):0;
		}
	}

	private void controlAcceleration(double power, double actualPower) {
		if(rampUpState==AssistedRampUp.COMPUTER_ASSISTED){
			actualPower=AssistedPowerControl(power,actualPower);
		}
		else if(rampUpState==AssistedRampUp.STRICT_COMPUTER){
			actualPower=PowerControl(power,actualPower);
		}
		else{
			actualPower=power;
		}
	}

	/**
	 * used in computer assisted ramp up state, uses a proportional power increase/decrease curve to allow user override
	 * @param Power side-specific input from controller
	 * @param actualPower current power on the same side
	 * @return new actual power based on requested Power
	 */
	private double AssistedPowerControl(double Power, double actualPower){
		double proportionalChange = Constants.PERCENT_POWER_CHANGE * Math.abs(Power - actualPower);
		if (Power > actualPower + proportionalChange){
			actualPower += proportionalChange;
		} else if (Power < actualPower - proportionalChange){
			actualPower-= proportionalChange;
		} else {
			actualPower = Power;
		}
		return actualPower;
	}
	
	/**
	 * used in computer restricted ramp up state, power increase/decrease per tick is limited to a fixed value
	 * @param Power side-specific input from controller
	 * @param actualPower current power on the same side
	 * @return new actual power based on requested Power
	 */
	private double PowerControl(double Power, double actualPower){
		//TODO
		double proportionalChange = Constants.PERCENT_POWER_CHANGE * Math.abs(Power - actualPower);
		if (Power > actualPower + proportionalChange){
			actualPower += proportionalChange;
		} else if (Power < actualPower - proportionalChange){
			actualPower-= proportionalChange;
		} else {
			actualPower = Power;
		}
		return actualPower;
	}
}

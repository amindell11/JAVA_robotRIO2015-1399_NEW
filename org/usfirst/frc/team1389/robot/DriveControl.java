package org.usfirst.frc.team1389.robot;
import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class DriveControl extends Component{

	boolean invertedX = true;
	boolean invertedY = false;
	Talon RFDrive;
	Talon RBDrive;
	Talon LFDrive;
	Talon LBDrive;
	
	public DriveControl() {
		RFDrive = new Talon(Constants.RF_PWM_DRIVE);
		RBDrive = new Talon(Constants.RB_PWM_DRIVE);
		LFDrive = new Talon(Constants.LF_PWM_DRIVE);
		LBDrive = new Talon(Constants.LB_PWM_DRIVE);
	}	
	
	/**
	 * Drive train Teleoperated setup
	 */
	@Override
	public void teleopConfig(){}
	
	/**
	 * Teleoperated control for the drive train
	 */
	@Override
	public void teleopTick(InputState state)
	{
		double x = state.getDrive().getLeftX()*(invertedX?1:-1);
		double y = state.getDrive().getLeftY()*(invertedY?1:-1);
			//Debug
			SmartDashboard.putNumber("Driver LeftX", x);
			SmartDashboard.putNumber("Driver LeftY", y);
			SmartDashboard.putNumber("Left Power", (y + x) / Constants.LIMITER);
			SmartDashboard.putNumber("Right Power", (y - x) / Constants.LIMITER);
		x += selfTurn(state);
		LFDrive.set((y + x) / Constants.LIMITER);
		LBDrive.set((y + x) / Constants.LIMITER);
		RFDrive.set((y - x) / Constants.LIMITER * -1);
		RBDrive.set((y - x) / Constants.LIMITER * -1);
	}
	
	public double selfTurn(InputState state)
	{
		if (state.getLimit1().isOn() ^ state.getLimit2().isOn())
		{
			if (state.getLimit1().isOn())
				return -.5;
			if (state.getLimit2().isOn())
				return .5;
		}
		return 0;
	}
	
	/**
	 * Drive train Autonomous setup
	 */
	@Override
	public void autonConfig(){}
	
	/**
	 * Instructions for drive train at each autonomous tick. 
	 */
	@Override
	public void autonTick(){}
	@Override	
	public void test(){
		
	}
}

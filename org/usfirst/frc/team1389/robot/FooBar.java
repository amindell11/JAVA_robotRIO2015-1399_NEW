package org.usfirst.frc.team1389.robot;

import edu.wpi.first.wpilibj.SpeedController;

public class FooBar extends Component {
	
	SpeedController mo1;
	InputState previousState;
	
	public FooBar() {
		mo1 = new Victor(1234);
		previousState = null;
	}
	
	@Override
	public void teleopTick(InputState state){
		
	}
}

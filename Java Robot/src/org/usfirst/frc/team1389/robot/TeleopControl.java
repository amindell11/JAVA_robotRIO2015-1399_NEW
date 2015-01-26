package org.usfirst.frc.team1389.robot;

import java.util.ArrayList;

public class TeleopControl extends Control{
	final boolean invertedX = true;
	final boolean invertedY = false;
	public TeleopControl(){
	}
	public void tick(){
		double x = Storage.state.drive.getLeftX()*(invertedX?1:-1);
		double y = Storage.state.drive.getLeftY()*(invertedY?1:-1);
		Storage.drive.drive(x,y);
	}
}

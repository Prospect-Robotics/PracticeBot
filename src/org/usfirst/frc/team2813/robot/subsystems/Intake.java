package org.usfirst.frc.team2813.robot.subsystems;

import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Intake extends Subsystem {
	// Put methods for controlling this subsystem
	// here. Call these from Commands.
	
	public final VictorSP intake;
	public final VictorSP belt;
	public int toggle = 0;
	
	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
		// setDefaultCommand(new MySpecialCommand());
	}
	
	public Intake() {
		intake = new VictorSP(4);
		belt = new VictorSP(5);
	}
}
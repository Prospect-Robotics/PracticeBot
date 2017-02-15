package org.usfirst.frc.team2813.robot.subsystems;

import org.usfirst.frc.team2813.robot.commands.OperatorDrive;

import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.Subsystem;

public class DriveTrain extends Subsystem {
	// Put methods for controlling this subsystem
	// here. Call these from Commands.

	public final RobotDrive drive;

	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
		// setDefaultCommand(new MySpecialCommand());
		setDefaultCommand(new OperatorDrive());
	}
	
	public DriveTrain() {
		drive = new RobotDrive(0, 1, 2, 3);
	}
}
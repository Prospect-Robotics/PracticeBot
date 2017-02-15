package org.usfirst.frc.team2813.robot.commands;

import org.usfirst.frc.team2813.robot.Robot;

import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.command.Command;

public class OperatorDrive extends Command {

	ADXRS450_Gyro gyro = new ADXRS450_Gyro();
	double deadZone = 0.275;
	double scale = 1;

	public OperatorDrive() {
		// Use requires() here to declare subsystem dependencies
		requires(Robot.driveTrain);
	}

	// Called just before this Command runs the first time
	protected void initialize() {
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		double joystickTwist = Robot.oi.joystick.getRawAxis(4);
		double getTwist = Math
				.pow(((Math.abs(joystickTwist) + deadZone / (1 - deadZone)) / (1 + deadZone / (1 - deadZone))), 3);
		if (joystickTwist < 0 && 0 < getTwist) {
			getTwist *= -1;
		}
		
		if (Math.IEEEremainder(Robot.oi.joystick.getDirectionDegrees() - gyro.getAngle(), 180) > 10) {
			scale = 1;
		}
		
		Robot.driveTrain.drive.mecanumDrive_Cartesian(Robot.oi.joystick.getX() * scale,
				Robot.oi.joystick.getY() * scale, getTwist, gyro.getAngle());
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return false;
	}

	// Called once after isFinished returns true
	protected void end() {
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
	}
}
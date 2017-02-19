package org.usfirst.frc.team2813.robot.commands;

import org.usfirst.frc.team2813.robot.Robot;

import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.command.Command;

public class OperatorDrive extends Command {

	ADXRS450_Gyro gyro = new ADXRS450_Gyro();
	double deadZone = 0.275;
	double scale = 1;
	int time = 0;

	public OperatorDrive() {
		// Use requires() here to declare subsystem dependencies
		requires(Robot.driveTrain);
	}

	// Called just before this Command runs the first time
	protected void initialize() {
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		if (Math.IEEEremainder(Robot.oi.joystick.getDirectionDegrees() - gyro.getAngle(), 180) > 10) {
			scale = 1;
		}

		double getTwist = Math.pow(((Math.abs(Robot.oi.joystick.getRawAxis(4)) + deadZone / (1 - deadZone))
				/ (1 + deadZone / (1 - deadZone))), 3);
		if (Robot.oi.joystick.getRawAxis(4) < 0 && 0 < getTwist) {
			getTwist *= -1;
		}

		double getX = scale * Robot.oi.joystick.getX();
		double getY = scale * Robot.oi.joystick.getY();
		if (Robot.oi.joystick.getPOV() == -1) {
			time = 0;
		} else  if (time < 3){
			if (180 > Robot.oi.joystick.getPOV() && Robot.oi.joystick.getPOV() > 0) {
				getX = scale;
			} else if (Robot.oi.joystick.getPOV() == 0 || Robot.oi.joystick.getPOV() == 180) {
				getX = 0;
			} else {
				getX = -scale;
			}
			if (270 > Robot.oi.joystick.getPOV() && Robot.oi.joystick.getPOV() > 90) {
				getY = scale;
			} else if (Robot.oi.joystick.getPOV() == 90 || Robot.oi.joystick.getPOV() == 270
					|| Robot.oi.joystick.getPOV() == -1) {
				getY = 0;
			} else {
				getY = -scale;
			}
			time++;
		}
		Robot.driveTrain.drive.mecanumDrive_Cartesian(getX, getY, getTwist, gyro.getAngle());
		// Robot.driveTrain.drive.mecanumDrive_Polar(scale,
		// Robot.oi.joystick.getPOV(), getTwist);

		// Robot.intake.set(Robot.oi.joystick.getRawAxis(2) -
		// Robot.oi.joystick.getRawAxis(3));
		// Robot.belt.set((Robot.oi.joystick.getRawAxis(3) -
		// Robot.oi.joystick.getRawAxis(2)) * 0.6);
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
package org.usfirst.frc.team2813.robot;

import org.usfirst.frc.team2813.robot.subsystems.DriveTrain;
import org.usfirst.frc.team2813.robot.subsystems.Intake;

import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Joystick.AxisType;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {

	public static final DriveTrain driveTrain = new DriveTrain();
	public static final Intake intake = new Intake();
	public static OI oi;

	Command autonomousCommand;
	SendableChooser<Command> chooser = new SendableChooser<Command>();
	SendableChooser<Integer> positionChooser;
	SendableChooser<Integer> airshipChooser;

	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	public void robotInit() {
		oi = new OI();
		chooser.addDefault("Sit there and doing nothing", null);
		chooser.addObject("Also, do nothing", null);
		SmartDashboard.putData("Auto mode", chooser);
	}

	/**
	 * This function is called once each time the robot enters Disabled mode.
	 * You can use it to reset any subsystem information you want to clear when
	 * the robot is disabled.
	 */
	public void disabledInit() {
	}

	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

	/**
	 * This autonomous (along with the chooser code above) shows how to select
	 * between different autonomous modes using the dashboard. The sendable
	 * chooser code works with the Java SmartDashboard. If you prefer the
	 * LabVIEW Dashboard, remove all of the chooser code and uncomment the
	 * getString code to get the auto name from the text box below the Gyro
	 *
	 * You can add additional auto modes by adding additional commands to the
	 * chooser code above (like the commented example) or additional comparisons
	 * to the switch structure below with additional strings & commands.
	 */
	public void autonomousInit() {
		autonomousCommand = chooser.getSelected();

		ADXRS450_Gyro gyro = new ADXRS450_Gyro();
		Encoder encoder = new Encoder(0, 0);

		int position = positionChooser.getSelected() + airshipChooser.getSelected() * 3;
		switch (position) {
		case 2:
			// Drive forward
			encoder.setDistancePerPulse(1);
			while (encoder.getDistance() < 1)
			driveTrain.drive.mecanumDrive_Cartesian(0, -1, 0, gyro.getAngle());
			// Turn clockwise
			while (gyro.getAngle() < 1)
			driveTrain.drive.mecanumDrive_Polar(0, 0, 1);
			break;

		case 3:
			// Drive forward
			encoder.setDistancePerPulse(1);
			while (encoder.getDistance() < 1)
			driveTrain.drive.mecanumDrive_Cartesian(0, -1, 0, gyro.getAngle());
			// Drive left
			while (encoder.getDistance() < 2)
			driveTrain.drive.mecanumDrive_Cartesian(-1, 0, 0, gyro.getAngle());
			// Drive forward
			while (encoder.getDistance() < 3)
			driveTrain.drive.mecanumDrive_Cartesian(0, -1, 0, gyro.getAngle());
			// Turn clockwise
			while (gyro.getAngle() < 1)
			driveTrain.drive.mecanumDrive_Polar(0, 0, 1);
			break;

		case 4:
			// Drive forward
			encoder.setDistancePerPulse(1);
			while (encoder.getDistance() < 1)
			driveTrain.drive.mecanumDrive_Cartesian(0, -1, 0, gyro.getAngle());
			// Drive left
			while (encoder.getDistance() < 2)
			driveTrain.drive.mecanumDrive_Cartesian(-1, 0, 0, gyro.getAngle());
			// Drive forward
			while (encoder.getDistance() < 3)
			driveTrain.drive.mecanumDrive_Cartesian(0, -1, 0, gyro.getAngle());
			// Turn clockwise
			while (gyro.getAngle() < 1)
			driveTrain.drive.mecanumDrive_Polar(0, 0, 1);
			break;

		case 5:
			// Drive forward
			encoder.setDistancePerPulse(1);
			while (encoder.getDistance() < 1)
			driveTrain.drive.mecanumDrive_Cartesian(0, -1, 0, gyro.getAngle());
			// Drive right
			while (encoder.getDistance() < 2)
			driveTrain.drive.mecanumDrive_Cartesian(1, 0, 0, gyro.getAngle());
			break;

		case 6:
			break;

		case 7:
			// Drive forward
			encoder.setDistancePerPulse(1);
			while (encoder.getDistance() < 1)
			driveTrain.drive.mecanumDrive_Cartesian(0, -1, 0, gyro.getAngle());
			// Drive left
			while (encoder.getDistance() < 2)
			driveTrain.drive.mecanumDrive_Cartesian(-1, 0, 0, gyro.getAngle());
			break;

		case 8:
			// Drive forward
			encoder.setDistancePerPulse(1);
			while (encoder.getDistance() < 1)
			driveTrain.drive.mecanumDrive_Cartesian(0, -1, 0, gyro.getAngle());
			// Drive right
			while (encoder.getDistance() < 2)
			driveTrain.drive.mecanumDrive_Cartesian(1, 0, 0, gyro.getAngle());
			// Drive forward
			while (encoder.getDistance() < 3)
			driveTrain.drive.mecanumDrive_Cartesian(0, -1, 0, gyro.getAngle());
			// Turn counterclockwise
			while (gyro.getAngle() < 1)
			driveTrain.drive.mecanumDrive_Polar(0, 0, -1);
			break;

		case 9:
			// Drive forward
			encoder.setDistancePerPulse(1);
			while (encoder.getDistance() < 1)
			driveTrain.drive.mecanumDrive_Cartesian(0, -1, 0, gyro.getAngle());
			// Drive right
			while (encoder.getDistance() < 2)
			driveTrain.drive.mecanumDrive_Cartesian(1, 0, 0, gyro.getAngle());
			// Drive forward
			while (encoder.getDistance() < 3)
			driveTrain.drive.mecanumDrive_Cartesian(0, -1, 0, gyro.getAngle());
			// Turn counterclockwise
			while (gyro.getAngle() < 1)
			driveTrain.drive.mecanumDrive_Polar(0, 0, -1);
			break;

		case 10:
			// Drive forward
			encoder.setDistancePerPulse(1);
			while (encoder.getDistance() < 1)
			driveTrain.drive.mecanumDrive_Cartesian(0, -1, 0, gyro.getAngle());
			// Turn counterclockwise
			while (gyro.getAngle() < 1)
			driveTrain.drive.mecanumDrive_Polar(0, 0, -1);
			break;
		}

		/*
		 * String autoSelected = SmartDashboard.getString("Auto Selector",
		 * "Default"); switch(autoSelected) { case "My Auto": autonomousCommand
		 * = new MyAutoCommand(); break; case "Default Auto": default:
		 * autonomousCommand = new ExampleCommand(); break; }
		 */

		// schedule the autonomous command (example)
		for (int i = 0; i < oi.joystick.getAxisCount(); i++) {
			int axistype = oi.joystick.getAxisType(i);
			String name;
			try {
				name = AxisType.values()[axistype].toString();
			} catch (ArrayIndexOutOfBoundsException e) {
				name = "INVALID";
			}
			// I have no other way to do this
			System.out.println(String.format("Axis %d is of type %d (%s)\n", i, axistype, name));
		}
		if (autonomousCommand != null)
			autonomousCommand.start();
	}

	/**
	 * This function is called periodically during autonomous
	 */
	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
	}

	public void teleopInit() {
		// This makes sure that the autonomous stops running when
		// teleop starts running. If you want the autonomous to
		// continue until interrupted by another command, remove
		// this line or comment it out.
		if (autonomousCommand != null)
			autonomousCommand.cancel();
	}

	/**
	 * This function is called periodically during operator control
	 */
	public void teleopPeriodic() {
		Scheduler.getInstance().run();

	}

	/**
	 * This function is called periodically during test mode
	 */
	public void testPeriodic() {
		LiveWindow.run();
	}
}
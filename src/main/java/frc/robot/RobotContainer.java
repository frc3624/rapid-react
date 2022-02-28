package frc.robot;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.math.controller.RamseteController;
import edu.wpi.first.math.controller.SimpleMotorFeedforward;
import edu.wpi.first.math.trajectory.Trajectory;
import edu.wpi.first.math.trajectory.TrajectoryUtil;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.Filesystem;
import edu.wpi.first.wpilibj.XboxController;
import frc.robot.commands.drive.DriveTrain;
import frc.robot.commands.RunElevator;
import frc.robot.commands.climbing.ClimbingDown;
import frc.robot.commands.climbing.ClimbingUp;
import frc.robot.commands.shooting.RunShooter;
import frc.robot.subsystems.Climb;
import frc.robot.subsystems.drive.Drive;
import frc.robot.subsystems.drive.PathDrive;
import frc.robot.subsystems.Elevator;
import frc.robot.subsystems.Limelight;
import frc.robot.subsystems.Shooter;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.RamseteCommand;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;

import static frc.robot.Constants.*;

import java.io.IOException;
import java.nio.file.Path;

public class RobotContainer {
	// Controller and Buttons
	private final XboxController xboxController = new XboxController(CONTROLLER_ID);
	private final JoystickButton climbUpButton = new JoystickButton(xboxController, BUTTON_B);
	private final JoystickButton climbDownButton = new JoystickButton(xboxController, BUTTON_A);
	private final JoystickButton elevatorButton = new JoystickButton(xboxController, BUTTON_X);
	private final JoystickButton shootingButton = new JoystickButton(xboxController, BUTTON_Y);
	
	// Subsystems
	private final Drive drive = new Drive();
	private final PathDrive pathDrive = new PathDrive();
	private final Climb climb = new Climb();
	private final Elevator elevator = new Elevator();
	private final Shooter shooter = new Shooter();
	private final Limelight limelight = new Limelight(); 
	
	// Commands
	private final DriveTrain driveTrain = new DriveTrain(drive, xboxController);
	private final RunElevator runElevator = new RunElevator(elevator);
	private final ClimbingDown climbingDown = new ClimbingDown(climb, xboxController);
	private final ClimbingUp climbingUp = new ClimbingUp(climb, xboxController);
	private final RunShooter runShooter = new RunShooter(shooter, elevator, limelight);
	
		/**
	 * Here, we download the path as a json file so it can be traversed by the robot
	 * The path already specifies voltage/speed/acceleration constraints
	 * unsure if in RobotContainer or in Robot
	 */
	String trajectoryJSON = "paths/testautonomous.wpilib.json";
	Trajectory trajectory = new Trajectory();

	public void robotInit() {
   		try {
      		Path trajectoryPath = Filesystem.getDeployDirectory().toPath().resolve(trajectoryJSON);
      		trajectory = TrajectoryUtil.fromPathweaverJson(trajectoryPath);
   		} catch (IOException ex) {
      		DriverStation.reportError("Unable to open trajectory: " + trajectoryJSON, ex.getStackTrace());
   		}
	}
	
	public RobotContainer() {
		configureButtonBindings();
		drive.setDefaultCommand(driveTrain);
	}

	private void configureButtonBindings() {
		climbDownButton.whileHeld(climbingDown);
		climbUpButton.whileHeld(climbingUp);
		elevatorButton.whileHeld(runElevator);
	}

	public Command getAutonomousCommand() {
		/**
		 * The ramsete command allows us to execute the autonomous code
		 */
		RamseteCommand ramseteCommand =
			new RamseteCommand(
				trajectory,
				pathDrive::getPose,
				new RamseteController(Constants.kRamseteB, Constants.kRamseteZeta),
				new SimpleMotorFeedforward(Constants.ksVolts,
										Constants.kvVoltSecondsPerMeter,
										Constants.kaVoltSecondsSquaredPerMeter),
				Constants.kDriveKinematics,
				pathDrive::getWheelSpeeds,
				new PIDController(Constants.kPDriveVel, 0, 0),
				new PIDController(Constants.kPDriveVel, 0, 0),
				// RamseteCommand passes volts to the callback
				pathDrive::tankDriveVolts,
				pathDrive
		);
		
		// Reset odometry to the starting pose of the trajectory.
		pathDrive.resetOdometry(trajectory.getInitialPose());
		
		// Run path following command, then stop at the end.
		return ramseteCommand.andThen(() -> pathDrive.tankDriveVolts(0, 0));
	}
}
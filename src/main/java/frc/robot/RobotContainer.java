<<<<<<< HEAD
package frc.robot;

import edu.wpi.first.wpilibj.XboxController;
import frc.robot.commands.drive.DriveTrain;
import frc.robot.commands.RunElevator;
import frc.robot.commands.climbing.ClimbingDown;
import frc.robot.commands.climbing.ClimbingUp;
import frc.robot.commands.shooting.RunShooter;
import frc.robot.commands.shooting.tracking.TrackTarget;
import frc.robot.subsystems.Climb;
import frc.robot.subsystems.Drive;
import frc.robot.subsystems.Elevator;
import frc.robot.subsystems.Limelight;
import frc.robot.subsystems.Shooter;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;

import static frc.robot.Constants.*;

public class RobotContainer {
	// Controller and Buttons
	private final XboxController xboxController = new XboxController(CONTROLLER_ID);
	private final JoystickButton climbUpButton = new JoystickButton(xboxController, BUTTON_B);
	private final JoystickButton climbDownButton = new JoystickButton(xboxController, BUTTON_A);
	private final JoystickButton elevatorButton = new JoystickButton(xboxController, BUTTON_X);
	private final JoystickButton shootingButton = new JoystickButton(xboxController, BUTTON_Y);
	private final JoystickButton trackButton = new JoystickButton(xboxController, BUTTON_LB);
	
	// Subsystems
	private final Drive drive = new Drive();
	private final Climb climb = new Climb();
	private final Elevator elevator = new Elevator();
	private final Shooter shooter = new Shooter();
	private final Limelight limelight = new Limelight(); 
	
	// Commands
	private final DriveTrain driveTrain = new DriveTrain(drive, xboxController);
	private final RunElevator runElevator = new RunElevator(elevator);
	private final ClimbingDown climbingDown = new ClimbingDown(climb, xboxController);
	private final ClimbingUp climbingUp = new ClimbingUp(climb, xboxController);
	private final TrackTarget trackTarget = new TrackTarget(shooter, limelight);
	private final RunShooter runShooter = new RunShooter(shooter, elevator, limelight);
	
	public RobotContainer() {
		configureButtonBindings();
		drive.setDefaultCommand(driveTrain);
	}

	private void configureButtonBindings() {
		climbUpButton.whileHeld(climbingUp);
		climbDownButton.whileHeld(climbingDown);
		elevatorButton.whileHeld(runElevator);
		shootingButton.whileHeld(runShooter);
		trackButton.whileHeld(trackTarget);
	}

	public Command getAutonomousCommand() {
		return null;
	}
}
=======
package frc.robot;

import edu.wpi.first.wpilibj.XboxController;
import frc.robot.commands.drive.DriveTrain;
import frc.robot.commands.RunElevator;
import frc.robot.commands.climbing.ClimbingDown;
import frc.robot.commands.climbing.ClimbingUp;
import frc.robot.commands.shooting.RunShooter;
import frc.robot.subsystems.Climb;
import frc.robot.subsystems.Drive;
import frc.robot.subsystems.Elevator;
import frc.robot.subsystems.Limelight;
import frc.robot.subsystems.Shooter;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;

import static frc.robot.Constants.*;

public class RobotContainer {
	// Controller and Buttons
	private final XboxController xboxController = new XboxController(CONTROLLER_ID);
	private final JoystickButton climbUpButton = new JoystickButton(xboxController, BUTTON_B);
	private final JoystickButton climbDownButton = new JoystickButton(xboxController, BUTTON_A);
	private final JoystickButton elevatorButton = new JoystickButton(xboxController, BUTTON_X);
	private final JoystickButton shootingButton = new JoystickButton(xboxController, BUTTON_Y);
	
	// Subsystems
	private final Drive drive = new Drive();
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
	
	public RobotContainer() {
		configureButtonBindings();
		drive.setDefaultCommand(driveTrain);
	}

	private void configureButtonBindings() {
		climbUpButton.whileHeld(climbingUp);
		climbDownButton.whileHeld(climbingDown);
		elevatorButton.whileHeld(runElevator);
		shootingButton.whileHeld(runShooter);
	}

	public Command getAutonomousCommand() {
		return null;
	}
}
>>>>>>> 229ee79ce88c745a91bc86a7b4cf2f1bbc67aaf4

package frc.robot;

import edu.wpi.first.wpilibj.XboxController;
import frc.robot.commands.DriveTrain;
import frc.robot.commands.climbing.ClimbingDown;
import frc.robot.commands.climbing.ClimbingUp;
import frc.robot.commands.elevator.RunBottom;
import frc.robot.commands.elevator.RunUpper;
import frc.robot.subsystems.Climb;
import frc.robot.subsystems.Drive;
import frc.robot.subsystems.Elevator;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;

import static frc.robot.Constants.*;

public class RobotContainer {
	// Controller and Buttons
	private final XboxController xboxController = new XboxController(CONTROLLER_ID);
	private final JoystickButton elevatorUpButton = new JoystickButton(xboxController, BUTTON_Y);
	private final JoystickButton elevatorDownButton = new JoystickButton(xboxController, BUTTON_X);
	private final JoystickButton climbUpButton = new JoystickButton(xboxController, BUTTON_B);
	private final JoystickButton climbDownButton = new JoystickButton(xboxController, BUTTON_A);
	
	// Subsystems
	private final Drive drive = new Drive();
	private final Climb climb = new Climb();
	private final Elevator elevator = new Elevator();
	
	// Commands
	private final DriveTrain driveTrain = new DriveTrain(drive, xboxController);
	private final RunBottom runBottomElevator = new RunBottom(elevator);
	private final RunUpper runUpperElevator = new RunUpper(elevator);
	private final ClimbingDown climbingDown = new ClimbingDown(climb, xboxController);
	private final ClimbingUp climbingUp = new ClimbingUp(climb, xboxController);
	
	public RobotContainer() {
		configureButtonBindings();
		drive.setDefaultCommand(driveTrain);
	}

	private void configureButtonBindings() {
		climbDownButton.whileHeld(climbingDown);
		climbUpButton.whileHeld(climbingUp);
		elevatorUpButton.whileHeld(runUpperElevator);
		elevatorDownButton.whileHeld(runBottomElevator);
	}

	public Command getAutonomousCommand() {
		return null;
	}
}

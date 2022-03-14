package frc.robot;

import static frc.robot.Constants.BUTTON_A;
import static frc.robot.Constants.BUTTON_B;
import static frc.robot.Constants.BUTTON_LB;
import static frc.robot.Constants.BUTTON_RB;
import static frc.robot.Constants.BUTTON_X;
import static frc.robot.Constants.BUTTON_Y;
import static frc.robot.Constants.CONTROLLER_ID;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command; 
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.controls.DPadButton;
import frc.controls.DPadButton.DPadDirection;
import frc.robot.commands.climbing.ClimbingDown;
import frc.robot.commands.climbing.ClimbingUp;
import frc.robot.commands.drive.DriveTrain;
import frc.robot.commands.drive.ShiftGear;
import frc.robot.commands.intake.RunIntake;
import frc.robot.commands.limelight.IntakePosition;
import frc.robot.commands.limelight.ShootPosition;
import frc.robot.commands.limelight.ViewPosition;
import frc.robot.commands.shooting.RunShooter;
import frc.robot.commands.shooting.tracking.TrackTarget;
import frc.robot.subsystems.Climb;
import frc.robot.subsystems.Drive;
import frc.robot.subsystems.Intake;
import frc.robot.subsystems.LazySusan;
import frc.robot.subsystems.Limelight;
import frc.robot.subsystems.Shooter;

public class RobotContainer {
	// Controller and Buttons
	private final XboxController xboxController = new XboxController(CONTROLLER_ID);
	private final JoystickButton climbUpButton = new JoystickButton(xboxController, BUTTON_B);
	private final JoystickButton climbDownButton = new JoystickButton(xboxController, BUTTON_A);
	private final JoystickButton elevatorButton = new JoystickButton(xboxController, BUTTON_X);
	private final JoystickButton shootingButton = new JoystickButton(xboxController, BUTTON_Y);
	private final JoystickButton trackButton = new JoystickButton(xboxController, BUTTON_LB);
	private final JoystickButton gearShiftButton = new JoystickButton(xboxController, BUTTON_RB);

	private final DPadButton limelightIntakePositionButton = new DPadButton(xboxController, DPadDirection.RIGHT);
	private final DPadButton limelightDrivePositionButton = new DPadButton(xboxController, DPadDirection.LEFT);
	private final DPadButton limelightShootPositionButton = new DPadButton(xboxController, DPadDirection.UP);
	
	// Subsystems
	private final Drive drive = new Drive();
	private final Climb climb = new Climb();
	private final Intake intake = new Intake();
	private final Shooter shooter = new Shooter();
	private static final Limelight limelight = new Limelight();
	private final LazySusan lazySusan = new LazySusan();
	
	// Commands
	private final DriveTrain driveTrain = new DriveTrain(drive, xboxController);
	private final ShiftGear shiftGear = new ShiftGear(drive);
	private final RunIntake runIntake = new RunIntake(intake);
	private final ClimbingDown climbingDown = new ClimbingDown(climb, xboxController);
	private final ClimbingUp climbingUp = new ClimbingUp(climb, xboxController);
	private final TrackTarget trackTarget = new TrackTarget(lazySusan, limelight);
	private final RunShooter runShooter = new RunShooter(shooter, intake, limelight);
	
	private final IntakePosition intakePosition = new IntakePosition(limelight);
	private final ViewPosition viewPosition = new ViewPosition(limelight);
	private final ShootPosition shootPosition = new ShootPosition(limelight);

	public RobotContainer() {
		configureButtonBindings();
		drive.setDefaultCommand(driveTrain);
		//lazySusan.setDefaultCommand(trackTarget);
	}

	private void configureButtonBindings() {
		gearShiftButton.whenPressed(shiftGear);
		climbUpButton.whileHeld(climbingUp);
		climbDownButton.whileHeld(climbingDown);
		elevatorButton.toggleWhenPressed(runIntake);
		shootingButton.toggleWhenPressed(runShooter);
		trackButton.whileHeld(trackTarget);

		limelightIntakePositionButton.whenHeld(intakePosition);
		limelightDrivePositionButton.whenHeld(viewPosition);
		limelightShootPositionButton.whenHeld(shootPosition);
	}

	public Command getAutonomousCommand() {
		return null;
	}
}

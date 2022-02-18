// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.XboxController;
import frc.robot.commands.DriveTrain;
import frc.robot.commands.climbing.ClimbingDown;
import frc.robot.commands.climbing.ClimbingUp;
import frc.robot.subsystems.Climb;
import frc.robot.subsystems.Drive;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;

import static frc.robot.Constants.*;

public class RobotContainer {
	// Controller and Buttons
	private final XboxController xboxController = new XboxController(CONTROLLER_ID);
	private final JoystickButton climbUpButton = new JoystickButton(xboxController, BUTTON_B);
	private final JoystickButton climbDownButton = new JoystickButton(xboxController, BUTTON_A);
	
	// Subsystems
	private final Drive drive = new Drive();
	private final Climb climb = new Climb();
	
	// Commands
	private final DriveTrain driveTrain = new DriveTrain(drive, xboxController);
	private final ClimbingDown climbingDown = new ClimbingDown(climb, xboxController);
	private final ClimbingUp climbingUp = new ClimbingUp(climb, xboxController);
	
	public RobotContainer() {
		configureButtonBindings();
		drive.setDefaultCommand(driveTrain);
	}

	private void configureButtonBindings() {
		climbDownButton.whileHeld(climbingDown);
		climbUpButton.whileHeld(climbingUp);
	}

	public Command getAutonomousCommand() {
		return null;
	}
}

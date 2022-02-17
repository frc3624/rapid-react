// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.XboxController;
import frc.robot.commands.DriveTrain;
import frc.robot.commands.elevator.RunBottom;
import frc.robot.commands.elevator.RunUpper;
import frc.robot.subsystems.Drive;
import frc.robot.subsystems.Elevator;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;

// Will organize imports later, just convenient for now
import static frc.robot.Constants.*;

public class RobotContainer {
	// Controller and Buttons
	private final XboxController xboxController = new XboxController(CONTROLLER_ID);
	private final JoystickButton elevatorButton = new JoystickButton(xboxController, BUTTON_A);
	private final JoystickButton elevatorButton1 = new JoystickButton(xboxController, BUTTON_B);
	
	// Subsystems
	private final Drive drive = new Drive();
	private final Elevator elevator = new Elevator();
	
	// Commands
	private final DriveTrain driveTrain = new DriveTrain(drive, xboxController);
	private final RunUpper runElevator = new RunUpper(elevator);
	private final RunBottom runElevator1 = new RunBottom(elevator);
	
	public RobotContainer() {
		configureButtonBindings();
		drive.setDefaultCommand(driveTrain);
	}

	private void configureButtonBindings() {
		elevatorButton.whileHeld(runElevator);
		elevatorButton1.whileHeld(runElevator1);
	}

	public Command getAutonomousCommand() {
		return null;
	}
}

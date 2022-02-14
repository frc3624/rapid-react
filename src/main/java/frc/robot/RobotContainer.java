// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.XboxController;
import frc.robot.commands.DriveTrain;
import frc.robot.commands.SenseColor;
import frc.robot.subsystems.ColorSensor;
import frc.robot.subsystems.Drive;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;

import static frc.robot.Constants.*;

public class RobotContainer {
	// Controller and Buttons
	private final XboxController xboxController = new XboxController(CONTROLLER_ID);
	private final JoystickButton senseColorButton = new JoystickButton(xboxController, BUTTON_A);

	
	// Subsystems
	private final Drive drive = new Drive();
	private final ColorSensor colorSensor = new ColorSensor();
	
	// Commands
	private final DriveTrain driveTrain = new DriveTrain(drive, xboxController);
	private final SenseColor senseColor = new SenseColor(colorSensor);

	public RobotContainer() {
		configureButtonBindings();
		drive.setDefaultCommand(driveTrain);
	}

	private void configureButtonBindings() {
		senseColorButton.whileHeld(senseColor);
	}

	public Command getAutonomousCommand() {
		return null;
	}
}

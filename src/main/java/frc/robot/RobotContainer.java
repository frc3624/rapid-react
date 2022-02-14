// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.XboxController;
import frc.robot.commands.DriveTrain;
import frc.robot.commands.climbing.Climbing;
import frc.robot.subsystems.Climb;
import frc.robot.subsystems.Drive;
import edu.wpi.first.wpilibj2.command.Command;
import static frc.robot.Constants.*;

public class RobotContainer {
	// Controller and Buttons
	private final XboxController xboxController = new XboxController(CONTROLLER_ID);
	
	// Subsystems
	private final Drive drive = new Drive();
	private final Climb climb = new Climb();
	
	// Commands
	private final DriveTrain driveTrain = new DriveTrain(drive, xboxController);
	private final Climbing climbing = new Climbing(climb, xboxController);

	
	public RobotContainer() {
		configureButtonBindings();
		drive.setDefaultCommand(driveTrain);
		climb.setDefaultCommand(climbing);
	}

	private void configureButtonBindings() {

	}

	public Command getAutonomousCommand() {
		return null;
	}
}

<<<<<<< HEAD
// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.drive;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Drive;

public class DriveTrain extends CommandBase {
	private final Drive drive;
	private final XboxController xboxController;
	public DriveTrain(Drive drive, XboxController joystick) {
		this.drive = drive;
		this.xboxController = joystick;
		addRequirements(drive);
	}

	@Override
	public void execute() {
		drive.arcadeDrive(xboxController.getLeftY(), -xboxController.getRightX());
	}
}
=======
// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.drive;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Drive;

public class DriveTrain extends CommandBase {
	private final Drive drive;
	private final XboxController xboxController;
	public DriveTrain(Drive drive, XboxController joystick) {
		this.drive = drive;
		this.xboxController = joystick;
		addRequirements(drive);
	}

	@Override
	public void execute() {
		drive.arcadeDrive(xboxController.getLeftY(), -xboxController.getLeftX());
	}
}
>>>>>>> 229ee79ce88c745a91bc86a7b4cf2f1bbc67aaf4
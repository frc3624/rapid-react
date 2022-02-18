// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

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
	public void initialize() {}

	@Override
	public void execute() {
		drive.arcadeDrive(-xboxController.getRightX(), xboxController.getLeftY());
	}

	@Override
	public void end(boolean interrupted) {}

	@Override
	public boolean isFinished() {
		return false;
	}
}

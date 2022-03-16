// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.drive;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Drive;

public class ShiftGear extends CommandBase {
	private final Drive drive;
	public ShiftGear(Drive drive) {
		this.drive = drive;
		addRequirements(drive);
	}

	@Override
	public void execute() {
		drive.toggleGear();
	}
}


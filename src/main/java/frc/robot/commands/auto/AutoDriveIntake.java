// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.auto;

import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import frc.robot.commands.intake.RunIntake;
import frc.robot.subsystems.Drive;
import frc.robot.subsystems.Intake;

public class AutoDriveIntake extends ParallelCommandGroup {
	public AutoDriveIntake(Drive drive, Intake intake) {
		addCommands(new AutoDrive(drive), new RunIntake(intake));
	}
}


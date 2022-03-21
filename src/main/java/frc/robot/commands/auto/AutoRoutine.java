// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.auto;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.subsystems.Drive;
import frc.robot.subsystems.Intake;
import frc.robot.subsystems.Shooter;

public class AutoRoutine extends SequentialCommandGroup {
	public AutoRoutine(Drive drive, Intake intake, Shooter shooter) {
		addCommands(new AutoDriveIntake(drive, intake), new AutoShoot(shooter));
	}
}


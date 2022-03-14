// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.shooting;

import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import frc.robot.subsystems.Intake;
import frc.robot.subsystems.Limelight;
import frc.robot.subsystems.Shooter;

public class RunShooter extends ParallelCommandGroup {
	public RunShooter(Shooter shooter, Intake intake, Limelight limelight) {
		addCommands(new DumpIntake(intake), new Shoot(shooter, limelight));
	}
}


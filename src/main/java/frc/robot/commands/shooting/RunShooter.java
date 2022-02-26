// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.shooting;

import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import frc.robot.subsystems.Elevator;
import frc.robot.subsystems.Limelight;
import frc.robot.subsystems.Shooter;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/stable/docs/software/commandbased/convenience-features.html
public class RunShooter extends ParallelCommandGroup {
	private final Shooter shooter;
	private final Elevator elevator;
	private final Limelight limelight;
	public RunShooter(Shooter shooter, Elevator elevator, Limelight limelight) {
		this.shooter = shooter;
		this.elevator = elevator;
		this.limelight = limelight;
		addCommands(new DumpElevator(elevator), new Shoot(shooter, limelight));
	}
}


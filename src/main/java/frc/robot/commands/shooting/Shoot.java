<<<<<<< HEAD
// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.shooting;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Limelight;
import frc.robot.subsystems.Shooter;
import frc.robot.subsystems.Limelight.LedMode;

public class Shoot extends CommandBase {
	private final Limelight limelight;
	private final Shooter shooter;
	
	public Shoot(Shooter shooter, Limelight limelight) {
		this.shooter = shooter;
		this.limelight = limelight;
		addRequirements(shooter);
	}

	@Override
	public void initialize() {
		limelight.setLedMode(LedMode.ON);
	}

	@Override
	public void execute() {
		shooter.setLinearSpeed();
	}

	@Override
	public void end(boolean interrupted) {
		limelight.setLedMode(LedMode.CURRENT);
		shooter.setShootMotorSpeed(0);
	}

	@Override
	public boolean isFinished() {
	return false;
	}
}

=======
// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.shooting;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Limelight;
import frc.robot.subsystems.Shooter;
import frc.robot.subsystems.Limelight.LedMode;

public class Shoot extends CommandBase {
	private final Limelight limelight;
	private final Shooter shooter;
	
	public Shoot(Shooter shooter, Limelight limelight) {
		this.shooter = shooter;
		this.limelight = limelight;
		addRequirements(shooter);
	}

	@Override
	public void initialize() {
		limelight.setLedMode(LedMode.ON);
	}

	@Override
	public void execute() {
		shooter.setLinearSpeed();
	}

	@Override
	public void end(boolean interrupted) {
		limelight.setLedMode(LedMode.CURRENT);
		shooter.setShootMotorSpeed(0);
	}

	@Override
	public boolean isFinished() {
	return false;
	}
}

>>>>>>> 229ee79ce88c745a91bc86a7b4cf2f1bbc67aaf4

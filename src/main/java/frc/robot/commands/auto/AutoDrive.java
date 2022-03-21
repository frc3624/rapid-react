// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.auto;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Drive;

public class AutoDrive extends CommandBase {
	private final Timer timer = new Timer();
	private final Drive drive;
	public AutoDrive(Drive drive) {
		this.drive = drive;
		addRequirements(drive);
		timer.start();
	}

	@Override
	public void initialize() {}

	@Override
	public void execute() {
		if(timer.get() < 6)
			drive.arcadeDrive(.5,0);
	}

	@Override
	public void end(boolean interrupted) {}

	@Override
	public boolean isFinished() {
		return false;
	}
}


// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.shooting.tracking;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Limelight;
import frc.robot.subsystems.LazySusan;
import frc.robot.subsystems.Limelight.LedMode;

public class TrackTarget extends CommandBase {
	private final Limelight limelight;
	private final LazySusan lazySusan;
	public TrackTarget(LazySusan lazySusan, Limelight limelight) { 
		this.lazySusan = lazySusan; 
		this.limelight = limelight;
		addRequirements(lazySusan);
	}

	@Override
	public void initialize() {
		limelight.setLedMode(LedMode.ON);
	}

	@Override
	public void execute() {
		lazySusan.autoAim(limelight);
	}
	

	@Override
	public void end(boolean interrupted) {
		limelight.setLedMode(LedMode.CURRENT);
	}

	@Override
	public boolean isFinished() {
		return false;
	}
}


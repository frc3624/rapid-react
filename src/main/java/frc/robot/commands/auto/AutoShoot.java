// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.auto;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Shooter;

public class AutoShoot extends CommandBase {
	private final Shooter shooter;
	private final Timer timer = new Timer();
	public AutoShoot(Shooter shooter) {
		this.shooter = shooter;
		addRequirements(shooter);
		timer.start();
	}

	@Override
	public void initialize() {}

	@Override
	public void execute() {
		if(timer.get() > 6)
			shooter.setAutoSpeed(.5); // Fix with proper distance from measuring
	}

	@Override
	public void end(boolean interrupted) {
		shooter.setSpeedOutput(0);
	}

	@Override
	public boolean isFinished() {
		return false;
	}
}


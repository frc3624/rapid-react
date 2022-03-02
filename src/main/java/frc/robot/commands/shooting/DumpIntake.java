// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.shooting;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Intake;

public class DumpIntake extends CommandBase {
	private final Intake elevator;
	public DumpIntake(Intake elevator) {
		this.elevator = elevator;
		addRequirements(elevator);
	}

	@Override
	public void initialize() {}

	@Override
	public void execute() {
		elevator.runUpper();
	}

	@Override
	public void end(boolean interrupted) {
		elevator.runUpper(0);
	}

	@Override
	public boolean isFinished() {
		return false;
	}
}


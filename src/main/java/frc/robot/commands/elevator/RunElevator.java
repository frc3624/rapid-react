// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.elevator;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Elevator;

public class RunElevator extends CommandBase {
	private final Elevator elevator;
	public RunElevator(Elevator elevator) {
		this.elevator = elevator;
		addRequirements(elevator);
	}

	@Override
	public void initialize() {}

	@Override
	public void execute() {
		elevator.constant(0.6); // we don't know the correct numerical value yet
	}

	@Override
	public void end(boolean interrupted) {
		elevator.stopBoth();
	}

	@Override
	public boolean isFinished() {
		return false;
	}
}


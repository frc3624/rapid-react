<<<<<<< HEAD
// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.shooting;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Elevator;

public class DumpElevator extends CommandBase {
	private final Elevator elevator;
	public DumpElevator(Elevator elevator) {
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

=======
// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.shooting;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Elevator;

public class DumpElevator extends CommandBase {
	private final Elevator elevator;
	public DumpElevator(Elevator elevator) {
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

>>>>>>> 229ee79ce88c745a91bc86a7b4cf2f1bbc67aaf4

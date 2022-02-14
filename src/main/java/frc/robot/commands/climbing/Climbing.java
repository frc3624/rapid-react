// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.climbing;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Climb;

// This class is probably not going to be the only class for climbing
// This is why we have a folder for it
public class Climbing extends CommandBase {
	private final Climb climb;
	private final XboxController joystick;
	public Climbing(Climb climb, XboxController joystick) {
		this.climb = climb;
		addRequirements(climb);
		this.joystick = joystick;	
	}

	@Override
	public void initialize() {}

	@Override
	public void execute() {
		climb.run(joystick.getLeftX());
	}

	@Override
	public void end(boolean interrupted) {}

	@Override
	public boolean isFinished() {
		return false;
	}
}


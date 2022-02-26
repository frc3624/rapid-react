// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.shooting.tracking;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Limelight;
import frc.robot.subsystems.Shooter;
import frc.robot.subsystems.Limelight.LedMode;

public class TrackTarget extends CommandBase {
	private final Limelight limelight;
	private final Shooter shooter;
	private final double kPRotational = .01;
	public TrackTarget(Shooter shooter, Limelight limelight) {
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
		if (limelight.hasValidTarget()) {
			shooter.runMotor(aimToGoal());
		} else {
			shooter.runMotor(0);
		}
	}
	
	/**
	* Uses a P control loop to correct for the difference in angle between
	* the shooter and the vision targets on the field
	* @return Required Percent Output to be in line with the goal
	*/
	private double aimToGoal() {
		double error = 0 - (-limelight.getHorizontalDistance());
		if (Math.abs(error) < .1) error = 0; 
		double output = kPRotational * error;
		return output;
	}

	@Override
	public void end(boolean interrupted) {
		shooter.runMotor(0);
	}

	@Override
	public boolean isFinished() {
		return false;
	}
}


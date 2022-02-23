// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.elevator;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Elevator;

public class RunBottom extends CommandBase {
  private final Elevator elevator;
  public RunBottom(Elevator elevator) {
    this.elevator = elevator;
    addRequirements(elevator);
  }

  @Override
  public void execute() {
    elevator.runLower();
  }

  @Override
  public void end(boolean interrupted) {
		elevator.runLower(0);
  }
}

// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.ColorSensor;


public class SenseColor extends CommandBase {
  /** Creates a new DriveTrain. */
  ColorSensor colorSensor;
  public SenseColor(ColorSensor c) {
    colorSensor = c;
    addRequirements(colorSensor);
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    System.out.println("red " + (int)(colorSensor.getColor().red * 255));
    System.out.println("green " + (int)(colorSensor.getColor().green * 255));
    System.out.println("blue " + (int)(colorSensor.getColor().blue * 255));
    System.out.println(colorSensor.redOrBlue());
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
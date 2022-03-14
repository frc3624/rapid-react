// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.limelight;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Limelight;
import frc.robot.subsystems.Limelight.LimelightAngle;

public class ShootPosition extends CommandBase {
  private final Limelight limelight;
  public ShootPosition(Limelight limelight) {
    this.limelight = limelight;
  }

  @Override
  public void initialize() {
    limelight.setIntakePosition(LimelightAngle.SHOOTING_ANGLE);
  }
}

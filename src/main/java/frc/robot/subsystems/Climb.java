// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import static frc.robot.Constants.*;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Climb extends SubsystemBase {
	private final CANSparkMax climbMotor = new CANSparkMax(CLIMB_MOTOR_ID, MotorType.kBrushless);
	public Climb() {

	}
	@Override
	public void periodic() {
		// This method will be called once per scheduler run
	}
}


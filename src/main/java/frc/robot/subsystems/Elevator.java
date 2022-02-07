// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import static frc.robot.Constants.*;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Elevator extends SubsystemBase {
	// No IDs yet since they haven't been installed yet
	private static final CANSparkMax bottomMotor = new CANSparkMax(0, MotorType.kBrushless);
	private static final CANSparkMax topMotor = new CANSparkMax(0, MotorType.kBrushless);
	public Elevator() {

	}
	@Override
	public void periodic() {
		// This method will be called once per scheduler run
	}
}


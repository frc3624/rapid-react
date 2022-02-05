// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import static frc.robot.Constants.LEFT_MASTER;
import static frc.robot.Constants.LEFT_SLAVE;
import static frc.robot.Constants.RIGHT_MASTER;
import static frc.robot.Constants.RIGHT_SLAVE;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Drive extends SubsystemBase {
	private final CANSparkMax leftMaster = new CANSparkMax(LEFT_MASTER, MotorType.kBrushless);
	private final CANSparkMax leftSlave = new CANSparkMax(LEFT_SLAVE, MotorType.kBrushless);
	private final CANSparkMax rightMaster = new CANSparkMax(RIGHT_MASTER, MotorType.kBrushless);
	private final CANSparkMax rightSlave = new CANSparkMax(RIGHT_SLAVE, MotorType.kBrushless);

	private final DifferentialDrive diffDrive = new DifferentialDrive(leftMaster, rightMaster);
	public Drive() {
		rightMaster.setInverted(false); // Evo Shifter is mirrored, so invert is necessary
		rightSlave.follow(rightMaster);
		leftSlave.follow(leftMaster);
	}

	public void arcadeDrive(double xSpeed, double zRotation) {
		diffDrive.arcadeDrive(xSpeed, zRotation);
	}
}

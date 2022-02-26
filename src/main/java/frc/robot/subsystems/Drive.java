<<<<<<< HEAD
// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import static frc.robot.Constants.LEFT_MASTER;
import static frc.robot.Constants.LEFT_SLAVE;
import static frc.robot.Constants.RIGHT_MASTER;
import static frc.robot.Constants.RIGHT_SLAVE;
import static frc.robot.Constants.PCM;
import static frc.robot.Constants.GEAR_SHIFT_IN;
import static frc.robot.Constants.GEAR_SHIFT_OUT;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Drive extends SubsystemBase {
	private final CANSparkMax leftMaster = new CANSparkMax(LEFT_MASTER, MotorType.kBrushless);
	private final CANSparkMax leftSlave = new CANSparkMax(LEFT_SLAVE, MotorType.kBrushless);
	private final CANSparkMax rightMaster = new CANSparkMax(RIGHT_MASTER, MotorType.kBrushless);
	private final CANSparkMax rightSlave = new CANSparkMax(RIGHT_SLAVE, MotorType.kBrushless);
	private final DifferentialDrive diffDrive = new DifferentialDrive(leftMaster, rightMaster);

	private final DoubleSolenoid gearPiston = new DoubleSolenoid(PCM, PneumaticsModuleType.REVPH, GEAR_SHIFT_IN, GEAR_SHIFT_OUT);

	public Drive() {
		rightMaster.setInverted(true); // Evo Shifter is mirrored, so invert is necessary
		rightSlave.follow(rightMaster);
		leftSlave.follow(leftMaster);
		gearPiston.set(Value.kForward);
	}

	public void arcadeDrive(double zRotation, double xSpeed) {
		// double threshold = 0.5;
		// if(Math.sqrt(zRotation*zRotation + xSpeed + xSpeed) < threshold)
		// 	lowGear();
		// else {
		// 	System.out.println(Math.sqrt(zRotation*zRotation + xSpeed + xSpeed));
		// 	highGear();
		// }
		diffDrive.arcadeDrive(zRotation, xSpeed);
	}

	public void highGear() {
		gearPiston.set(Value.kReverse);
	}
	
	public void lowGear() {
		gearPiston.set(Value.kForward);
	}
}
=======
// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import static frc.robot.Constants.LEFT_MASTER;
import static frc.robot.Constants.LEFT_SLAVE;
import static frc.robot.Constants.RIGHT_MASTER;
import static frc.robot.Constants.RIGHT_SLAVE;
import static frc.robot.Constants.PCM;
import static frc.robot.Constants.GEAR_SHIFT_IN;
import static frc.robot.Constants.GEAR_SHIFT_OUT;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Drive extends SubsystemBase {
	private final CANSparkMax leftMaster = new CANSparkMax(LEFT_MASTER, MotorType.kBrushless);
	private final CANSparkMax leftSlave = new CANSparkMax(LEFT_SLAVE, MotorType.kBrushless);
	private final CANSparkMax rightMaster = new CANSparkMax(RIGHT_MASTER, MotorType.kBrushless);
	private final CANSparkMax rightSlave = new CANSparkMax(RIGHT_SLAVE, MotorType.kBrushless);
	private final DifferentialDrive diffDrive = new DifferentialDrive(leftMaster, rightMaster);

	private final DoubleSolenoid gearPiston = new DoubleSolenoid(PCM, PneumaticsModuleType.REVPH, GEAR_SHIFT_IN, GEAR_SHIFT_OUT);

	public Drive() {
		rightMaster.setInverted(true); // Evo Shifter is mirrored, so invert is necessary
		rightSlave.follow(rightMaster);
		leftSlave.follow(leftMaster);
		gearPiston.set(Value.kForward);
	}

	public void arcadeDrive(double zRotation, double xSpeed) {
		double threshold = 0.85;
		if(Math.sqrt(zRotation*zRotation + xSpeed + xSpeed) < threshold)
			lowGear();
		else {
			System.out.println(Math.sqrt(zRotation*zRotation + xSpeed + xSpeed));
			highGear();
		}
		diffDrive.arcadeDrive(zRotation, xSpeed);
	}

	public void highGear() {
		gearPiston.set(Value.kReverse);
	}
	
	public void lowGear() {
		gearPiston.set(Value.kForward);
	}
}
>>>>>>> 229ee79ce88c745a91bc86a7b4cf2f1bbc67aaf4

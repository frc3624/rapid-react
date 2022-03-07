// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems.drive;

import static frc.robot.Constants.GEAR_SHIFT_IN;
import static frc.robot.Constants.GEAR_SHIFT_OUT;
import static frc.robot.Constants.LEFT_MASTER;
import static frc.robot.Constants.LEFT_SLAVE;
import static frc.robot.Constants.PCM;
import static frc.robot.Constants.RIGHT_MASTER;
import static frc.robot.Constants.RIGHT_SLAVE;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Drive extends SubsystemBase {
	protected final CANSparkMax leftMaster = new CANSparkMax(LEFT_MASTER, MotorType.kBrushless);
	protected final CANSparkMax leftSlave = new CANSparkMax(LEFT_SLAVE, MotorType.kBrushless);
	protected final CANSparkMax rightMaster = new CANSparkMax(RIGHT_MASTER, MotorType.kBrushless);
	protected final CANSparkMax rightSlave = new CANSparkMax(RIGHT_SLAVE, MotorType.kBrushless);
	protected final DifferentialDrive diffDrive = new DifferentialDrive(leftMaster, rightMaster);

	protected final DoubleSolenoid gearPiston = new DoubleSolenoid(PCM, PneumaticsModuleType.REVPH, GEAR_SHIFT_IN, GEAR_SHIFT_OUT);

	public Drive() {
		rightMaster.setInverted(true); // Evo Shifter is mirrored, so invert is necessary
		rightSlave.follow(rightMaster);
		leftSlave.follow(leftMaster);
		gearPiston.set(Value.kForward);
	}

	public void arcadeDrive(double zRotation, double xSpeed) {
         double threshold = 0.5;
         if(Math.sqrt(zRotation*zRotation + xSpeed + xSpeed) < threshold)
            lowGear();
         else {
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

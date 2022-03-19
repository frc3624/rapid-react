// Copyright (c) FIRST and other WPILib contributors
// Open Source Software; you can modify and/or share it under the terms o
// the WPILib BSD license file in the root directory of this project

package frc.robot.subsystems;

import static frc.robot.Constants.GEAR_SHIFT_IN;
import static frc.robot.Constants.GEAR_SHIFT_OUT;
import static frc.robot.Constants.LEFT_MASTER;
import static frc.robot.Constants.LEFT_SLAVE;
import static frc.robot.Constants.PCM;
import static frc.robot.Constants.RIGHT_MASTER;
import static frc.robot.Constants.RIGHT_SLAVE;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMax.IdleMode;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Drive extends SubsystemBase  {
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

		leftMaster.setIdleMode(IdleMode.kBrake);
		rightMaster.setIdleMode(IdleMode.kBrake);
		leftSlave.setIdleMode(IdleMode.kBrake);
		rightSlave.setIdleMode(IdleMode.kBrake);
	}

	public void arcadeDrive(double zRotation, double xSpeed) {
		if(gearPiston.get() == Value.kReverse)
			diffDrive.arcadeDrive(.5 * zRotation, .5 * xSpeed);
		else
			diffDrive.arcadeDrive(zRotation, xSpeed);
	}

	public void toggleGear() {
		if(gearPiston.get() == Value.kForward)
			gearPiston.set(Value.kReverse);
		else if(gearPiston.get() == Value.kReverse)
			gearPiston.set(Value.kForward);
		else
			gearPiston.set(Value.kForward);
	}

	private final NavX navX = new NavX();

	public void periodic() {
		SmartDashboard.putNumber("x velocity", navX.getXVelocity());
		SmartDashboard.putNumber("y velocity", navX.getYVelocity());
		SmartDashboard.putNumber("z velocity", navX.getZVelocity());
	}
}

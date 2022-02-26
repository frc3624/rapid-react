// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.shuffleboard.ShuffleboardTab;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import static frc.robot.Constants.SHOOTER_1;
import static frc.robot.Constants.SHOOTER_2;
import static frc.robot.Constants.TURNTABLE_MOTOR;

public class Shooter extends SubsystemBase {
	private final CANSparkMax turnMotor = new CANSparkMax(TURNTABLE_MOTOR, MotorType.kBrushless);
	private final WPI_TalonFX primaryShooter = new WPI_TalonFX(SHOOTER_1);
	private final WPI_TalonFX followShooter = new WPI_TalonFX(SHOOTER_2);

	private double kP = 0;
	private double kI = 0;
	private double kD = 0;
	private double kF = 0;

	// On the fly PID Tuning
	private double rotationalVelocity = 0;
	private final ShuffleboardTab tab = Shuffleboard.getTab("Shooting");
	private final NetworkTableEntry setVelocityEntry = tab.add("Set_Velocity", 0).getEntry();
	private final NetworkTableEntry kPEntry = tab.add("kP", kP).getEntry();
	private final NetworkTableEntry kIEntry = tab.add("kI", kI).getEntry();
	private final NetworkTableEntry kDEntry = tab.add("kD", kD).getEntry();
	private final NetworkTableEntry kFEntry = tab.add("kF", kF).getEntry();
	private static final int kTimeoutMs = 30;

	public Shooter() {
		primaryShooter.configNominalOutputForward(0, kTimeoutMs);
		primaryShooter.configNominalOutputReverse(0, kTimeoutMs);
		// Sets the maximum percent output
		primaryShooter.configPeakOutputForward(1, kTimeoutMs);
		primaryShooter.configPeakOutputReverse(-1, kTimeoutMs);
	}

	public void runMotor(double rotation){
		turnMotor.set(rotation);
	}

	@Override
	public void periodic() {
	}

	private void setConstants() {
		double kP = kPEntry.getDouble(1.0);
		double kI = kIEntry.getDouble(1.0);
		double kD = kDEntry.getDouble(1.0);
		double kF = kFEntry.getDouble(1.0);
		primaryShooter.config_kP(0, kP);
		primaryShooter.config_kI(0, kI);
		primaryShooter.config_kD(0, kD);
		primaryShooter.config_kF(0, kF);
		rotationalVelocity = setVelocityEntry.getDouble(1.0);
	}


	/**
	 * Sets a desired linear speed for the shooter
	 * 
	 * Needs to have formulas and crap added to it
	 */
	public void setLinearSpeed() {
		setConstants();
	}

	/**
	 * Rudimentary shooter control based off output percentage
	 * @param speed Value [0,1]
	 */
	public void setShootMotorSpeed(double speed) {
		primaryShooter.set(ControlMode.PercentOutput, speed);
	}
}

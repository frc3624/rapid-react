// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import static frc.robot.Constants.SHOOTER_1;
import static frc.robot.Constants.SHOOTER_2;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.shuffleboard.ShuffleboardTab;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Shooter extends SubsystemBase {
	NetworkTableInstance instance = NetworkTableInstance.getDefault();
	NetworkTable table = instance.getTable("limelight");

	private final WPI_TalonFX primaryShooter = new WPI_TalonFX(SHOOTER_1);
	private final WPI_TalonFX followShooter = new WPI_TalonFX(SHOOTER_2);

	private double kP = 0.1;
	private double kI = 0;
	private double kD = 2.7;
	private double kF = 0.05;

	// On the fly PID Tuning
	private double rotationalSpeed = 0;
	private final ShuffleboardTab tab = Shuffleboard.getTab("Shooting");
	//private final NetworkTableEntry setVelocityEntry = tab.add("Set_Velocity", 0).getEntry();
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
		primaryShooter.setInverted(true);
		followShooter.follow(primaryShooter);
	}

	private void setConstants() {
		kP = kPEntry.getDouble(1.0);
		kI = kIEntry.getDouble(1.0);
		kD = kDEntry.getDouble(1.0);
		kF = kFEntry.getDouble(1.0);
		primaryShooter.config_kP(0, kP);
		primaryShooter.config_kI(0, kI);
		primaryShooter.config_kD(0, kD);
		primaryShooter.config_kF(0, kF);
		// linearSpeed = setVelocityEntry.getDouble(1.0);
	}

	/**
	 * Sets Shooter's Linear Speed based off of horizontal distance
	 *
	 * Utilizes Polynomial Regression to speed up calculations
	 */
	public void setAutoSpeed(double distance) {
		// Polynomial Regression to convert linear distance to linear speed
		// rotationalSpeed = 1.12 + 3.34*distance + 0.417*Math.pow(distance, 5) - 0.0639*Math.pow(distance, 5) + 1.93E-03*Math.pow(distance, 5) + 2.62E-04*Math.pow(distance, 5);

		// Linear Approximation avg, should test out tmrw
		// rotationalSpeed = 4316.22284375*distance + 3976.334;

		rotationalSpeed = 3526*distance + 4226;
		System.out.println(rotationalSpeed);
		primaryShooter.set(ControlMode.Velocity, rotationalSpeed);
	}

	/**
	 * Rudimentary shooter control based off output percentage
	 * @param speed Value [0,1]
	 */
	public void setSpeedOutput(double speed) {
		primaryShooter.set(ControlMode.PercentOutput, speed);
	}
	public void setManualSpeed() {
		setConstants();
		primaryShooter.set(ControlMode.Velocity, rotationalSpeed);
	}
}

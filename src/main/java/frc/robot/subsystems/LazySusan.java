// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import static frc.robot.Constants.TURNTABLE_MOTOR;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.shuffleboard.ShuffleboardTab;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class LazySusan extends SubsystemBase {
	// private final CANSparkMax turnMotor = new CANSparkMax(TURNTABLE_MOTOR, MotorType.kBrushless);

	private double kP = 0;

	// On the fly PID Tuning
	private final ShuffleboardTab tab = Shuffleboard.getTab("Lazy_Susan");
	private final NetworkTableEntry kPEntry = tab.add("kP", kP).getEntry();

	private void setConstants() {
		kP = kPEntry.getDouble(1.0);
	}

	/**
	* Uses a P control loop to correct for the difference in angle between
	* the shooter and the vision targets on the field
	* @return Required Percent Output to be in line with the goal
	*/
	private double aimToGoal(Limelight limelight) {
		double error = 0 - (-limelight.getHorizontalOffset());
		if (Math.abs(error) < .1) error = 0; 
		double output = kP * error;
		return output;
	}
	public void autoAim(Limelight limelight) {
		// if(limelight.hasValidTarget())
			// turnMotor.set(aimToGoal(limelight));
		// else
			// turnMotor.set(0);
	}
}

// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import static frc.robot.Constants.*;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Climb extends SubsystemBase {
	private final CANSparkMax climbMotor = new CANSparkMax(CLIMB_MOTOR_ID, MotorType.kBrushless);
	private final DigitalInput topLimSwitch = new DigitalInput(0);
	private final DigitalInput botLimSwitch = new DigitalInput(1);
	public Climb() {
		climbMotor.setInverted(true);
	}
	public void run(double speed) {
		climbMotor.set(speed);
	}
	public boolean isAtTop() {
		return topLimSwitch.get();
	}

	public boolean isAtBottom() {
		return botLimSwitch.get();
	}
}


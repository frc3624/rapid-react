// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import static frc.robot.Constants.CLIMB_MOTOR;
import static frc.robot.Constants.EMERGENCY_BOT;
import static frc.robot.Constants.EMERGENCY_TOP;
import static frc.robot.Constants.ROLLER_BOT;
import static frc.robot.Constants.ROLLER_TOP;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMax.IdleMode;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Climb extends SubsystemBase {
	private final CANSparkMax climbMotor = new CANSparkMax(CLIMB_MOTOR, MotorType.kBrushless);
	private final DigitalInput emergencyTopSwitch = new DigitalInput(EMERGENCY_TOP);
	private final DigitalInput emergencyBotSwitch = new DigitalInput(EMERGENCY_BOT);
	private final DigitalInput rollerTopSwitch = new DigitalInput(ROLLER_TOP);
	private final DigitalInput rollerBotSwitch = new DigitalInput(ROLLER_BOT);
	public Climb() {
		climbMotor.setInverted(true);
		// Setting, just in case it isn't set already
		climbMotor.setIdleMode(IdleMode.kBrake);
	}
	public void run(double speed) {
		climbMotor.set(speed);
	}
	
	public boolean isAtTop() {
		return rollerTopSwitch.get();
	}
	public boolean isAtBottom() {
		return rollerBotSwitch.get();
	}
	public boolean isEmergencyTop() {
		return emergencyTopSwitch.get();
	}
	public boolean isEmergencyBot() {
		return emergencyBotSwitch.get();
	}
}


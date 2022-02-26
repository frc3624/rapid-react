<<<<<<< HEAD
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
	private final CANSparkMax climbMotor = new CANSparkMax(CLIMB_MOTOR, MotorType.kBrushless);
	private final DigitalInput emergencyTopSwitch = new DigitalInput(EMERGENCY_TOP);
	private final DigitalInput emergencyBotSwitch = new DigitalInput(EMERGENCY_BOT);
	private final DigitalInput rollerTopSwitch = new DigitalInput(ROLLER_TOP);
	private final DigitalInput rollerBotSwitch = new DigitalInput(ROLLER_BOT);
	public Climb() {
		climbMotor.setInverted(true);
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

=======
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
	private final CANSparkMax climbMotor = new CANSparkMax(CLIMB_MOTOR, MotorType.kBrushless);
	private final DigitalInput topLimSwitch = new DigitalInput(UPPER_LIMIT);
	private final DigitalInput botLimSwitch = new DigitalInput(LOWER_LIMIT);
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

>>>>>>> 229ee79ce88c745a91bc86a7b4cf2f1bbc67aaf4

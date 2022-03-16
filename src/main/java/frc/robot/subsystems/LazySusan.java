// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import static frc.robot.Constants.TURNTABLE_MOTOR;
import static frc.robot.Constants.LEFT_SUSAN_LIM;
import static frc.robot.Constants.RIGHT_SUSAN_LIM;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class LazySusan extends SubsystemBase {
	private final CANSparkMax turnMotor = new CANSparkMax(TURNTABLE_MOTOR, MotorType.kBrushless);
	private final DigitalInput leftLim = new DigitalInput(LEFT_SUSAN_LIM);
	private final DigitalInput rightLim = new DigitalInput(RIGHT_SUSAN_LIM);

	public LazySusan() {
		turnMotor.setInverted(true);
	}
	
	/**
	* Uses a P control loop to correct for the difference in angle between
	* the shooter and the vision targets on the field
	* @return Required Percent Output to be in line with the goal
	*/
	public void autoAim(boolean validTarget, double tx) {
		// setConstants();
		// boolean validTarget = table.getEntry("tv").getDouble(0) == 0 ? false : true;
		if(validTarget) {
			if(tx > 1.5) {
				if(leftLim.get() || rightLim.get())
					turnMotor.set(-.1);
				else
					turnMotor.set(.1);
			} else if(tx < -1.5) {
				if(leftLim.get() || rightLim.get())
					turnMotor.set(.1);
				else
					turnMotor.set(-.1);
			} else {
				turnMotor.set(0);
			}
		}
		else {
			turnMotor.set(0);
		}
	}

	public void turn(double speed) {
		turnMotor.set(speed);
	}
}

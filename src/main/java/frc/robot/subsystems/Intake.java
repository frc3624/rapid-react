// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import static frc.robot.Constants.LOWER_INTAKE;
import static frc.robot.Constants.UPPER_INTAKE;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.revrobotics.ColorMatch;
import com.revrobotics.ColorMatchResult;
import com.revrobotics.ColorSensorV3;

import edu.wpi.first.wpilibj.I2C;
import edu.wpi.first.wpilibj.util.Color;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Intake extends SubsystemBase {
	private final WPI_TalonSRX upperElevator = new WPI_TalonSRX(UPPER_INTAKE);
	private final WPI_TalonSRX lowerElevator = new WPI_TalonSRX(LOWER_INTAKE);
	private final double ELEVATOR_SPEED = 0.5;

	// Color Stuff for Intake
	private final ColorSensorV3 colorSensor = new ColorSensorV3(I2C.Port.kOnboard);
	private final ColorMatch colorMatcher = new ColorMatch();
	private final Color red = new Color(.45068359375 , .3837890625, .165771484375); 
	private final Color airColor = new Color(.339111328125 , .47119140625, .18994140625); 
	private final Color blue = new Color(.2, .4, .37);
	private final Color allianceColor = red; // Make it red or blue

	public Intake() {
		upperElevator.setInverted(true);
		lowerElevator.setInverted(true);
		// Needed for the colors of the balls
		colorMatcher.addColorMatch(red);
		colorMatcher.addColorMatch(blue);
		colorMatcher.addColorMatch(airColor);
	}
	/**
	* Gives current color seen by the sensor
	* @return Color object for current color
	 */
	public Color getColor(){
		return colorSensor.getColor();
	}

	/**
	* Indicates if ball is from opposite alliance.
	* Used to reject the ball if it's from the opposite alliance
	* @return If ball is from opposite alliance
	 */
	public boolean isOppositeAlliance(){
		ColorMatchResult match = colorMatcher.matchClosestColor(getColor());
		if(allianceColor == red)
			return match.color == blue;
		else if(allianceColor == blue)
			return match.color == red;
		else
			return false;
	}

	/**
	* Runs the Upper Conveyor
	* @param speed Value [0,1]
	*/
	public void runUpper(double speed) {
		upperElevator.set(ControlMode.PercentOutput, speed);
	}
	/**
	* Runs the Upper Conveyor with set speed of 35%
	*/
	public void runUpper() {
		upperElevator.set(ControlMode.PercentOutput, ELEVATOR_SPEED);
	}

	/**
	* Runs the Lower Conveyor
	* @param speed Value [0,1]
	*/
	public void runLower(double speed) {
		lowerElevator.set(ControlMode.PercentOutput, speed);
	}
	/**
	* Runs the Lower Conveyor with set speed of 35%
	*/
	public void runLower() {
		if(isOppositeAlliance())
			lowerElevator.set(ControlMode.PercentOutput, -.6);
		else
			lowerElevator.set(ControlMode.PercentOutput, .6);
	}
}

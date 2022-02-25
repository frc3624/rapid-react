// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

public final class Constants {
	// Controller + Joystick IDs
	public static final int CONTROLLER_ID = 0;
	public static final int BUTTON_A = 1, BUTTON_B = 2, BUTTON_X = 3, BUTTON_Y = 4;
	public static final int BUTTON_LB = 5, BUTTON_RB = 6;
	
	// PCM ID
	public static final int PCM = 20; 
	
	// Drive IDs
	public static final int LEFT_MASTER = 1,  LEFT_SLAVE = 2, RIGHT_MASTER = 3, RIGHT_SLAVE = 4; 
	public static final int GEAR_SHIFT_IN = 0, GEAR_SHIFT_OUT = 1;		

	// Elevator IDs
	public static final int LOWER_ELEVATOR = 5, UPPER_ELEVATOR = 6;

	// Climb IDs
	public static final int CLIMB_MOTOR = 7;
	public static final int UPPER_LIMIT = 0, LOWER_LIMIT = 1;

	// Shooter Motors
	public static final int SHOOTER_1 = 8, SHOOTER_2 = 9, TURNTABLE_MOTOR = 10;
}

// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.math.kinematics.DifferentialDriveKinematics;

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

	//Calculated constants for autonomous
	/**
	 * These are calculated using the SysId tool
	 * these include various gains, which measure the amplification of the input signal
	 * the gains are needed in order to correct for errors in autonomous
	 */
	public static final double ksVolts = 0.22;
    public static final double kvVoltSecondsPerMeter = 1.98;
    public static final double kaVoltSecondsSquaredPerMeter = 0.2;
    public static final double kPDriveVel = 8.5;

	/**
	 * this class allows us to convert from the robot's speed to the wheel speeds and vice versa
	 * it takes into account track width
	 */
	public static final double kTrackwidthMeters = 0.69;
    public static final DifferentialDriveKinematics kDriveKinematics =
        new DifferentialDriveKinematics(kTrackwidthMeters);

	//Ramsete parameters for autonomous
	/**
	 * These have to do with ramsete, which executes commands involving the trajectory
	 * larger values of b make convergence more aggressive (acts as a proportional term)
	 * larger values of zeta provide more damping (decrease in amplitude of oscillation, as in PID)
	 * The following values are baseline results
	 */
	public static final double kRamseteB = 2;
    public static final double kRamseteZeta = 0.7;

	//Encoder ports (where the encoder is plugged in)
	public static final int[] kLeftEncoderPorts = {0, 0};
	public static final boolean kLeftEncoderReversed = false;

	public static final int[] kRightEncoderPorts = {0, 0};
	public static final boolean kRightEncoderReversed = false;

	/**
	 * 1 pulse = 1 cycle in the encoder
	 * the distance per pulse is measured by counting how many pulses it takes for a wheel to make one revolution
	 */
	public static final double kEncoderDistancePerPulse = 0.0;

	//autonomous constants
	/**
	 * These are needed to ensure that the robot will not accelerate to quickly
	 * the robot will also be limited by max voltage
	 * slightly below the robot's free speed
	 */
	public static final double kMaxSpeedMetersPerSecond = 0.0;
	public static final double kMaxAccelerationMetersPerSecondSquared = 0.0;
}

package frc.robot;

import edu.wpi.first.math.kinematics.DifferentialDriveKinematics;

public class FieldConstants {
    // All values are in meters, unless utilizing a conversion util
    public static final double ROBOT_HEIGHT = 1;
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

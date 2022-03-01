package frc.robot.subsystems.drive;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.math.controller.SimpleMotorFeedforward;
import edu.wpi.first.math.geometry.Pose2d;
import edu.wpi.first.math.kinematics.DifferentialDriveOdometry;
import edu.wpi.first.math.kinematics.DifferentialDriveWheelSpeeds;
import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.interfaces.Gyro;
import frc.robot.Constants;

// Autonomous Driving routine which follows a path
public class PathDrive extends Drive{
	Pose2d pose;

	public PathDrive() {
		leftEncoder.setDistancePerPulse(Constants.kEncoderDistancePerPulse);
    	rightEncoder.setDistancePerPulse(Constants.kEncoderDistancePerPulse);

		resetEncoders();
    	odometry = new DifferentialDriveOdometry(gyro.getRotation2d());
	}
	//Left drive encoder- measures rotation of wheels
	private final Encoder leftEncoder =
      new Encoder(
          Constants.kLeftEncoderPorts[0],
          Constants.kLeftEncoderPorts[1],
          Constants.kLeftEncoderReversed);

	//right drive encoder- measures rotation of wheels
  	private final Encoder rightEncoder =
      new Encoder(
          Constants.kRightEncoderPorts[0],
          Constants.kRightEncoderPorts[1],
          Constants.kRightEncoderReversed);
    
	//gyroscope measures the change in the robot's heading
	private final Gyro gyro = new ADXRS450_Gyro();

	//the odometry tracks the robot's pose 
	private final DifferentialDriveOdometry odometry;

	SimpleMotorFeedforward feedforward = new SimpleMotorFeedforward(Constants.ksVolts, Constants.kvVoltSecondsPerMeter, Constants.kaVoltSecondsSquaredPerMeter);

	//fill in with kp, ki, and kd values later
	PIDController leftPidController = new PIDController(0, 0, 0);
	PIDController rightPidController = new PIDController(0, 0, 0);
	
	public SimpleMotorFeedforward getFeedforward() {
		return feedforward;
	}

	@Override
  	public void periodic() {
    // Update the odometry in the periodic block for every main loop iteration
    	pose = odometry.update(gyro.getRotation2d(), leftEncoder.getDistance(), rightEncoder.getDistance());
  	}

	//returns current pose
	public Pose2d getPose() {
		return odometry.getPoseMeters();
	}

	//returns current wheel speeds
	public DifferentialDriveWheelSpeeds getWheelSpeeds() {
		return new DifferentialDriveWheelSpeeds(leftEncoder.getRate(), rightEncoder.getRate());
	}

	//returns current heading
	public double getHeading() {
		return gyro.getRotation2d().getDegrees();
	}

	//resets odometry to specified pose
	public void resetOdometry(Pose2d pose) {
		resetEncoders();
		odometry.resetPosition(pose, gyro.getRotation2d());
	}

	//controls motors through setting voltages
	public void tankDriveVolts(double leftVolts, double rightVolts) {
		leftMaster.setVoltage(leftVolts);
		rightMaster.setVoltage(rightVolts);
		diffDrive.feed();
	}

	//resets drive encoders to read a position of 0
	public void resetEncoders() {
		leftEncoder.reset();
		rightEncoder.reset();
	}

	//returns average of 2 encoder readings
	public double getAverageEncoderDistance() {
		return (leftEncoder.getDistance() + rightEncoder.getDistance()) / 2.0;
	}

	public Encoder getLeftEncoder() {
		return leftEncoder;
	}

	public Encoder getRightEncoder() {
		return rightEncoder;
	}

	//sets the max output of the drive, used for scaling speeds
	public void setMaxOutput(double maxOutput) {
		diffDrive.setMaxOutput(maxOutput);
	}

	//resets heading to 0
	public void zeroHeading() {
		gyro.reset();
	}

	//returns robot's current turn rate
	public double getTurnRate() {
		return -gyro.getRate();
	}

	public PIDController getLeftPidController() {
		return leftPidController;
	}

	public PIDController getRightPidController() {
		return rightPidController;
	}
}


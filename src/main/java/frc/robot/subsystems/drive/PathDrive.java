package frc.robot.subsystems.drive;

import edu.wpi.first.math.geometry.Pose2d;
import edu.wpi.first.math.kinematics.DifferentialDriveOdometry;
import edu.wpi.first.math.kinematics.DifferentialDriveWheelSpeeds;
import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.interfaces.Gyro;
import frc.robot.subsystems.NavX;

import static frc.robot.FieldConstants.*;

/**
 * Need to fix this dumpster fire
 *
 * Wrong gyro, wrong a lot of things
 * Will figure this out soon hopefully
 */
public class PathDrive extends Drive{
	public PathDrive() {
		m_leftEncoder.setDistancePerPulse(kEncoderDistancePerPulse);
    	m_rightEncoder.setDistancePerPulse(kEncoderDistancePerPulse);

		resetEncoders();
    	m_odometry = new DifferentialDriveOdometry(m_gyro.getRotation2d());
	}
	//Left drive encoder- measures rotation of wheels
	private final Encoder m_leftEncoder =
      new Encoder(
          kLeftEncoderPorts[0],
          kLeftEncoderPorts[1],
          kLeftEncoderReversed);

	//right drive encoder- measures rotation of wheels
  	private final Encoder m_rightEncoder =
      new Encoder(
          kRightEncoderPorts[0],
          kRightEncoderPorts[1],
          kRightEncoderReversed);
    
	//gyroscope measures the change in the robot's heading
	private final Gyro m_gyro = new ADXRS450_Gyro();
    private final NavX navX = new NavX();

	//the odometry tracks the robot's pose
	private final DifferentialDriveOdometry m_odometry;

	@Override
  	public void periodic() {
    // Update the odometry in the periodic block for every main loop iteration
    m_odometry.update(
        m_gyro.getRotation2d(), m_leftEncoder.getDistance(), m_rightEncoder.getDistance());
  	}

	//returns current pose
	public Pose2d getPose() {
		return m_odometry.getPoseMeters();
	}

	//returns current wheel speeds
	public DifferentialDriveWheelSpeeds getWheelSpeeds() {
		return new DifferentialDriveWheelSpeeds(m_leftEncoder.getRate(), m_rightEncoder.getRate());
	}

	//returns current heading
	public double getHeading() {
		return m_gyro.getRotation2d().getDegrees();
	}

	//resets odometry to specified pose
	public void resetOdometry(Pose2d pose) {
		resetEncoders();
		m_odometry.resetPosition(pose, m_gyro.getRotation2d());
	}

	//controls motors through setting voltages
	public void tankDriveVolts(double leftVolts, double rightVolts) {
		leftMaster.setVoltage(leftVolts);
		rightMaster.setVoltage(rightVolts);
		diffDrive.feed();
	}

	//resets drive encoders to read a position of 0
	public void resetEncoders() {
		m_leftEncoder.reset();
		m_rightEncoder.reset();
	}

	//returns average of 2 encoder readings
	public double getAverageEncoderDistance() {
		return (m_leftEncoder.getDistance() + m_rightEncoder.getDistance()) / 2.0;
	}

	public Encoder getLeftEncoder() {
		return m_leftEncoder;
	}

	public Encoder getRightEncoder() {
		return m_rightEncoder;
	}

	//sets the max output of the drive, used for scaling speeds
	public void setMaxOutput(double maxOutput) {
		diffDrive.setMaxOutput(maxOutput);
	}

	//resets heading to 0
	public void zeroHeading() {
		m_gyro.reset();
	}

	//returns robot's current turn rate
	public double getTurnRate() {
		return -m_gyro.getRate();
	}
}

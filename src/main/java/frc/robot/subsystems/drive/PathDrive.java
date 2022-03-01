package frc.robot.subsystems.drive;

import edu.wpi.first.math.geometry.Pose2d;
import edu.wpi.first.math.kinematics.DifferentialDriveOdometry;
import edu.wpi.first.math.kinematics.DifferentialDriveWheelSpeeds;
import frc.robot.subsystems.NavX;

import static frc.robot.FieldConstants.*;

import com.revrobotics.RelativeEncoder;

public class PathDrive extends Drive{
	private final RelativeEncoder leftMasterEncoder = leftMaster.getEncoder();
	private final RelativeEncoder rightMasterEncoder = rightMaster.getEncoder();

	public PathDrive() {
		leftMasterEncoder.setPositionConversionFactor(kEncoderDistancePerTick);
		rightMasterEncoder.setPositionConversionFactor(kEncoderDistancePerTick);

		resetEncoders();
    	odometry = new DifferentialDriveOdometry(navX.getRotation2d());
	}
    
	//gyroscope measures the change in the robot's heading
	private final NavX navX = new NavX();

	//the odometry tracks the robot's pose
	private final DifferentialDriveOdometry odometry;

	@Override
  	public void periodic() {
		// Update the odometry in the periodic block for every main loop iteration
		odometry.update(navX.getRotation2d(), leftMasterEncoder.getPosition(), rightMasterEncoder.getPosition());
  	}

	//returns current pose
	public Pose2d getPose() {
		return odometry.getPoseMeters();
	}

	//returns current wheel speeds
	public DifferentialDriveWheelSpeeds getWheelSpeeds() {
		return new DifferentialDriveWheelSpeeds(leftMasterEncoder.getVelocity(), rightMasterEncoder.getVelocity());
	}

	//returns current heading
	public double getHeading() {
		return navX.getRotation2d().getDegrees();
	}

	//resets odometry to specified pose
	public void resetOdometry(Pose2d pose) {
		resetEncoders();
		odometry.resetPosition(pose, navX.getRotation2d());
	}

	//controls motors through setting voltages
	public void tankDriveVolts(double leftVolts, double rightVolts) {
		leftMaster.setVoltage(leftVolts);
		rightMaster.setVoltage(rightVolts);
		diffDrive.feed();
	}

	//resets drive encoders to read a position of 0
	public void resetEncoders() {
		leftMasterEncoder.setPosition(0);
		rightMasterEncoder.setPosition(0);
	}

	//returns average of 2 encoder readings
	public double getAverageEncoderDistance() {
		return (leftMasterEncoder.getPosition() + rightMasterEncoder.getPosition()) / 2.0;
	}

	public RelativeEncoder getLeftEncoder() {
		return leftMasterEncoder;
	}

	public RelativeEncoder getRightEncoder() {
		return rightMasterEncoder;
	}

	//sets the max output of the drive, used for scaling speeds
	public void setMaxOutput(double maxOutput) {
		diffDrive.setMaxOutput(maxOutput);
	}

	//resets heading to 0
	public void zeroHeading() {
		navX.reset();
	}

	//returns robot's current turn rate
	public double getTurnRate() {
		return -navX.getRate();
	}
}

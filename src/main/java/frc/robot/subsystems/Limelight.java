package frc.robot.subsystems;

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import static frc.robot.Constants.SERVO;

public class Limelight extends SubsystemBase {
	private final NetworkTable table = NetworkTableInstance.getDefault().getTable("limelight");

	private final Servo servo = new Servo(SERVO);

	/**
	 * @return Whether or not the Limelight has any valid targets
	 */
	public boolean hasValidTarget() {
		return table.getEntry("tv").getDouble(0) == 0 ? true : false;
	}
	/**
	 * @return The horizontal displacement from where the Limelight is aimed to the target
	 */
	public double getHorizontalOffset() {
		return table.getEntry("tx").getDouble(0);
	}

	/**
	 * @return The vertical displacement from where the Limelight is aimed to the target
	 */
	public double getVerticalOffset() {
		return table.getEntry("ty").getDouble(0);
	}
	/**
	* TODO Remember to factor in Limelight angle into calculation
	* Returns the Horizontal Distance to the target
	* @param vertOffset degree measure from limelight
	* @return Distance in Meters
	 */
	public double getHorizontalDistance() {
		double goalHeightMeters = 1.524 ;
		double limelightHeightMeters = 0.8128;
		double angleToGoalRadians = getHorizontalOffset() * (Math.PI / 180.0);
		return (goalHeightMeters - limelightHeightMeters)/Math.tan(angleToGoalRadians);
	}
	/**
	 * @return The rotation of the target relative to the face of the Limelight
	 */
	public double getTargetAngle() {
		return -table.getEntry("ts").getDouble(0);
	}
	/**
	 * @return The area of the Limelight's FOV the target takes up (0.0 to 100.0 of the image)
	 */
	public double getTargetArea() {
		return table.getEntry("ta").getDouble(0);
	}


	// This enum's job is to store values for the states of the green leds on the limelight
	public enum LedMode{
		CURRENT(0),OFF(1),BLINK(2),ON(3);

		private final int value;

		private LedMode(int value) {
			this.value = value;
		}

		public int getValue() {
			return value;
		}
	}
	public void setLedMode(LedMode ledMode) {
		table.getEntry("ledMode").setNumber(ledMode.getValue());
	}

	// This enum's job is to store presets for the servo angle configuration
	public enum LimelightAngle {
		INTAKE_ANGLE(1, 25), VIEWING_ANGLE(1, 50), SHOOTING_ANGLE(0, 75);

		private final int angle;
		private final int pipelineNum;

		private LimelightAngle(int pipelineNum, int angle) {
			this.pipelineNum = pipelineNum;
			this.angle = angle;
		}
		public int getAngle() {
			return angle;
		}
		public int getPipeline() {
			return pipelineNum;
		}
	}
	private void setPipeline(int num) {
		table.getEntry("pipeline").setNumber(num);
	}
	/**
	* Set limelight's angle alongside the pipeline for each preset
	* @param limelightAngle LimelightAngle with set pipeline and angle
	 */
	public void setIntakePosition(LimelightAngle limelightAngle) {
		setPipeline(limelightAngle.getPipeline());
		servo.setAngle(limelightAngle.getAngle());
	}	
}

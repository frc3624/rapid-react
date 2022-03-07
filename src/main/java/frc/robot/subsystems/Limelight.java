package frc.robot.subsystems;

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Limelight extends SubsystemBase {
	private final NetworkTable table = NetworkTableInstance.getDefault().getTable("limelight");
	
	/**
	 * @return Whether or not the Limelight has any valid targets
	 */
	public boolean hasValidTarget() {
		return table.getEntry("tv").getDouble(0) == 0 ? true : false;
	}

	/**
	 * @return The horizontal displacement from where the Limelight is aimed to the target
	 */
	public double getHorizontalDistance() {
		return table.getEntry("tx").getDouble(0);
	}

	/**
	 * @return The vertical displacement from where the Limelight is aimed to the target
	 */
	public double getVerticalDistance() {
		return table.getEntry("ty").getDouble(0);
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

	@Override
	public void periodic() {
	}
}

// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import static frc.robot.Constants.*;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

/**
 * TODO
 * 
 * Make Documentation for "WhenUpper()" Method, and give it a more descriptive name
 */

public class Elevator extends SubsystemBase {
  private final WPI_TalonSRX upperElevator = new WPI_TalonSRX(UPPER_ID);
  private final WPI_TalonSRX lowerElevator = new WPI_TalonSRX(LOWER_ID);
  private final double ELEVATOR_SPEED = 0.4;
  private final double CURRENT_LIMIT = 5;

  public Elevator() {
		upperElevator.setInverted(true);
		lowerElevator.setInverted(true);
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
    lowerElevator.set(ControlMode.PercentOutput, ELEVATOR_SPEED);
  }
  
  /**
   * 
   */
  public void whenUpper() {
    boolean ready = false;
    ready = isAtDeadZone() && lowerElevator.getStatorCurrent() >= CURRENT_LIMIT;
    if (ready)
      runUpper();
  }

  /**
   * Checks to see if the ball is in between the bands
   * @return Whether or not the ball is at the dead zone
   */
  public boolean isAtDeadZone() {
    return lowerElevator.getStatorCurrent() < CURRENT_LIMIT;
  }

  /**
   * Runs the conveyor/intake system
   */
  public void runLowerRoutine() { 
    if(!isAtDeadZone()) {
      runLower();
    }
  }

  /**
   * Runs the motors for the elevator routine
   */
  public void run() {
    if(isAtDeadZone()){
      runUpper();
      runLowerRoutine();
    } else{
      runLowerRoutine();
    }
  }
}

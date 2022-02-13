// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Elevator extends SubsystemBase {
  private final WPI_TalonSRX upperElevator = new WPI_TalonSRX(6);
  private final WPI_TalonSRX lowerElevator = new WPI_TalonSRX(5);
  /** Creates a new Elevator. */
  public Elevator() {

  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void runUpper(double speed) {
    upperElevator.set(ControlMode.PercentOutput, speed);
  }
  public void runLower(double speed){
    lowerElevator.set(ControlMode.PercentOutput, speed);
  }
  public void whenUpper(){
    boolean ready = false;
    if (isAtDeadZone() == true && lowerElevator.getMotorOutputPercent() >= .5 )
      ready = true;
     else 
      ready  = false;
    if (ready)
      runUpper(.6);
  }
  public void stopUpper(){
    runUpper(0);
  }
  public void stopLower(){
    runLower(0);
  }
  public void stopBoth(){
    runUpper(0);
    runLower(0);
  }
 //Checks to see if the motor has a current jump. 
  public boolean hasCurrentJump(){
    if(lowerElevator.getMotorOutputPercent() < .5){
      return true;
    } else{
      return false;
    }
  }
  //Checks to see if the ball is in the deadzone 
  public boolean isAtDeadZone(){
    if(hasCurrentJump()){
      return true;
    } else{
      return false;
    }
  }
  public void runLowerRoutine(){ 
    while(!isAtDeadZone()){
      
      runLower(.6);
    }
  }
  public void run(double speed){
    if(isAtDeadZone()){
      runUpper(speed);
      runLowerRoutine();
    } else{
      runLowerRoutine();
    }
  }
  // parameter being used because we aren't sure of the correct numerical values
  public void constant(double speed){
    if(isAtDeadZone()){
      runUpper(speed);
      runLower(speed);
    } else {
      runLower(speed);
    }
  }




}

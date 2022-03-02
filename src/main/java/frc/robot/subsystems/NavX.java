// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.


package frc.robot.subsystems;

import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.math.geometry.Rotation2d;

public class NavX {
    private final AHRS ahrs = new AHRS();

    public boolean isConnected() {
        return ahrs.isConnected();
    }
    public double getAngle() {
        return ahrs.getAngle();
    }
    public double getRate() {
        return ahrs.getRate();
    }
    public boolean isRotating() {
        return ahrs.isRotating();
    }
    public float getX() {
        return ahrs.getDisplacementX();
    }
    public float getY() {
        return ahrs.getDisplacementY();
    }
    public float getXVelocity() {
        return ahrs.getVelocityX();
    }
    public float getYVelocity() {
        return ahrs.getVelocityY();
    }

    public float getZVelocity() {
      return ahrs.getVelocityZ();
    }
    
	public Rotation2d getRotation2d() {
		return ahrs.getRotation2d();
	}
	public void reset() {
		ahrs.reset();
	}
}
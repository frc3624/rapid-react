/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.kauailabs.navx.frc.AHRS;

public class NavX {
    private final AHRS ahrs = new AHRS();

    public boolean isConnected() {
        return ahrs.isConnected();
    }
    public double getAngle() {
        return ahrs.getAngle();
    }
    public double getRotationalVelocity() {
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
}

// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;
import edu.wpi.first.wpilibj.I2C;
import edu.wpi.first.wpilibj.util.Color;

import com.revrobotics.ColorMatch;
import com.revrobotics.ColorMatchResult;
import com.revrobotics.ColorSensorV3;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class ColorSensor extends SubsystemBase {
    private final ColorSensorV3 colorSensor = new ColorSensorV3(I2C.Port.kOnboard);
    private final ColorMatch colorMatcher = new ColorMatch();
    private final Color red = new Color(.45068359375 , .3837890625, .165771484375); 
    private final Color airColor = new Color(0.3271484375,0.473388671875,0.19970703125);
    private final Color farSideRed = new Color(0.33056640625, 0.45263671875, 0.217041015625);
    private final Color farSideBlue = new Color(0.27001953125, 0.46923828125, 0.26123046875);
    private final Color blue = new Color(.2, .4, .37);

    /**
     * 0.3271484375 0.473388671875 0.19970703125 

0.27001953125, 0.46923828125, 0.26123046875

     */
  public ColorSensor() {
    colorMatcher.addColorMatch(red);
    colorMatcher.addColorMatch(blue);
    colorMatcher.addColorMatch(airColor);
    colorMatcher.addColorMatch(farSideRed);
    colorMatcher.addColorMatch(farSideBlue);
  }
  public Color getColor(){
    return colorSensor.getColor();
  }

  public boolean redOrBlue(){
    // Red is true
    ColorMatchResult match = colorMatcher.matchClosestColor(getColor());
    return match.color == red || match.color == farSideRed;
  }


}
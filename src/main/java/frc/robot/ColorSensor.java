/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;


import com.analog.adis16448.frc.ADIS16448_IMU;
import com.sun.org.apache.bcel.internal.generic.I2C;
import com.sun.tools.javac.util.ByteBuffer;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.I2C;


/**
 * Add your docs here.
 */
// public class Sensors {
// public static final ADIS16448_IMU imu = new ADIS16448_IMU();

// public static double getAxis(char a){
// if(a == 'x'){
//     return imu.getAngleX();
//     }
// else if(a == 'y'){
//     return imu.getAngleX();
//     }
// else if(a == 'z'){
//     return imu.getAngleX();
//     }
// else
// return 0;
// }

public class ColorSensor{
    

    /**
     * A Rev Color Sensor V3 object is constructed with an I2C port as a 
     * parameter. The device will be automatically initialized with default 
     * parameters.
     */
    private final I2C m_colorSensor = new I2C(I2C.Port.k0nboard, 0x1e);
  

    public ColorSensor() {
      /**
       * The method GetColor() returns a normalized color value from the sensor and can be
       * useful if outputting the color to an RGB LED or similar. To
       * read the raw color, use GetRawColor().
       * 
       * The color sensor works best when within a few inches from an object in
       * well lit conditions (the built in LED is a big help here!). The farther
       * an object is the more light from the surroundings will bleed into the 
       * measurements and make it difficult to accurately determine its color.
       */
    public double getIR() {
        return 0;
    }

    public int getProximity() {
        return 0;
    }

    public Color getColor() {
        return null;
    }
           
      Color detectedColor = m_colorSensor.getColor();
  
      /**
       * The sensor returns a raw IR value of the infrared light detected.
       */
      double IR = m_colorSensor.getIR();
  
      /**
       * Open Smart Dashboard or Shuffleboard to see the color detected by the 
       * sensor.
       */
      SmartDashboard.putNumber("Red", detectedColor.red);
      SmartDashboard.putNumber("Green", detectedColor.green);
      SmartDashboard.putNumber("Blue", detectedColor.blue);
      SmartDashboard.putNumber("IR", IR);
  
      /**
       * In addition to RGB IR values, the color sensor can also return an 
       * infrared proximity value. The chip contains an IR led which will emit
       * IR pulses and measure the intensity of the return. When an object is 
       * close the value of the proximity will be large (max 2047 with default
       * settings) and will approach zero when the object is far away.
       * 
       * Proximity can be used to roughly approximate the distance of an object
       * or provide a threshold for when an object is close enough to provide
       * accurate color values.
       */
      int proximity = m_colorSensor.getProximity();
  
      SmartDashboard.putNumber("Proximity", proximity);
  
}



 






}

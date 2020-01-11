/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.commands.ControllerDrive;

/**
 * An example subsystem.  You can replace me with your own Subsystem.
 */
public class DriveTrain extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
VictorSPX motorRightFront = new VictorSPX(0);//0
VictorSPX motorLeftBack = new VictorSPX(1);//1
VictorSPX motorRightBack = new VictorSPX(2);//2
VictorSPX motorLeftFront = new VictorSPX(3);//3
  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    setDefaultCommand(new ControllerDrive());
  }
  public void setMotorLeftBack (double motorLeftBackSpeed) {
    motorLeftBack.set(ControlMode.PercentOutput, motorLeftBackSpeed);
  }
  public void setMotorLeftFront (double motorLeftFrontSpeed) {
    motorLeftFront.set(ControlMode.PercentOutput, motorLeftFrontSpeed);
  }
  public void setMotorRightBack (double motorRightBackSpeed) {
    motorRightBack.set(ControlMode.PercentOutput, motorRightBackSpeed);
  }
  public void setMotorRightFront (double motorRightFrontSpeed) {
    motorRightFront.set(ControlMode.PercentOutput, motorRightFrontSpeed);
  }
}

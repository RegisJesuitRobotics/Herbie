/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

/**
 * An example command.  You can replace me with your own command.
 */
public class AutoDrive extends Command {
  double rightFrontSpeed, rightBackSpeed, leftFrontSpeed, leftBackSpeed, time;
  public AutoDrive(double m_rightFrontSpeed, double m_rightBackSpeed, double m_leftFrontSpeed, double m_leftBackSpeed, double m_time) {
    // Use requires() here to declare subsystem dependencies
    requires(Robot.m_driveTrain);
    rightFrontSpeed = m_rightFrontSpeed;
    rightBackSpeed = m_rightBackSpeed;
    leftFrontSpeed = m_leftFrontSpeed;
    leftBackSpeed = m_leftBackSpeed;
    time = m_time;
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    for(double i = 0; i < 1; i+=0.001){
    Robot.m_driveTrain.setMotorLeftBack(leftBackSpeed * i);
    Robot.m_driveTrain.setMotorLeftFront(leftFrontSpeed * i * 1.2);
    Robot.m_driveTrain.setMotorRightBack(rightBackSpeed * i);
    Robot.m_driveTrain.setMotorRightFront(rightFrontSpeed * i);
    setTimeout(0.01);
    }
    if(time != 0){
      setTimeout(time);
    }
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    Robot.m_driveTrain.setMotorLeftBack(leftBackSpeed);
    Robot.m_driveTrain.setMotorLeftFront(leftFrontSpeed);
    Robot.m_driveTrain.setMotorRightBack(rightBackSpeed);
    Robot.m_driveTrain.setMotorRightFront(rightFrontSpeed);
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    if(time == 0){
      return false;
    }else{
      return(isTimedOut());
    }
    
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
    Robot.m_driveTrain.setMotorLeftBack(0);
    Robot.m_driveTrain.setMotorLeftFront(0);
    Robot.m_driveTrain.setMotorRightBack(0);
    Robot.m_driveTrain.setMotorRightFront(0);
    
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
  this.end();
  }
}

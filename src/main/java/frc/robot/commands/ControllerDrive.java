
package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.RobotMap;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class ControllerDrive extends Command {
  public ControllerDrive() {
   requires(Robot.m_driveTrain);
  }

  @Override
  protected void initialize() {
  }

  @Override
  protected void execute() {

    double leftSpeed = 1;
    double rightSpeed = 1;
    
    // double leftStickX = Robot.m_oi.GetDriverRawStickAxis(RobotMap.LEFT_STICK_X);
    // double LeftTrigger = Robot.m_oi.GetDriverRawTriggerAxis(RobotMap.LEFT_TRIGGER_PORT);
    // double RightTrigger = Robot.m_oi.GetDriverRawTriggerAxis(RobotMap.RIGHT_TRIGGER_PORT);
       double joystickX = Robot.m_oi.GetRawJoystickAxis(0); // right/left
       double joystickY = Robot.m_oi.GetRawJoystickAxis(1); //forward/back
       double joystickZ = Robot.m_oi.GetRawJoystickAxis(2); //turn
       boolean trigger = Robot.m_oi.GetButtonState(1);//start
    double Speed = joystickY;
    // double turn = 2 * leftStickX;
    // Speed = LeftTrigger - RightTrigger;
    double limiter;
    String move = "";
    if(trigger){
    if(joystickZ >= .9){//right
      Robot.m_driveTrain.setMotorLeftBack(leftSpeed * .2);
      Robot.m_driveTrain.setMotorRightBack(rightSpeed * .2);
      Robot.m_driveTrain.setMotorLeftFront(leftSpeed * -.2);
      Robot.m_driveTrain.setMotorRightFront(rightSpeed * .2);
    }else if(joystickZ <= -.9){//left
      Robot.m_driveTrain.setMotorLeftBack(leftSpeed * -.2);
      Robot.m_driveTrain.setMotorRightBack(rightSpeed * -.2);
      Robot.m_driveTrain.setMotorLeftFront(leftSpeed * .2);
      Robot.m_driveTrain.setMotorRightFront(rightSpeed * -.2);
    }else if (joystickX > 0.1 || joystickX < -0.1) {
      Robot.m_driveTrain.setMotorLeftBack(-joystickX *.5);
      Robot.m_driveTrain.setMotorRightBack(-joystickX *.5);
      Robot.m_driveTrain.setMotorLeftFront(-joystickX *.5);
      Robot.m_driveTrain.setMotorRightFront(joystickX *.5);
    } else {
      leftSpeed = Speed;
      rightSpeed = Speed;
      move = "Straight ";
          
    Robot.m_driveTrain.setMotorLeftBack(leftSpeed * -.2);
    Robot.m_driveTrain.setMotorRightBack(rightSpeed * .2);
    Robot.m_driveTrain.setMotorLeftFront(leftSpeed * .2);
    Robot.m_driveTrain.setMotorRightFront(rightSpeed * .2);
    }
  }else{
    Robot.m_driveTrain.setMotorLeftBack(0);
    Robot.m_driveTrain.setMotorRightBack(0);
    Robot.m_driveTrain.setMotorLeftFront(0);
    Robot.m_driveTrain.setMotorRightFront(0);
  }
    // System.out.println("Driving");

  }

  @Override
  protected boolean isFinished() {
    return false;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
    Robot.m_driveTrain.setMotorLeftBack(0);
    Robot.m_driveTrain.setMotorRightBack(0);
    Robot.m_driveTrain.setMotorLeftFront(0);
    Robot.m_driveTrain.setMotorRightFront(0);
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
    this.end();
  }
}

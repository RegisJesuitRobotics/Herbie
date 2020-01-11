
// package frc.robot.commands;

// import edu.wpi.first.wpilibj.command.Command;
// import frc.robot.Robot;
// import frc.robot.RobotMap;
// import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

// public class SlowBoi extends Command {
//   public SlowBoi() {
//    requires(Robot.m_driveTrain);
//   }

//   @Override
//   protected void initialize() {
//   }

//   @Override
//   protected void execute() {

//     double leftSpeed = 1;
//     double rightSpeed = 1;
    
//     double leftStickX = Robot.m_oi.GetDriverRawStickAxis(RobotMap.LEFT_STICK_X);
//     double LeftTrigger = Robot.m_oi.GetDriverRawTriggerAxis(RobotMap.LEFT_TRIGGER_PORT);
//     double RightTrigger = Robot.m_oi.GetDriverRawTriggerAxis(RobotMap.RIGHT_TRIGGER_PORT);
//     double Speed;
//     double turn = 2 * leftStickX;
//     Speed = LeftTrigger - RightTrigger;
//     double limiter;
//     String move = "";
//     if (leftStickX > 0.1) {

//       leftSpeed = Speed;
//       rightSpeed = Speed - (turn * Speed);
//       move = "Left Turn ";
//     } else if (leftStickX < -0.1) {

//       leftSpeed = Speed + (turn * Speed);
//       rightSpeed = Speed;
//       move = "Right Turn ";
//     } else {
//       leftSpeed = Speed;
//       rightSpeed = Speed;
//       move = "Straight ";
//     }
//     // System.out.println("Driving");

//     SmartDashboard.putNumber("RightSpeed", rightSpeed);
// 		SmartDashboard.putNumber("LeftSpeed", leftSpeed);
// 		SmartDashboard.putNumber("LeftTrigger", LeftTrigger);
// 		SmartDashboard.putNumber("RightTrigger", RightTrigger);
// 		SmartDashboard.putNumber("Speed", Speed);
// 		SmartDashboard.putNumber("effectiveY", Speed / 2);
// 		SmartDashboard.putString("move", move);
    
//     Robot.m_driveTrain.setMotorLeftBack(leftSpeed * -.2);
//     Robot.m_driveTrain.setMotorRightBack(rightSpeed * .2);
//     Robot.m_driveTrain.setMotorLeftFront(leftSpeed * .2);
//     Robot.m_driveTrain.setMotorRightFront(rightSpeed * .2);
//   }

//   @Override
//   protected boolean isFinished() {
//     return false;
//   }

//   // Called once after isFinished returns true
//   @Override
//   protected void end() {
//     Robot.m_driveTrain.setMotorLeftBack(0);
//     Robot.m_driveTrain.setMotorRightBack(0);
//     Robot.m_driveTrain.setMotorLeftFront(0);
//     Robot.m_driveTrain.setMotorRightFront(0);
//   }

//   // Called when another command which requires one or more of the same
//   // subsystems is scheduled to run
//   @Override
//   protected void interrupted() {
//     this.end();
//   }
// }

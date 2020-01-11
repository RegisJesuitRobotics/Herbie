
//This is the OI class. OI stands for operator input. Its basically where we get the input from the PS controller

package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import frc.robot.commands.AutoDrive;
// import frc.robot.commands.SlowBoi;


public class OI {

  // Joystick playstationController = new Joystick(RobotMap.DRIVER_CONTROLLER);
  // Joystick playstationController2 = new Joystick(RobotMap.DRIVER_CONTROLLER2);
     Joystick joystickController = new Joystick(RobotMap.DRIVER_CONTROLLER);
  // This is a method I have created to get information from joysticks. It
  // accesses a joystick axis directly from the controller.
  // It takes in an intager coresponding to one of the joystick axis. If you pass
  // in the ID for the right stick x axis, this will return its position as a
  // double.
  // public double GetDriverRawStickAxis(int stickAxis) {
  //   return playstationController.getRawAxis(stickAxis);
  // }

  // public double GetDriverRawTriggerAxis(int triggerAxis) {
  //   if (playstationController.getRawAxis(triggerAxis) < 0) {
  //     return 0;
  //   } else {
  //     return playstationController.getRawAxis(triggerAxis);
  //   }
  // }

  // Button buttonCircle = new JoystickButton(playstationController, RobotMap.BUTTON_CIRCLE_PORT);
  // Button buttonX = new JoystickButton(playstationController, 2);
  // Button buttonSquare = new JoystickButton(playstationController, 1);
  // Button buttonTriangle = new JoystickButton(playstationController, 4);
  // Button bumperBoi = new JoystickButton(playstationController, 5);
  // Button bumperBoi2 = new JoystickButton(playstationController, 6);

  public OI() {


// buttonSquare.whileHeld(new AutoDrive(-.4, .4, .4, .4, 0));
// buttonCircle.whileHeld(new AutoDrive(.4, -.4, -.4, -.4, 0));
// bumperBoi.whileHeld(new AutoDrive(.2, -.2, -.5, -.5, 1));
// bumperBoi2.whileHeld(new SlowBoi());



  }

public double GetRawJoystickAxis(int stickAxis) {
	return joystickController.getRawAxis(stickAxis);
}

public boolean GetButtonState(int port) {
  return joystickController.getRawButton(port);
}
  
}

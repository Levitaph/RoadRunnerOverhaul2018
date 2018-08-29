/*----------------------------------------------------------------------------*/

/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team3574.robot;

import org.usfirst.frc.team3574.robot.commands.arm.MoveArmDown;
import org.usfirst.frc.team3574.robot.commands.arm.MoveArmUp;
import org.usfirst.frc.team3574.robot.commands.arm.SetArmPosition;
import org.usfirst.frc.team3574.robot.commands.intake.Collect;
import org.usfirst.frc.team3574.robot.commands.intake.Expel;
import org.usfirst.frc.team3574.robot.commands.shooter.AnyShootKick;
import org.usfirst.frc.team3574.robot.commands.shooter.HighShootSpinUp;
import org.usfirst.frc.team3574.robot.controllerCode.TriggerButton;
import org.usfirst.frc.team3574.robot.controllerCode.POVCustomAngle;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {

	XboxController stickler = new XboxController(0);
	XboxController PidStick = new XboxController(1);
	
	static final int TRIGGER = 1;
	static final int THUMB_SIDE = 2;
	static final int THUMB_BOTTOM_LEFT = 3;
	static final int THUMB_BOTTOM_RIGHT = 4;
	static final int THUMB_TOP_LEFT = 5;
	static final int THUMB_TOP_RIGHT = 6;
	static final int SEVEN = 7;
	static final int EIGHT = 8;
	static final int NINE = 9;
	static final int TEN = 10;
	static final int ELEVEN = 11;
	static final int TWELVE = 12;
	static final int POV = 0;
	
	static final int A_BUTTON = 1;
	static final int B_BUTTON = 2;
	static final int X_BUTTON = 3;
	static final int Y_BUTTON = 4;
	static final int LEFT_BUMPER = 5;
	static final int RIGHT_BUMPER = 6;
	static final int START = 8;
	

	static final int LEFT_TRIGGER = 2;
	static final int RIGHT_TRIGGER = 3;

	/**
	 * Xbox 
	 */
	public OI() {
		/**
		 * stickler controls
		 */
		JoystickButton spinUp = new JoystickButton(stickler, A_BUTTON); 
		spinUp.whenPressed(new HighShootSpinUp());
		spinUp.whenReleased(new AnyShootKick());
		
		JoystickButton shoot =  new JoystickButton(stickler, B_BUTTON);
		shoot.whenPressed(new AnyShootKick());

		TriggerButton intake = new TriggerButton(stickler, LEFT_TRIGGER);
		intake.whileHeld(new Collect());
		
		TriggerButton outtake = new TriggerButton(stickler, RIGHT_TRIGGER);
		outtake.whenPressed(new Expel());
		 
		JoystickButton raiseIntakeArm = new JoystickButton(stickler, Y_BUTTON);
		raiseIntakeArm.whileHeld(new MoveArmUp());

		JoystickButton lowerIntakeArm = new JoystickButton(stickler, X_BUTTON);
		lowerIntakeArm.whileHeld(new MoveArmDown());
		
	/**
	 * PIDstick controls
	 */
		JoystickButton armPositionUpbadoraibu = new JoystickButton(PidStick, Y_BUTTON);
		armPositionUpbadoraibu.whenPressed(new SetArmPosition(3150));
		
		JoystickButton armPositionBoulderHeight = new JoystickButton(PidStick, X_BUTTON);
		armPositionBoulderHeight.whenPressed(new SetArmPosition(4200));
		
		JoystickButton armPositionHailHydra = new JoystickButton(PidStick, B_BUTTON);
		armPositionHailHydra.whenPressed(new SetArmPosition(3750));
		
		JoystickButton armPositionDown = new JoystickButton(PidStick, A_BUTTON);
		armPositionDown.whenPressed(new SetArmPosition(4500));
		
		POVCustomAngle moveArmDownAndStop = new POVCustomAngle(PidStick, POV, 180);
		moveArmDownAndStop.whenActive(new MoveArmDown());
		moveArmDownAndStop.whenInactive(new SetArmPosition());
		
		POVCustomAngle moveArmUpAndStop = new POVCustomAngle(PidStick, POV, 0);
		moveArmUpAndStop.whenActive(new MoveArmUp());
		moveArmUpAndStop.whenInactive(new SetArmPosition());
	}
		
		
	public double sticklerX() {
		return stickler.getRawAxis(4);
	}
	
	public double sticklerY() {
		return stickler.getRawAxis(1);
	}

	public void log() {
	
	}
}
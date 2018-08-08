/*----------------------------------------------------------------------------*/

/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team3574.robot;

import org.usfirst.frc.team3574.robot.commands.drivetrain.StopWheels;
import org.usfirst.frc.team3574.robot.commands.intake.Collect;
import org.usfirst.frc.team3574.robot.commands.intake.Expel;
import org.usfirst.frc.team3574.robot.commands.intake.MoveArmDown;
import org.usfirst.frc.team3574.robot.commands.intake.MoveArmUp;
import org.usfirst.frc.team3574.robot.commands.intake.SetArmPosition;
import org.usfirst.frc.team3574.robot.commands.shooter.AnyShootKick;
import org.usfirst.frc.team3574.robot.commands.shooter.HighShootSpinUp;
import org.usfirst.frc.team3574.robot.commands.shooter.ShooterStop;
import org.usfirst.frc.team3574.robot.controllerCode.TriggerButton;
import org.usfirst.frc.team3574.robot.controllerCode.POVDown;
import org.usfirst.frc.team3574.robot.controllerCode.POVUp;

import com.ctre.phoenix.time.StopWatch;

import Util.Log;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.buttons.Trigger;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {

//	Joystick radStick = new Joystick(0); 
	XboxController stickler = new XboxController(1);
	XboxController PidStick = new XboxController(2);
	
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
		
		POVDown armPositionHailHydra = new POVDown(PidStick, POV);
		armPositionHailHydra.whenActive(new SetArmPosition(800));
		
		POVUp armPositionDown = new POVUp(PidStick, POV);
		armPositionDown.whenActive(new SetArmPosition(800));
		
	/**
	 * Joystick controls
	 */
//		JoystickButton highShootSpinUp = new JoystickButton(radStick, THUMB_TOP_LEFT);
//		highShootSpinUp.whenPressed(new HighShootSpinUp());
//		
//		JoystickButton kick = new JoystickButton(radStick, TRIGGER);
//		kick.whenPressed(new AnyShootKick());
//		
//		radStickPOVDown collect = new radStickPOVDown(radStick, POV);
//		collect.whileActive(new Collect());
//		
//		radStickPOVUp unload = new radStickPOVUp(radStick, POV);
//		unload.whileActive(new Expel());
//		
//		JoystickButton stopDrivetrain = new JoystickButton(radStick, THUMB_BOTTOM_LEFT);
//		stopDrivetrain.whileHeld(new StopWheels());
//		
//		JoystickButton raiseIntakeArm = new JoystickButton(radStick, THUMB_TOP_RIGHT);
//		raiseIntakeArm.whileHeld(new MoveArmUp());
//
//		JoystickButton lowerIntakeArm = new JoystickButton(radStick, THUMB_BOTTOM_RIGHT);
//		lowerIntakeArm.whileHeld(new MoveArmDown());
	}
	
//	public double radStickRotation() {
//		return -radStick.getRawAxis(2);
//	}

//	public double radStickY() {
//		return radStick.getRawAxis(1);
//	}
	
	public double sticklerX() {
		return stickler.getRawAxis(4);
	}
	
	public double sticklerY() {
		return stickler.getRawAxis(1);
	}

	public void log() {
	
	}
}
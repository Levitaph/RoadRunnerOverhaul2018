package org.usfirst.frc.team3574.robot.subsystems;



import org.usfirst.frc.team3574.robot.RobotMap;
import org.usfirst.frc.team3574.robot.commands.drivetrain.DriveWithJoystick;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Drivetrain extends Subsystem {

	TalonSRX leftFrontMotor = new TalonSRX(RobotMap.leftFrontMotor);
	TalonSRX leftBackMotor = new TalonSRX(RobotMap.leftBackMotor);
	TalonSRX rightFrontMotor = new TalonSRX(RobotMap.rightFrontMotor);
	TalonSRX rightBackMotor = new TalonSRX(RobotMap.rightBackMotor);

	public double deadzone = .2;
	public Drivetrain() {
	}

	public void initDefaultCommand() {
		setDefaultCommand(new DriveWithJoystick());
	}

	public void setDriveSpeed(double leftSpeed, double rightSpeed) {
		leftFrontMotor.set(ControlMode.PercentOutput, leftSpeed);
		leftBackMotor.set(ControlMode.PercentOutput, leftSpeed);
		rightFrontMotor.set(ControlMode.PercentOutput,rightSpeed);
		rightBackMotor.set(ControlMode.PercentOutput, rightSpeed);
	}

	public void arcadeDrive(double throttle,  double turnValue) {
		throttle = valueAfterDeadzoned(throttle);
		turnValue = valueAfterDeadzoned(turnValue);	
		setDriveSpeed(throttle + turnValue * 1, turnValue + throttle * -1);
		}
	
	private double valueAfterDeadzoned (double currentValue) {
		if(currentValue > deadzone || currentValue < -deadzone) {
			return currentValue;
		}
		return 0;
	}
}


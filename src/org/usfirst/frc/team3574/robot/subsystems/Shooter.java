package org.usfirst.frc.team3574.robot.subsystems;

import org.usfirst.frc.team3574.robot.RobotMap;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import Util.Log;
import Util.Print;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Shooter extends Subsystem {

	TalonSRX shooterWheel = new TalonSRX (RobotMap.shooterMotor);
	TalonSRX hoodRotator = new TalonSRX (RobotMap.motorHoodRotatorID);
	
	public Shooter() {
	}
	
	public void shoot(double shooterSpeed) {
		shooterWheel.set(ControlMode.PercentOutput, -shooterSpeed);
	}
	
	public void stop() {
		shooterWheel.set(ControlMode.PercentOutput, 0.0);
	}
	
	public void log() {
		Log.aNumber("WheelSpeed", shooterWheel.getMotorOutputPercent());
	}
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}
	


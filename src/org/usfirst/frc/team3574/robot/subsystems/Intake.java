package org.usfirst.frc.team3574.robot.subsystems;

import org.usfirst.frc.team3574.robot.RobotMap;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import Util.Log;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Intake extends Subsystem {

	TalonSRX rollers = new TalonSRX(RobotMap.intakeRollersMotor);
	TalonSRX wheels = new TalonSRX(RobotMap.intakeWheelsMotor);
	
	DigitalInput boulderInIntake = new DigitalInput(0);	

	public Intake() {
	}
    
	public void initDefaultCommand() { 
    }
    
    public void rollerAndWheelsIn() {
    	rollers.set(ControlMode.PercentOutput, 0.7);
    	wheels.set(ControlMode.PercentOutput, -0.5);
    }
    
    public void rollerAndWheelsOut() {
    	rollers.set(ControlMode.PercentOutput, -1.0);
    	wheels.set(ControlMode.PercentOutput,  0.5);
    }
    
    public void feedShooter() {	
    	wheels.set(ControlMode.PercentOutput, -1.0);
    }
    
    public void lowShoot() {	
    	wheels.set(ControlMode.PercentOutput, 1);
    }
    
    public void stopIntake() {	
    	wheels.set(ControlMode.PercentOutput, 0);
    	rollers.set(ControlMode.PercentOutput, 0);
    }
    
    public boolean intakeFull() {	
    	return boulderInIntake.get();
     }
}
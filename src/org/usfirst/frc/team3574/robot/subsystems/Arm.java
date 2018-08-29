package org.usfirst.frc.team3574.robot.subsystems;

import org.usfirst.frc.team3574.robot.RobotMap;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import Util.Log;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Arm extends Subsystem {

	public int ARM_ZERO_POINT;

	TalonSRX position = new TalonSRX(RobotMap.intakePositionMotor);
	TalonSRX position2 = new TalonSRX(RobotMap.intakePositionMotor2);

	public Arm() {
		position2.set(ControlMode.Follower, 11);
//		position.configForwardLimitSwitchSource(Intake3, false, 10);		

	}
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public void setIntakePosition(double setPoint) {
    	position.set(ControlMode.Position, setPoint + ARM_ZERO_POINT);
    }
    
    public void setArmPositionWithPID(double setPoint) {
    	
    }
    
    public void setArmSpeed(double speed) {
    	position.set(ControlMode.PercentOutput, speed);
    }
    
    public int getPositionEncoderValue() {
    	return position.getSensorCollection().getPulseWidthPosition();
    }
    
    public void zeroEncoder() {
    	ARM_ZERO_POINT = position.getSensorCollection().getPulseWidthPosition();
    }
    
    public boolean isLowlimitSwitchClicked() {
    	return 	position.getSensorCollection().isFwdLimitSwitchClosed();
    }

    public void log() {
    	Log.sDashABoolean("Arm Lower Limit Switch Status", isLowlimitSwitchClicked());
    	Log.sDashANumber("Arms Position Ticks", position.getSensorCollection().getPulseWidthPosition());
    	Log.sDashANumber("Closed Loop Error", position.getClosedLoopError(0));
    }
}
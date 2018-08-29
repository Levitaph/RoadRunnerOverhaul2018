package org.usfirst.frc.team3574.robot.commands.arm;

import org.usfirst.frc.team3574.robot.Robot;
import org.usfirst.frc.team3574.robot.subsystems.Intake;

import Util.PidPDRVer;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class SetArmPosition extends Command {

	int _ticksPosition;
	boolean stoppingInPlace;
	
    public SetArmPosition(int ticksPosition) {
        requires(Robot.arm);
        _ticksPosition = ticksPosition;
        stoppingInPlace = false;
    }
    
    public SetArmPosition() {
        requires(Robot.arm);
        stoppingInPlace = true;
    }


    // Called just before this Command runs the first time
    protected void initialize() {
    	if(stoppingInPlace) {
    		_ticksPosition = Robot.arm.getPositionEncoderValue();
    	}
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.Pid.setArmPositionPID(_ticksPosition);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
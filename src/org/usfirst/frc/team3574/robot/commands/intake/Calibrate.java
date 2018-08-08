package org.usfirst.frc.team3574.robot.commands.intake;

import org.usfirst.frc.team3574.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class Calibrate extends Command {

	boolean isDone;
	
    public Calibrate() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	
    	
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	
    	if (!Robot.intake.isLowlimitSwitchClicked()){
			Robot.intake.lowerIntakeArms(0.2);
		} else {
//			//alpha
			Robot.intake.calibratePositionToCurrentPos(1607 -85);
			Robot.intake.positionMotorSimple(1607 - 85);
			//beta
//			Robot.intake.calibratePositionToCurrentPos(1583);
//			Robot.intake.positionMotorSimple(1583);
			
//			Robot.intake.calibratePositionToCurrentPos(1510);
//			Robot.intake.positionMotorSimple(1510);
			isDone = true;
		}
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

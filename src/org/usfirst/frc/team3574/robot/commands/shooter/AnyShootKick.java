package org.usfirst.frc.team3574.robot.commands.shooter;

import org.usfirst.frc.team3574.robot.Robot;
import org.usfirst.frc.team3574.robot.RobotMap;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class AnyShootKick extends Command {

	double timeToRun = .5;
			
    public AnyShootKick() {
    	requires(Robot.shooter);   
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    		Robot.intake.feedShooter();
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	if(timeSinceInitialized() > timeToRun) {
    		System.out.println("AnyShootKick True " + timeSinceInitialized());
    		Robot.intake.stopIntake();
    		Robot.shooter.stop();
    		return true;
    	} else {
    		System.out.println("AnyShootKick False " + timeSinceInitialized());
    		return false;
    	}
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}

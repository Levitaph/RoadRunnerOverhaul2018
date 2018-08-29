package Util;

import org.usfirst.frc.team3574.robot.Robot;

public class PidPDRVer {
	double P = .9, 
			   I = 0.015, 
			   D = 0;
    double derivative, error, integral, previous_error = 0;
    
    public double PID(double ticksPosition){
        error = 0;
    	error = ticksPosition - Robot.arm.getPositionEncoderValue(); // Error = Target - Actual
        integral += (error*.02); // Integral is increased by the error*time (which is .02 seconds using normal IterativeRobot)
        derivative = (error - previous_error) / .02;
        previous_error = error;
        return ((P*error + I*integral + D*derivative) * 0.001);
    }
    
    public void setArmPositionPID(double ticksPosition) {
    	logSAPOutput(PID(ticksPosition));
    	Robot.arm.setArmSpeed(PID(ticksPosition));
    }
    
    public void logSAPOutput(double output){
    	Log.sDashANumber("Output", output);
    	Log.sDashANumber("Error", error);
    }
}
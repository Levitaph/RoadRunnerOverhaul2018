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

	/**
	 * Which PID slot to pull gains from. Starting 2018, you can choose from
	 * 0,1,2 or 3. Only the first two (0,1) are visible in web-based
	 * configuration.
	 */
	final int kSlotIdx = 0;

	/*
	 * Talon SRX/ Victor SPX will supported multiple (cascaded) PID loops. For
	 * now we just want the primary one.
	 */
	final int kPIDLoopIdx = 0;

	/*
	 * set to zero to skip waiting for confirmation, set to nonzero to wait and
	 * report to DS if action fails.
	 */
	final int kTimeoutMs = 30;
	
	/* choose so that Talon does not report sensor out of phase */
	boolean kSensorPhase = true;

	/* choose based on what direction you want to be positive,
		this does not affect motor invert. */
	boolean kMotorInvert = false;
	
	TalonSRX rollers = new TalonSRX(RobotMap.intakeRollersMotor);
	TalonSRX position = new TalonSRX(RobotMap.intakePositionMotor);
	TalonSRX position2 = new TalonSRX(RobotMap.intakePositionMotor2);
	TalonSRX wheels = new TalonSRX(RobotMap.intakeWheelsMotor);
	
	DigitalInput boulderInIntake = new DigitalInput(0);
	/**
	 * Limit switch things, test at shop.
	 */
//	boolean Test = position.get 
	

	public Intake() {
		position2.set(ControlMode.Follower, 11);
		prepareForPID(position);
		prepareForPID(position2);
//		position.configForwardLimitSwitchSource(Intake3, false, 10);		
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
    
    public void setIntakePosition(double setPositionEncoder) {
    	position.set(ControlMode.Position, -setPositionEncoder);
    }
    
    public void lowerIntakeArms(double speed) {
    	position.set(ControlMode.PercentOutput, speed);
    }
    
    public void raiseIntakeArms(double speed) {	
    	position.set(ControlMode.PercentOutput, speed);
    }
    
    public void positionMotorSimple(double setpoint) {	
    	//TODO: Check if tormenta has encoders and if they are working
    }
    
    public void setPositionArmsManually(double posIsDown) {	
    	position.set(ControlMode.Position, posIsDown);
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
    
    public void calibratePositionToCurrentPos(int newEncPosition) {
    	position.set(ControlMode.Position, newEncPosition);
    }
    
    public int positionEncoderValue() {
    	return position.getSensorCollection().getPulseWidthPosition();
    }
    
    public boolean isLowlimitSwitchClicked() {
    	return boulderInIntake.get();  //for now //TODO: Fix this
    }
    
    public void log() {
    	Log.aNumber("Arms Position Ticks", position.getSensorCollection().getPulseWidthPosition());
    }

    public void prepareForPID(TalonSRX talonToPrep) {
		/* choose the sensor and sensor direction */
		talonToPrep.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative, kPIDLoopIdx, kTimeoutMs);

		/* choose to ensure sensor is positive when output is positive */
		talonToPrep.setSensorPhase(kSensorPhase);

		/* choose based on what direction you want forward/positive to be.
		 * This does not affect sensor phase. */ 
		talonToPrep.setInverted(kMotorInvert);

		/* set the peak and nominal outputs, 12V means full */
		talonToPrep.configNominalOutputForward(0, kTimeoutMs);
		talonToPrep.configNominalOutputReverse(0, kTimeoutMs);
		talonToPrep.configPeakOutputForward(1, kTimeoutMs);
		talonToPrep.configPeakOutputReverse(-1, kTimeoutMs);
		/*
		 * set the allowable closed-loop error, Closed-Loop output will be
		 * neutral within this range. See Table in Section 17.2.1 for native
		 * units per rotation.
		 */
		talonToPrep.configAllowableClosedloopError(0, kPIDLoopIdx, kTimeoutMs);
		
		/* set closed loop gains in slot0, typically kF stays zero. */
		talonToPrep.config_kF(kPIDLoopIdx, 0.0, kTimeoutMs);
		talonToPrep.config_kP(kPIDLoopIdx, 0.1, kTimeoutMs);
		talonToPrep.config_kI(kPIDLoopIdx, 0.0, kTimeoutMs);
		talonToPrep.config_kD(kPIDLoopIdx, 0.0, kTimeoutMs);
		
		/*
		 * lets grab the 360 degree position of the MagEncoder's absolute
		 * position, and intitally set the relative sensor to match.
		 */
		int absolutePosition = talonToPrep.getSensorCollection().getPulseWidthPosition();
		/* mask out overflows, keep bottom 12 bits */
		absolutePosition &= 0xFFF;
		if (kSensorPhase)
			absolutePosition *= -1;
		if (kMotorInvert)
			absolutePosition *= -1;
		/* set the quadrature (relative) sensor to match absolute */
		talonToPrep.setSelectedSensorPosition(absolutePosition, kPIDLoopIdx, kTimeoutMs);
    }
}
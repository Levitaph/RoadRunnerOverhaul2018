package org.usfirst.frc.team3574.robot.controllerCode;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.buttons.Trigger;

/**
 *
 */
public class POVCustomAngle extends Trigger {
	GenericHID _jojostick;
	int _POV;
	int yeeOV;

	public POVCustomAngle(GenericHID joystick, int pov, int povTarget) {
		_jojostick = joystick;
		_POV = pov;
		yeeOV = povTarget;
	}

    public boolean get() {
		if (_jojostick.getPOV(_POV) == yeeOV) {
			return true;
		} 
		else {
			return false;
		}
    }
}
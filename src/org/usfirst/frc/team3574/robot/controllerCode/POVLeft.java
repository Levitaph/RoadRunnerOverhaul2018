package org.usfirst.frc.team3574.robot.controllerCode;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.buttons.Trigger;

/**
 *
 */
public class POVLeft extends Trigger {

	GenericHID m_joystick;
	int m_POV;

	public POVLeft(GenericHID joystick, int pov) {
		m_joystick = joystick;
		m_POV = pov;
	}

    public boolean get() {
		if (m_joystick.getPOV(m_POV) == 270) {
			return true;
		} 
		else {
			return false;
		}
    }
}

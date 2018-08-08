package Util;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Log {
	public static void aString(String name, String input) {
		SmartDashboard.putString(name, input);
	}
	
	public static void aNumber(String name, double input) {
		SmartDashboard.putNumber(name, input);
	}
	
	public static void aBoolean(String name, boolean input) {
		SmartDashboard.putBoolean(name, input);
	}
}

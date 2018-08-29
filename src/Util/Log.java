package Util;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Log {
	public static void sDashAString(String name, String input) {
		SmartDashboard.putString(name, input);
	}
	
	public static void sDashANumber(String name, double input) {
		SmartDashboard.putNumber(name, input);
	}
	
	public static void sDashABoolean(String name, boolean input) {
		SmartDashboard.putBoolean(name, input);
	}
	
	public static void conAString(String input) {
		System.out.println(input);
	}
	
	public static void conADouble(double input) {
		System.out.println(input);
	}
	
	public static void conABoolean(boolean input) {
		System.out.println(input);
	}
}
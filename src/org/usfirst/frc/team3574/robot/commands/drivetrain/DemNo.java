package org.usfirst.frc.team3574.robot.commands.drivetrain;

public class DemNo {
	private boolean visitorsAreNearMe,
		atDemo;
	private int dabCount,
		uselessProjectsCompleted;

	public DemNo() {
		dabCount  = 0;
		atDemo = true;
		watDo();
	}

	private void watDo() {
		while(atDemo) {
			if(visitorsAreNearMe) {
				beUseful();
			}
			else {
				beABigMeme();
			}
		}
	}

	public void beABigMeme() {
		dab();
	}

	private void dab() {
		dabCount++;
	}

	private void beUseful() {
		uselessProjectsCompleted++;
	}
}

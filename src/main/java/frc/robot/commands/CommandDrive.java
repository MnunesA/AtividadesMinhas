package frc.robot.commands;

import frc.robot.subsystems.SubsystemJoystick;
import frc.robot.Robot;
import edu.wpi.first.wpilibj.command.*;

public class CommandDrive extends Command {
    double arcadeSpeed;
	double arcadeRotation;
	public static boolean sts;

	public static final double minR = 0.4D, difR = 0.5D;

	public CommandDrive(boolean status) {
		super(Robot.driver);
		sts = status;
	}

	@Override
	protected void execute() {
		if (sts == true) {
		this.arcadeRotation = - SubsystemJoystick.axis_d_LY.get();
		this.arcadeSpeed =  SubsystemJoystick.axis_d_RX.get();
		this.arcadeDrive(this.arcadeRotation, this.arcadeSpeed);
		} else if (sts == false) {
		this.arcadeRotation = SubsystemJoystick.axis_d_LY.get();
		this.arcadeSpeed =  - SubsystemJoystick.axis_d_RX.get();
		this.arcadeDrive(this.arcadeRotation, this.arcadeSpeed);
		}
	}

	@Override
	protected boolean isFinished() {
		return false;
	}

	public void arcadeDrive(double speed, double rotation) {
		double modifier = minR + difR * Math.pow(1 - Math.abs(speed), 2);
		double rate = Math.pow(rotation, 3) * modifier;
		Robot.driver.tankDrive(0.4 * (speed - rotation) , -0.4 * (speed + rotation));
	}

	@Override
	protected void end() {
	}
}

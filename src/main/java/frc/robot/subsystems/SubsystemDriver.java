package frc.robot.subsystems;

import static frc.robot.RobotMap.DRIVE_MOTOR_FL_ID;
import static frc.robot.RobotMap.DRIVE_MOTOR_FR_ID;
import static frc.robot.RobotMap.DRIVE_MOTOR_RL_ID;
import static frc.robot.RobotMap.DRIVE_MOTOR_RR_ID;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import frc.robot.Robot;
import frc.robot.commands.CommandDrive;

public class SubsystemDriver extends Subsystem {

	private TalonSRX motorLeftMaster = new TalonSRX(0);
	private TalonSRX motorLeftSlave = new TalonSRX(2);
	private TalonSRX motorRightMaster = new TalonSRX(3);
	private TalonSRX motorRightSlave = new TalonSRX(1);
	/*
    private VictorSP motorFrontLeft = new VictorSP(DRIVE_MOTOR_FL_ID);
	private VictorSP motorRearLeft = new VictorSP(DRIVE_MOTOR_RL_ID);
	private VictorSP motorFrontRight = new VictorSP(DRIVE_MOTOR_FR_ID);
	private VictorSP motorRearRight = new VictorSP(DRIVE_MOTOR_RR_ID);

	SpeedControllerGroup motorRight = new SpeedControllerGroup(motorFrontRight, motorRearRight);
	SpeedControllerGroup motorLeft = new SpeedControllerGroup(motorFrontLeft, motorRearLeft);
    DifferentialDrive driveTrain = new DifferentialDrive(motorRight, motorLeft);
	*/
	
	@Override
	public void initDefaultCommand() {
		Robot.driver.setDefaultCommand(new CommandDrive(CommandDrive.sts));
	}

	public SubsystemDriver() {
		super();
	}

	public void tankDrive(double leftSpeed, double rightSpeed) {
		this.motorLeftMaster.set(ControlMode.PercentOutput, leftSpeed);
		this.motorRightMaster.set(ControlMode.PercentOutput, rightSpeed);
		this.motorLeftSlave.follow(motorLeftMaster);
		this.motorRightSlave.follow(motorRightMaster);
	}
	/*
    public void tankDrive(double leftSpeed, double rightSpeed) {
		driveTrain.tankDrive(leftSpeed, rightSpeed);
	}

	public void driveTrainLeft(double leftSpeed) {
		this.motorLeft.set(leftSpeed);
	}

	public void arcadeDrive(double speed, double heading) {
		driveTrain.arcadeDrive(speed, heading);
	}

	public void driveTrainRight(double rightSpeed) {
		this.motorLeft.set(rightSpeed);
	}
	*/
}

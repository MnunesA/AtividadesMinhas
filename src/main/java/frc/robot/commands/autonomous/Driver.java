package frc.robot.commands.autonomous;

import frc.robot.Robot;
import edu.wpi.first.wpilibj.command.*;
import frc.robot.subsystems.SubsystemDriver;

public class Driver extends Command {

  double tm;
  double speedMotorsLf;
  double speedMotorsRg;

  public Driver(double speedMotorsLeft, double speedMotorsRight, double time) {
    super(Robot.driver);
    this.tm = time;
    this.speedMotorsLf = speedMotorsLeft;
    this.speedMotorsRg = speedMotorsRight;
  }

  @Override
  public void initialize() {
    setTimeout(tm);
  }

  @Override
  protected void execute() {
    Robot.driver.tankDrive(speedMotorsLf, speedMotorsRg);
  }

  @Override
  protected boolean isFinished() {
    return isTimedOut();
  }

  @Override
  protected void end() {
    Robot.driver.tankDrive(0.0, 0.0);
  }

  @Override
  protected void interrupted() {
    Robot.driver.tankDrive(0.0, 0.0);
  }
}
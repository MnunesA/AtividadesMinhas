/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class CommandIntakeCargoDown extends Command {

  boolean status = false;

  public CommandIntakeCargoDown() {
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    setTimeout(1.5);
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    if (timeSinceInitialized() > 0.9 && timeSinceInitialized() < 1.1) {
      if (Robot.intakeCargo.getIntakeCargo() > 0) {
        Robot.intakeCargo.intakeCargoDown(0.25);
      } else if (Robot.intakeCargo.getIntakeCargo() < 0) {
      Robot.intakeCargo.intakeCargoDown(-0.25);
    }
   }
  }
  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return isTimedOut();
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
    Robot.intakeCargo.stop();
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
  }
}

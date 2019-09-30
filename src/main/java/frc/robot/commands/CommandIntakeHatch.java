/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class CommandIntakeHatch extends Command {

  double speed;

  public CommandIntakeHatch(double sp) {
    super(Robot.intakeHatch);
   this.speed = sp;
  }

  @Override
  protected void initialize() {
  }

  @Override
  protected void execute() {
      Robot.intakeHatch.intakeUp(this.speed);
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
   return false;
  }
  
  // Called once after isFinished returns true
  @Override
  protected void end() {
    Robot.intakeHatch.intakeUp(0.0);
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
    Robot.intakeHatch.intakeUp(0.0);
  }
}
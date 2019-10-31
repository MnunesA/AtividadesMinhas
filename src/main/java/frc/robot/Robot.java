package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.subsystems.SubsystemDriver;
import frc.robot.subsystems.SubsystemJoystick;
import frc.robot.commands.CommandDrive;
import frc.robot.commands.autonomous.*;

public class Robot extends TimedRobot {
  public static SubsystemDriver driver = new SubsystemDriver();
  public static SubsystemJoystick joystick = new SubsystemJoystick();
  public static OI m_oi;
  CommandGroup r_autonomousCommand;
  CommandGroup b_autonomousCommand;
  private int number;
  /**
   * This function is run when the robot is first started up and should be
   * used for any initialization code.
   */
  @Override
  public void robotInit() {
    m_oi = new OI();
    //m_chooser.setDefaultOption("Default Auto", new ExampleCommand());
    // chooser.addOption("My Auto", new MyAutoCommand());
    
  }

  /**
   * This function is called every robot packet, no matter the mode. Use
   * this for items like diagnostics that you want ran during disabled,
   * autonomous, teleoperated and test.
   *
   * <p>This runs after the mode specific periodic functions, but before
   * LiveWindow and SmartDashboard integrated updating.
   */
  @Override
  public void robotPeriodic() {
  }

  /**
   * This function is called once each time the robot enters Disabled mode.
   * You can use it to reset any subsystem information you want to clear when
   * the robot is disabled.
   */
  @Override
  public void disabledInit() {
  }

  @Override
  public void disabledPeriodic() {
    Scheduler.getInstance().run();
  }

  /**
   * This autonomous (along with the chooser code above) shows how to select
   * between different autonomous modes using the dashboard. The sendable
   * chooser code works with the Java SmartDashboard. If you prefer the
   * LabVIEW Dashboard, remove all of the chooser code and uncomment the
   * getString code to get the auto name from the text box below the Gyro
   *
   * <p>You can add additional auto modes by adding additional commands to the
   * chooser code above (like the commented example) or additional comparisons
   * to the switch structure below with additional strings & commands.
   */
  @Override
  public void autonomousInit() {
    int av = (int) SmartDashboard.getNumber("Autonomous Version", 9);
    
    this.number = av;

    SmartDashboard.putNumber("Autonomous Version", this.number);
    
    b_autonomousCommand = new Position_Blue(this.number);

    r_autonomousCommand = new Position_Red(this.number);
    
    // schedule the autonomous command (example)
     if (b_autonomousCommand != null || r_autonomousCommand != null)
      if (this.number >= 0 && this.number < 4) {
      r_autonomousCommand.start();
      } else if (this.number > 3 && this.number <= 9) {
      b_autonomousCommand.start();
      }
  }

  /**
   * This function is called periodically during autonomous.
   */
  @Override
  public void autonomousPeriodic() {
    Scheduler.getInstance().run();
  }

  @Override
  public void teleopInit() {
    if (b_autonomousCommand != null || r_autonomousCommand != null)
      if (this.number >= 0 && this.number < 4) {
      r_autonomousCommand.cancel();
      } else if (this.number > 3 && this.number <= 9) {
      b_autonomousCommand.cancel();
      }
    CommandDrive.sts = true;
  }

  /**
   * This function is called periodically during operator control.
   */
  @Override
  public void teleopPeriodic() {
    Scheduler.getInstance().run();
  }

  /**
   * This function is called periodically during test mode.
   */
  @Override
  public void testPeriodic() {
  }
}

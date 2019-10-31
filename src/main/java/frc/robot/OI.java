package frc.robot;

import frc.robot.Robot;
import frc.robot.subsystems.SubsystemJoystick;
import frc.robot.commands.*;

public class OI {
    public OI(){
    Robot.joystick.toggleWhenPressed(SubsystemJoystick.d_B, new CommandDrive(true));
    Robot.joystick.toggleWhenPressed(SubsystemJoystick.d_B, new CommandDrive(false));
    }
}

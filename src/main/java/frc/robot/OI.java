package frc.robot;

import frc.robot.Robot;
import frc.robot.subsystems.SubsystemJoystick;
import frc.robot.commands.*;

public class OI {
    public OI(){
        Robot.joystick.whenHeld(SubsystemJoystick.d_RT, new CommandIntakeCargo(0.5));
        Robot.joystick.whenHeld(SubsystemJoystick.d_LT, new CommandIntakeCargo(-0.5));
        Robot.joystick.whenReleased(SubsystemJoystick.d_RT, new CommandIntakeCargoDown());
        Robot.joystick.whenReleased(SubsystemJoystick.d_LT, new CommandIntakeCargoDown());
        Robot.joystick.whenPressed(SubsystemJoystick.d_LB, new CommandIntakeHatch());
    }
}

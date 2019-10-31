package frc.robot.commands.autonomous;

import frc.robot.Robot;
import edu.wpi.first.wpilibj.command.*;
import frc.robot.subsystems.SubsystemDriver;
import edu.wpi.first.wpilibj.command.CommandGroup;

public class Position_Red extends CommandGroup {

  public Position_Red(int autonomousNumber) {
    if (autonomousNumber == 0) {
      /* Estratégia 0: Vai até a lateral da Rocket mais próxima. Posicão 1 */
      addSequential(new Driver(0.7, 0.7, 2.2));
      addSequential(new Driver(-0.6, 0.6, 0.4));
      addSequential(new Driver(0.7, 0.7, 1.286));
      addSequential(new Driver(0.5, -0.5, 0.235));
    } else if (autonomousNumber == 1) {
      /* Estratégia 1: Vai até a CargoShip lateral mais próxima. Posição 1 */
      addSequential(new Driver(0.7, 0.7, 3.343));
      addSequential(new Driver(0.6, -0.6, 0.4));
    } else if (autonomousNumber == 2) {
      /* Estratégia 2: Vai até a CargoShip lateral mais próxima. Posição 3 */
      addSequential(new Driver(0.7, 0.7, 2.8));
      addSequential(new Driver(-0.6, 0.6, 0.4));
    } else if (autonomousNumber == 3) {
      // Estratégia 3: Vai até a CargoShip frontal. Posição 3
      addSequential(new Driver(0.7, 0.7, 2.2));
      addSequential(new Driver(-0.6, 0.6, 0.4));
      addSequential(new Driver(0.5, 0.5, 0.6));
      addSequential(new Driver(0.6, -0.6, 0.4));
    }
  }
}
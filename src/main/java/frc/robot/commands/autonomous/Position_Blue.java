package frc.robot.commands.autonomous;

import edu.wpi.first.wpilibj.command.*;
import edu.wpi.first.wpilibj.command.CommandGroup;
import frc.robot.Robot;
import frc.robot.commands.autonomous.Driver;
import frc.robot.subsystems.SubsystemDriver;

public class Position_Blue extends CommandGroup {

  public Position_Blue(int autonomousNumber) {
    if (autonomousNumber == 4) {
      /* Estratégia 4: Vai até a lateral da Rocket mais próxima. Posição 1 */
      addSequential(new Driver(0.7, 0.7, 2.2));
      addSequential(new Driver(0.6, -0.6, 0.4));
      addSequential(new Driver(0.7, 0.7, 1.286));
      addSequential(new Driver(-0.5, 0.5, 0.235));
    } else if (autonomousNumber == 5) {
      /* Estratégia 5: Vai até a CargoShip lateral mais próxima. Posição 1 */
      addSequential(new Driver(0.7, 0.7, 3.343));
      addSequential(new Driver(-0.6, 0.6, 0.4));
    } else if (autonomousNumber == 6) {
      /* Estratégia 6: Vai até a CargoShip lateral mais próxima. Posição 3 */
      addSequential(new Driver(0.7, 0.7, 3.343));
      addSequential(new Driver(0.7, -0.7, 0.4));
    } else if (autonomousNumber == 7) {
      // Estratégia 7: Vai até a CargoShip frontal. Posição 3
      addSequential(new Driver(0.7, 0.7, 2.2));
      addSequential(new Driver(0.6, -0.6, 0.4));
      addSequential(new Driver(0.5, 0.5, 0.6));
      addSequential(new Driver(-0.6, 0.6, 0.4));
    } else if (autonomousNumber == 8) {
    // Estratégia 8: Teste.
    addSequential(new Driver(0.7, 0.7, 5));
    addSequential(new Driver(0.6, -0.6, 2));
    addSequential(new Driver(0.5, 0.5, 2));
    addSequential(new Driver(-0.7, 0.7, 4));
    } else {
      addSequential(new Driver(0.0, 0.0, 15));
    }
  }
}

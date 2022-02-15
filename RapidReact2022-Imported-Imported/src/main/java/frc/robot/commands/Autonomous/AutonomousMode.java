// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.Autonomous;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.commands.TurnInPlace;
import frc.robot.subsystems.DriveTrain;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/stable/docs/software/commandbased/convenience-features.html
public class AutonomousMode extends SequentialCommandGroup {
  
  DriveTrain m_driveTrain;
  /** Creates a new AutonomousMode. */
  public AutonomousMode(DriveTrain driveTrain) {
    m_driveTrain = driveTrain;
    // Add your commands in the addCommands() call, e.g.
    // addCommands(new FooCommand(), new BarCommand());
    addCommands(
      new TurnInPlace(m_driveTrain, 1, 90)



    );
  }
}

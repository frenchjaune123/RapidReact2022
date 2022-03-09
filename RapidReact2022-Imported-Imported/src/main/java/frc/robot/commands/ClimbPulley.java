// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.ClimbSubsystem;

public class ClimbPulley extends CommandBase {
  private final ClimbSubsystem m_climbSubsystem;
  private DoubleSupplier m_inputClimbLeft;
  private DoubleSupplier m_inputClimbRight;

  /** Creates a new Climb. */
  public ClimbPulley(DoubleSupplier inputClimbLeft, ClimbSubsystem climbSubsystem) {
    m_climbSubsystem = climbSubsystem;
    m_inputClimbLeft = inputClimbLeft;

    
    // m_inputClimbRight = inputClimbRight;
    
    addRequirements(climbSubsystem);
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    m_climbSubsystem.climb(m_inputClimbLeft.getAsDouble()); //up is winding, down is unwinding 
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}

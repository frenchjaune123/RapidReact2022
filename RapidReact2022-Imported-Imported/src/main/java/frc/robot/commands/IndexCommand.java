// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import java.util.function.DoubleSupplier;

import edu.wpi.first.math.MathUtil;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.IndexSubsystem;
import frc.robot.subsystems.IntakeSubsystem;

public class IndexCommand extends CommandBase {
  private DoubleSupplier m_inputIndex;
  private IndexSubsystem m_indexSubsystem;

  /** Creates a new IndexCommand. */
  public IndexCommand(DoubleSupplier inputIndex, IndexSubsystem indexSubsystem) {
    m_inputIndex = inputIndex;
    m_indexSubsystem = indexSubsystem;
    
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(m_indexSubsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    m_indexSubsystem.index(MathUtil.clamp(m_inputIndex.getAsDouble(), -0.5, 0.5));
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

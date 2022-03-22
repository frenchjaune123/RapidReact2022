// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import java.util.function.DoubleSupplier;

import edu.wpi.first.math.MathUtil;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.IntakeSubsystem;

public class IntakeMotor extends CommandBase {
  private final IntakeSubsystem m_intakeSubsystem;
  private final DoubleSupplier m_inputIntake;
  private final DoubleSupplier m_inputIndex;

  /** Creates a new IntakeMotor. */
  public IntakeMotor(DoubleSupplier inputIntake, DoubleSupplier inputIndex, IntakeSubsystem intakeSubsystem) {
    m_intakeSubsystem = intakeSubsystem;
    m_inputIntake = inputIntake;
    m_inputIndex = inputIndex;
    
    addRequirements(m_intakeSubsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    m_intakeSubsystem.suck(
      MathUtil.clamp(m_inputIntake.getAsDouble(), -0.5, 0.5), //first param = intake
      MathUtil.clamp(m_inputIndex.getAsDouble(), -0.5, 0.5)); //second param = index
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_intakeSubsystem.stopIntake();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}

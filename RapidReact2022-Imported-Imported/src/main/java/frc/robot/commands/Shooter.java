// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.ShooterSubsystem;

public class Shooter extends CommandBase {
  private final ShooterSubsystem m_ShooterSubsystem;
  private DoubleSupplier m_input; //DoubleSupplier for XboXTrigger

  /** Creates a new Shooter. */
  public Shooter(DoubleSupplier input, ShooterSubsystem shooterSubsystem) {
    m_ShooterSubsystem = shooterSubsystem;
    m_input = input;

    addRequirements(m_ShooterSubsystem);
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    m_ShooterSubsystem.shoot(m_input.getAsDouble()); //getAsDouble() //3800
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}

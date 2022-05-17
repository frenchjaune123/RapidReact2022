// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import java.util.function.DoubleSupplier;

import edu.wpi.first.math.MathUtil;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.IntakeSubsystem;

public class IntakeButton extends CommandBase {
  private double m_inputIntake;
  private IntakeSubsystem m_intakeSubsystem;

  private boolean isSucking = false;
  private boolean isFinished = false;

  /** Creates a new IntakeCommandButton. */
  public IntakeButton(double inputIntake, IntakeSubsystem intakeSubsystem) {
    m_inputIntake = inputIntake;
    m_intakeSubsystem = intakeSubsystem;
    
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(m_intakeSubsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    m_intakeSubsystem.intake(m_inputIntake);

    // if (isSucking == false) {
    //   m_intakeSubsystem.intake(m_inputIntake);
    //   isSucking = true;
    //   isFinished = true;
    // } 
    // else if (isSucking == true) {
    //   m_intakeSubsystem.intake(0);
    //   isSucking = false;
    //   isFinished = false;
    // }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;

    // if (isFinished == true) {
    //   return true;
    // } else {
    //   return false;
    // }
      // return isFinished;
  }
}

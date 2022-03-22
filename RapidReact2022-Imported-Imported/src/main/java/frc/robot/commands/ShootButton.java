// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.ShooterSubsystem;

public class ShootButton extends CommandBase {
  private final ShooterSubsystem m_shooterSubsystem;
  private double m_time;
  private boolean isFinished;
  private double m_speed;

  /** Creates a new ShootButton. */
  public ShootButton(double time, double speed, ShooterSubsystem shooterSubsystem) {
    m_time = time;
    m_speed = speed;
    m_shooterSubsystem = shooterSubsystem;
    isFinished = false;
    
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(m_shooterSubsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    // m_shooterSubsystem.startTimer();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    m_shooterSubsystem.shoot(m_speed);

    if (m_shooterSubsystem.getSpeed() >= m_speed) {
      m_shooterSubsystem.startTimer();
    }
    
    if (m_shooterSubsystem.getTimer() > m_time) {
      isFinished = true;
    }
    
    SmartDashboard.putNumber("shooterbutton speed", m_shooterSubsystem.getSpeed());
    SmartDashboard.putNumber("shooterbutton timer", m_shooterSubsystem.getTimer());
    SmartDashboard.putBoolean("shooterbutton isFinished", isFinished);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_shooterSubsystem.stopTimer();
    m_shooterSubsystem.resetTimer();
    isFinished = false;
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return isFinished;
  }
}

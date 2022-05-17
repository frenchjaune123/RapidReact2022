// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.Autonomous;

import edu.wpi.first.math.MathUtil;
import edu.wpi.first.wpilibj.AddressableLED;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.IndexSubsystem;
import frc.robot.subsystems.IntakeSubsystem;
import frc.robot.subsystems.ShooterSubsystem;

public class ShootForTime extends CommandBase {
  private double m_voltage;
  private double m_time;
  private boolean isFinished;
  private final ShooterSubsystem m_shooterSubsystem;
  private final IntakeSubsystem m_intakeSubsystem;
  private final IndexSubsystem m_indexSubsystem;

  //sucks the balls through the intake, does not push them through the index
  public ShootForTime(double voltage, double time, ShooterSubsystem shooterSubsystem, IntakeSubsystem intakeSubsystem, IndexSubsystem indexSubsystem) {
    m_voltage = voltage;
    m_time = time; //time in seconds
    m_shooterSubsystem = shooterSubsystem;
    m_intakeSubsystem = intakeSubsystem;
    m_indexSubsystem = indexSubsystem;
    isFinished = false;

    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(m_shooterSubsystem, m_intakeSubsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {    
    // m_shooterSubsystem.startTimer();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    m_shooterSubsystem.shoot(m_voltage);

    if (m_shooterSubsystem.getRPM() >= 1300) {
      if (m_shooterSubsystem.getRPM() <= 1200) {
        m_voltage += 0.01;
      }
      
      if (m_shooterSubsystem.getRPM() >= 1300) {
         m_voltage -= 0.01;
      }
    }
    
    
    if (m_shooterSubsystem.getSpeed() >= 1200 && m_shooterSubsystem.getSpeed() <= 1300) {
      // m_intakeSubsystem.suck(0, -0.25);
      m_indexSubsystem.index(0.35);
      m_shooterSubsystem.startTimer();
    }

    if (m_shooterSubsystem.getTimer() >= m_time) {
      isFinished = true;
    }
    
    SmartDashboard.putNumber("shootfortime timer", m_shooterSubsystem.getTimer());
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

// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.math.MathUtil;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.ShooterSubsystem;

public class ShootButton extends CommandBase {
  private final ShooterSubsystem m_shooterSubsystem;
  private boolean isFinished;
  private double m_RPM;
  private double m_voltage;

  /** Creates a new ShootButton. */
  public ShootButton(double RPM, ShooterSubsystem shooterSubsystem) {
    m_RPM = RPM;
    m_shooterSubsystem = shooterSubsystem;
    isFinished = false;
    m_voltage = 0.75;
    
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
    m_shooterSubsystem.shoot(MathUtil.clamp(m_voltage, -0.7, 0.7));

    if (m_shooterSubsystem.getRPM() >= 1300) {
      if (m_shooterSubsystem.getRPM() <= 1200) {
        m_voltage += 0.01;
      }
      
      if (m_shooterSubsystem.getRPM() >= 1300) {
         m_voltage -= 0.01;
      }
    }



    // if (m_shooterSubsystem.getRPM() >= 1200 && m_shooterSubsystem.getRPM() <= 1300) {
    //   m_voltage = m_shooterSubsystem.getVoltage();
    // }

    // if (m_shooterSubsystem.getRPM() >= 1200 && m_shooterSubsystem.getRPM() <= 1300) {
    //   m_shooterSubsystem.startTimer();
    // }
    


    // if (m_shooterSubsystem.getTimer() > m_time) {
    //   isFinished = true;
    // }
    
    // SmartDashboard.putNumber("shooterbutton speed", m_shooterSubsystem.getSpeed());
    // SmartDashboard.putNumber("shooterbutton timer", m_shooterSubsystem.getTimer());
    // SmartDashboard.putBoolean("shooterbutton isFinished", isFinished);

    SmartDashboard.putNumber("shooterbutton RPM", m_RPM);
    SmartDashboard.putNumber("shooter voltage", m_voltage);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    // m_shooterSubsystem.stopTimer();
    // m_shooterSubsystem.resetTimer();
    // isFinished = false;
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    // return isFinished;
    return false;
  }
}

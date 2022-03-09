// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.Autonomous;

import edu.wpi.first.math.MathUtil;
import edu.wpi.first.wpilibj.AddressableLED;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.IntakeSubsystem;
import frc.robot.subsystems.ShooterSubsystem;

public class ShootForTime extends CommandBase {
  private double m_shootSpeed;
  private Timer m_timer;
  private double m_time;
  private final ShooterSubsystem m_shooterSubsystem;
  private final IntakeSubsystem m_intakeSubsystem;

  //sucks the balls through the intake, does not push them through the index
  public ShootForTime(double shootSpeed, double time, ShooterSubsystem shooterSubsystem, IntakeSubsystem intakeSubsystem) {
    m_shootSpeed = shootSpeed;
    m_time = time; //time in seconds
    m_shooterSubsystem = shooterSubsystem;
    m_intakeSubsystem = intakeSubsystem;
    m_timer = new Timer();

    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(m_shooterSubsystem, m_intakeSubsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    m_timer.reset();
    m_timer.start();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    m_shooterSubsystem.shoot(m_shootSpeed);

    if (m_shooterSubsystem.getSpeed() >= m_shootSpeed) {
      m_intakeSubsystem.suck(0, 0.25);
    }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return m_timer.get() == m_time;
  }
}

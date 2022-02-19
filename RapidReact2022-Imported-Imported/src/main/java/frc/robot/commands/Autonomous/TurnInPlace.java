// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.Autonomous;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveTrain;

public class TurnInPlace extends CommandBase {
  private final DriveTrain m_driveTrain;
  private double m_angle;
  private double m_speed;
  
  /** Creates a new CW. */
  public TurnInPlace(DriveTrain driveTrain, double speed, double angle) {
    m_driveTrain = driveTrain;
    m_speed = speed;
    m_angle = angle;

    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(m_driveTrain);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    m_driveTrain.resetGyro();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    if (m_angle > 0) {
      m_driveTrain.tankDrive(m_speed, m_speed);
    } 
    if (m_angle < 0) {
      m_driveTrain.tankDrive(m_speed, m_speed);
    }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    if (m_angle > 0) {
      if (m_driveTrain.getHeading() > m_angle) {
        return true;
      } else {
        return false;
      }
    }

    if (m_angle < 0) {
      if (m_driveTrain.getHeading() < m_angle) {
        return true;
      } else {
        return false;
      }
    }
    
    return false;
  }
}

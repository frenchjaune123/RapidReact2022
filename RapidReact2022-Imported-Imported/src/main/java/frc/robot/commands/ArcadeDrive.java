// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import java.util.function.DoubleSupplier;

import edu.wpi.first.math.MathUtil;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;
import frc.robot.subsystems.DriveTrain;

public class ArcadeDrive extends CommandBase {

  private final DriveTrain m_driveTrain;
  private final DoubleSupplier m_forward;
  private final DoubleSupplier m_turn;

  private static double m_speed;

  /** Creates a new TankDrive. */
  public ArcadeDrive(DoubleSupplier forward, DoubleSupplier turn, DriveTrain driveTrain) {
    m_driveTrain = driveTrain;
    m_forward = forward;
    m_turn = turn;
    m_speed = 1;
    addRequirements(m_driveTrain);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    // m_driveTrain.resetEncoders();
    // m_driveTrain.resetGyro();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() { 
    
    m_driveTrain.Update_Limelight_Tracking();

    // double steer = m_speed * m_turn.getAsDouble();
    // double drive = m_speed * m_forward.getAsDouble();
    boolean auto = ActivateLimelight.getLimeLightStatus();

    // steer *= 0.70;
    // drive *= 0.70;

    if (auto) {
      m_driveTrain.getNetworkTableInstance().getDefault().getTable("limelight") //enables vision processing
          .getEntry("camMode").setNumber(0);
      m_driveTrain.getNetworkTableInstance().getDefault().getTable("limelight") //turns on limelight
          .getEntry("ledMode").setNumber(3);
      if (m_driveTrain.getllValidTarget()) {
        m_driveTrain.arcadeDrive(MathUtil.clamp(m_driveTrain.getllDrive(), -0.4, 0.4), 
            MathUtil.clamp(m_driveTrain.getllSteer(), -0.5, 0.5)); //left clamp is weaker to accomodate limelight change
      } else {
        m_driveTrain.arcadeDrive(0.0, 0.0);
      }
    } else {
      m_driveTrain.getNetworkTableInstance().getDefault().getTable("limelight") //turns off limelight
          .getEntry("ledMode").setNumber(1);
      m_driveTrain.getNetworkTableInstance().getDefault().getTable("limelight") //disables vision processing
          .getEntry("camMode").setNumber(1);
      m_driveTrain.arcadeDrive(m_speed * m_forward.getAsDouble(), m_turn.getAsDouble());
    }

    // m_driveTrain.arcadeDrive(m_speed * m_forward.getAsDouble(), m_speed * m_turn.getAsDouble());
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_driveTrain.stop();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }

  public static void setSpeed(double speed) {
    m_speed = speed; 
  }
  
  public static double getSpeed() {
    return m_speed;
  }
}
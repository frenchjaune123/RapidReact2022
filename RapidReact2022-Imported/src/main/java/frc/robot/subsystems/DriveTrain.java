// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import frc.robot.Constants;

public class DriveTrain extends SubsystemBase {
  private final DifferentialDrive m_drive;
  private final WPI_VictorSPX leftMotor0;
  private final WPI_VictorSPX rightMotor0;
  
  private final SpeedControllerGroup m_left;
  private final SpeedControllerGroup m_right;

  
  /** Creates a new ExampleSubsystem. */
  public DriveTrain() {
    leftMotor0 = new WPI_VictorSPX(Constants.DRIVE_LEFT_VICTORSPX0);
    rightMotor0 = new WPI_VictorSPX(Constants.DRIVE_RIGHT_VICTORSPX0);

    m_left = new SpeedControllerGroup(leftMotor0, leftMotor0);
    m_right = new SpeedControllerGroup(rightMotor0, rightMotor0);
    m_drive = new DifferentialDrive(m_left, m_right);

    leftMotor0.setNeutralMode(NeutralMode.Brake);
    rightMotor0.setNeutralMode(NeutralMode.Brake);
  }

  public void tankDrive(double left, double right) {
    m_drive.tankDrive(left, right);
  }

  public void stop() {
    m_drive.tankDrive(0, 0);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }
}

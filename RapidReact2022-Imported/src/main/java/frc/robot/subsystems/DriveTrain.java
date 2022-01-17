// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;


import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj.motorcontrol.VictorSP;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

// import java.util.ResourceBundle.Control;

// import com.ctre.phoenix.motorcontrol.ControlMode;
// import com.ctre.phoenix.motorcontrol.NeutralMode;
// import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import frc.robot.Constants;

public class DriveTrain extends SubsystemBase {
  // private final DifferentialDrive m_drive;
  private final VictorSP leftMotor0;
  private final VictorSP rightMotor0;
  
  private final DifferentialDrive m_drive;
  private final MotorControllerGroup m_left;
  private final MotorControllerGroup m_right;
  
  /** Creates a new ExampleSubsystem. */
  public DriveTrain() {
    leftMotor0 = new VictorSP(Constants.DRIVE_LEFT_VICTORSPX0);
    rightMotor0 = new VictorSP(Constants.DRIVE_RIGHT_VICTORSPX0);
    
    m_left = new MotorControllerGroup(leftMotor0, leftMotor0);
    m_right = new MotorControllerGroup(rightMotor0, rightMotor0);
    m_drive = new DifferentialDrive(m_left, m_right);


    leftMotor0.stopMotor();
    rightMotor0.stopMotor();
  }

  public void setLeftMotors(double speed) {
    leftMotor0.set(-speed);
  }

  public void setRightMotors(double speed) {
    rightMotor0.set(-speed);
  }

  public void arcadeDrive(double throttle, double turn) {
    double leftMtr = throttle + turn;
    double rightMtr = throttle - turn;

    // m_drive.arcadeDrive(throttle, turn);
    m_drive.tankDrive(leftMtr, rightMtr);
  }

  public void tankDrive(double left, double right) {
    m_drive.tankDrive(left, right);
  }

  public void stop() {
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

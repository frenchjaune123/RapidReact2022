// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;


import com.playingwithfusion.CANVenom;
import com.playingwithfusion.CANVenom.ControlMode;

import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.interfaces.Gyro;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj.motorcontrol.VictorSP;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

// import java.util.ResourceBundle.Control;

// import com.ctre.phoenix.motorcontrol.ControlMode;
// import com.ctre.phoenix.motorcontrol.NeutralMode;
// import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import frc.robot.Constants;
import frc.robot.commands.SlowMode;

public class DriveTrain extends SubsystemBase {
  // VictorSP = practice bot
  private final DifferentialDrive m_drive;
  private final VictorSP leftMotor0;
  private final VictorSP rightMotor0;
  
  // CANVenom = official bot
  // private final CANVenom leftMotor0;
  // private final CANVenom leftMotor1;
  // private final CANVenom rightMotor0;
  // private final CANVenom rightMotor1;
  // private final DifferentialDrive m_drive;


  private final Gyro m_gyro;
  
  /** Creates a new ExampleSubsystem. */
  public DriveTrain() {
    // VictorSP
    leftMotor0 = new VictorSP(Constants.DRIVE_LEFT_VICTORSP0);
    rightMotor0 = new VictorSP(Constants.DRIVE_RIGHT_VICTORSP0);

    // CANVenom
    // leftMotor0 = new CANVenom(Constants.DRIVE_LEFT_VENOM0);
    // leftMotor1 = new CANVenom(Constants.DRIVE_LEFT_VENOM1);
    // leftMotor0.follow(leftMotor1); //leftMotor1 is leading
    // rightMotor0 = new CANVenom(Constants.DRIVE_RIGHT_VENOM0);
    // rightMotor1 = new CANVenom(Constants.DRIVE_RIGHT_VENOM1);
    // rightMotor0.follow(rightMotor1); //rightMotor1 is leading


    // m_drive = new DifferentialDrive(leftMotor1, rightMotor1); //CANVenom 
    m_drive = new DifferentialDrive(leftMotor0, rightMotor0); //VictorSP

    // VictorSP 
    // leftMotor0.stopMotor();
    // rightMotor0.stopMotor();

    m_gyro = new ADXRS450_Gyro();
    m_gyro.calibrate();
    m_gyro.reset();

    // addChild("Drive", m_drive);
  }

  public void setLeftMotors(double speed) {
    leftMotor0.set(-speed);
  }

  public void setRightMotors(double speed) {
    rightMotor0.set(-speed);
  }

  public void arcadeDrive(double throttle, double turn) {
    double leftMtr = throttle - turn;
    double rightMtr = throttle + turn;

    // m_drive.arcadeDrive(throttle, turn); //original
    m_drive.arcadeDrive(turn, throttle); //new
    // m_drive.tankDrive(leftMtr, rightMtr);
  }

  public void tankDrive(double left, double right) {
    m_drive.tankDrive(left, right);
  }

  public void stop() {
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    log();
  }

  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }
  

  public void resetGyro() {
    m_gyro.reset();
  }

  public double getHeading() {
    return m_gyro.getAngle();
  }

  public void log() {
    SmartDashboard.putNumber("Gyro", m_gyro.getAngle());
    // System.out.println(m_gyro.getAngle());
    // SmartDashboard.putNumber("LeftSpeed0", leftMotor0.getSpeed());
    // SmartDashboard.putNumber("LeftSpeed1", leftMotor1.getSpeed());
    // SmartDashboard.putNumber("RightSpeed0", rightMotor0.getSpeed());
    // SmartDashboard.putNumber("RightSpeed1", rightMotor1.getSpeed());
  }
}

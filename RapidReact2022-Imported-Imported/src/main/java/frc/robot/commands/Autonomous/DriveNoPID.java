// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.Autonomous;

import edu.wpi.first.math.MathUtil;
import edu.wpi.first.wpilibj.AddressableLED;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.IntakeSubsystem;

public class DriveNoPID extends CommandBase {
  private boolean isFinished = false;
  private double initialVoltage;
  private double finalVoltage;
  
  // private Timer m_timer;
  private double m_distance;
  private double m_time;
  private final DriveTrain m_driveTrain;


  //d = v * t
  //t = d / v, v = 0.5 --> t = d / 0.5

  //sucks the balls through the intake, does not push them through the index
  public DriveNoPID(double distance, DriveTrain driveTrain) {
    m_distance = distance; 
    m_driveTrain = driveTrain;
    // m_timer = new Timer();
    

    // m_time = m_distance / 0.5;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(m_driveTrain);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    // m_timer.reset();
    // m_timer.start();
    m_driveTrain.resetPosition();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    m_driveTrain.arcadeDrive(0.5, 0);
    // SmartDashboard.putNumber("drive timer", m_timer.get());
    // SmartDashboard.putNumber("getposition value", m_driveTrain.getPosition());

    // if (initialVoltage - m_intakeSubsystem.getOutputVoltage() > 1) { //test to see appropriate change
    //   finalVoltage = m_intakeSubsystem.getOutputVoltage();
    // }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_driveTrain.stop();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    // if (-m_driveTrain.getPosition() <= m_distance) {
    //   m_driveTrain.arcadeDrive(0, 0);
    //   return true;
    // }
    // return false;
    // return m_timer.get() >= m_time;

    return m_driveTrain.getPosition() >= m_distance;
  }
}

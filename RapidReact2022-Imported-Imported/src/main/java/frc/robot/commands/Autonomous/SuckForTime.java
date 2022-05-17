// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.Autonomous;

import edu.wpi.first.math.MathUtil;
import edu.wpi.first.wpilibj.AddressableLED;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.IntakeSubsystem;

public class SuckForTime extends CommandBase {
  private boolean isFinished;
  private double initialVoltage;
  private double finalVoltage;
  
  private Timer m_timer;
  private double m_time;
  private final IntakeSubsystem m_intakeSubsystem;

  //sucks the balls through the intake, does not push them through the index
  public SuckForTime(double time, IntakeSubsystem intakeSubsystem) {
    m_time = time; //time in seconds
    m_intakeSubsystem = intakeSubsystem;
    m_timer = new Timer();
    isFinished = false;


    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(m_intakeSubsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    m_intakeSubsystem.startTimer();
    // initialVoltage = m_intakeSubsystem.getOutputVoltage();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    // m_intakeSubsystem.suck(0.7, 0);
    m_intakeSubsystem.intake(0.7);

    // if (initialVoltage - m_intakeSubsystem.getOutputVoltage() > 1) { //test to see appropriate change
    //   finalVoltage = m_intakeSubsystem.getOutputVoltage();
    // }

    if (m_intakeSubsystem.getTimer() > m_time) {
      isFinished = true;
    }
    
    SmartDashboard.putNumber("suckfortime timer", m_intakeSubsystem.getTimer());
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_intakeSubsystem.stopTimer();
    m_intakeSubsystem.resetTimer();
    isFinished = false;
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {  
    return isFinished;
  }
}

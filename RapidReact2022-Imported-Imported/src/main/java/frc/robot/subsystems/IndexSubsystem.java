// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.motorcontrol.VictorSP;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class IndexSubsystem extends SubsystemBase {
  private final VictorSP m_indexMotor;
  private Timer m_timer;
  
  /** Creates a new IndexSubsystem. */
  public IndexSubsystem() {

    m_indexMotor = new VictorSP(Constants.INDEX_REDLINE);
    m_timer = new Timer();

  }

  public void index(double inputIndex) {
      m_indexMotor.set(inputIndex);
    }

  public void stopIntake() {
    m_indexMotor.set(0);
  }
  
  public void startTimer() {
    m_timer.start();
  }

  public void stopTimer() {
    m_timer.stop();
  }

  public double getTimer() {
    return m_timer.get();
  }

  public void resetTimer() {
    m_timer.reset();
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}

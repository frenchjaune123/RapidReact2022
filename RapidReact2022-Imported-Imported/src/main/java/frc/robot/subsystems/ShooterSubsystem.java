// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.playingwithfusion.CANVenom;

import edu.wpi.first.wpilibj.motorcontrol.MotorController;
import edu.wpi.first.wpilibj.motorcontrol.VictorSP;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class ShooterSubsystem extends SubsystemBase {
  // VictorSP m_shooter;
  CANVenom m_shooter;
  private double output;
  // MotorController m_motorcontroller;
  
  /** Creates a new Shooter. */
  public ShooterSubsystem() {
    // m_shooter =  new VictorSP(Constants.SHOOTER_VICTORSP0);
    m_shooter = new CANVenom(Constants.SHOOTER_VENOM0);
  }

  public void shoot(double input) {
    m_shooter.set(input);
    output = input;
  }

  public void stop() {
    m_shooter.stopMotor();
  }

  public double getSpeed() {
    return m_shooter.getSpeed();
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    SmartDashboard.putNumber("Shooter Trigger", output);
    SmartDashboard.putNumber("Shooter RPM", m_shooter.getSpeed());
  }
}

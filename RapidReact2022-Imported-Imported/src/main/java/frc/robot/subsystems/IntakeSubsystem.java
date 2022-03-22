// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.playingwithfusion.CANVenom;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.math.MathUtil;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PWM;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.motorcontrol.VictorSP;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class IntakeSubsystem extends SubsystemBase {
  
  private final PWM m_intakeMotor;
  // private final VictorSP m_intakeMotor;
  private final VictorSP m_indexMotor;
  // private final DoubleSolenoid m_intakePistons;
  private boolean intakeIsIn;
  
  /** Creates a new IntakePistonSubsystem. */
  public IntakeSubsystem() {
    // m_intakeMotor = new VictorSP(Constants.INTAKE_REDLINE);
    m_intakeMotor = new PWM(Constants.INTAKE_REDLINE);
    m_indexMotor = new VictorSP(Constants.INDEX_REDLINE);
    // m_intakePistons = new DoubleSolenoid(PneumaticsModuleType.REVPH, //check module type
        // Constants.INTAKE_SOLENOID_DEPLOY, Constants.INTAKE_SOLENOID_RETRACT);
    
  }

  // public void pistonPush() {
  //   if(intakeIsIn) {
  //     m_intakePistons.set(Value.kForward);
  //     intakeIsIn = false;
  //   }
  //   else {
  //     m_intakePistons.set(Value.kReverse);
  //     intakeIsIn = true;
  //   }
  // }

  public void suck(double inputIntake, double inputIndex) {
    // m_intakeMotor.set(inputIntake); //VictorSP
    m_intakeMotor.setSpeed(inputIntake); //PWM
    m_indexMotor.set(inputIndex);

    // if (inputIntake > 0.2) {
    //   m_intakeMotor.set(MathUtil.clamp(-inputIndex, -0.5, 0));
    // }
  }

  public void stopIntake() {
    // m_intakeMotor.set(0);
    m_intakeMotor.setSpeed(0);
    m_indexMotor.set(0);
  }

  public double getOutputVoltage() {
    return m_intakeMotor.getSpeed();
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    log();
  }

  public void log() {
    SmartDashboard.putBoolean("Intake is in", intakeIsIn);
    // SmartDashboard.putNumber("Intake motor RPM", m_intakeMotor.getSpeed());
    // SmartDashboard.putNumber("Intake bus voltage", m_intakeMotor.getBusVoltage());
    // SmartDashboard.putNumber("Intake motor RPM", m_intakeMotor.getAppliedOutput());
  }
}

// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import java.util.function.DoubleSupplier;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class ClimbSubsystem extends SubsystemBase {
  private final CANSparkMax m_climberMotor0;
  private final CANSparkMax m_climberMotor1;
  private final DoubleSolenoid m_climberPistons;
  private final DoubleSolenoid m_clawPiston;
  private boolean climbIsIn = true;
  private boolean clawIsIn = true;

  /** Creates a new ClimbSubsystem. */
  public ClimbSubsystem() {
    m_climberMotor0 = new CANSparkMax(Constants.CLIMBER_SPARKMAX0, MotorType.kBrushless);
    m_climberMotor1 = new CANSparkMax(Constants.CLIMBER_SPARKMAX1, MotorType.kBrushless);

    // m_climberMotor0.follow(m_climberMotor1); //climbermotor1 is leading
    m_climberPistons = new DoubleSolenoid(PneumaticsModuleType.CTREPCM, // check module type
        Constants.CLIMBER_SOLENOID_DEPLOY, Constants.CLIMBER_SOLENOID_RETRACT);
    m_clawPiston = new DoubleSolenoid(PneumaticsModuleType.CTREPCM,
        Constants.CLAW_SOLENOID_DEPLOY, Constants.CLAW_SOLENOID_RETRACT);
  }

  public void climberPush() {
    if (climbIsIn) {
      m_climberPistons.set(Value.kForward);
      climbIsIn = false;
    } else {
      m_climberPistons.set(Value.kReverse);
      climbIsIn = true;
    }
  }

  public void clawPush() {
    if (clawIsIn) {
      m_clawPiston.set(Value.kForward);
      clawIsIn = false;
    } else {
      m_clawPiston.set(Value.kReverse);
      clawIsIn = true;
    }
  }

  public void climb(double inputLeft) {
    m_climberMotor0.set(inputLeft);
    // m_climberMotor1.set(inputRight);
    m_climberMotor1.set(-inputLeft);
  }

  public void stopClimb() {
    m_climberMotor1.set(0);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}

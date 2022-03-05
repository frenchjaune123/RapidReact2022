// // Copyright (c) FIRST and other WPILib contributors.
// // Open Source Software; you can modify and/or share it under the terms of
// // the WPILib BSD license file in the root directory of this project.

// package frc.robot.subsystems;

// import com.revrobotics.CANSparkMax;
// import com.revrobotics.CANSparkMaxLowLevel.MotorType;

// import edu.wpi.first.wpilibj.DoubleSolenoid;
// import edu.wpi.first.wpilibj.PneumaticsModuleType;
// import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
// import edu.wpi.first.wpilibj2.command.SubsystemBase;
// import frc.robot.Constants;

// public class ClimbSubsystem extends SubsystemBase {
//   private final CANSparkMax m_climberMotor;
//   private final DoubleSolenoid m_climberPistons;
//   private boolean intakeIsIn;

//   /** Creates a new ClimbSubsystem. */
//   public ClimbSubsystem() {
//     m_climberMotor = new CANSparkMax(Constants.CLIMBER_MOTOR_SPARKMAX, MotorType.kBrushless);
//     m_climberPistons = new DoubleSolenoid(PneumaticsModuleType.REVPH, // check module type
//         Constants.CLIMBER_SOLENOID_DEPLOY, Constants.CLIMBER_SOLENOID_RETRACT);
//   }

//   public void climberPush() {
//     if (intakeIsIn) {
//       m_climberPistons.set(Value.kForward);
//       intakeIsIn = false;
//     } else {
//       m_climberPistons.set(Value.kReverse);
//       intakeIsIn = true;
//     }
//   }

//   public void shoot(double input) {
//     if (input > 0) {
//       m_climberMotor.set(-input);
//     } else {
//       stopIntake();
//     }
//   }

//   public void stopIntake() {
//     m_climberMotor.set(0);
//   }

//   @Override
//   public void periodic() {
//     // This method will be called once per scheduler run
//   }
// }

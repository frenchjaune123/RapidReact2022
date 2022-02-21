// // Copyright (c) FIRST and other WPILib contributors.
// // Open Source Software; you can modify and/or share it under the terms of
// // the WPILib BSD license file in the root directory of this project.

// package frc.robot.subsystems;

// import com.playingwithfusion.CANVenom;

// import edu.wpi.first.wpilibj.DoubleSolenoid;
// import edu.wpi.first.wpilibj.PneumaticsModuleType;
// import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
// import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
// import edu.wpi.first.wpilibj2.command.SubsystemBase;
// import frc.robot.Constants;

// public class IntakeSubsystem extends SubsystemBase {
  
//   private final CANVenom m_intakeMotor;
//   private final DoubleSolenoid m_intakePistons;
//   private boolean intakeIsIn;
  
//   /** Creates a new IntakePistonSubsystem. */
//   public IntakeSubsystem() {
//     m_intakeMotor = new CANVenom(Constants.INTAKE_MOTOR_VICTORSP);
//     m_intakePistons = new DoubleSolenoid(PneumaticsModuleType.REVPH, //check module type
//         Constants.INTAKE_SOLENOID_DEPLOY, Constants.INTAKE_SOLENOID_RETRACT);
    
//   }

//   public void pistonPush() {
//     if(intakeIsIn) {
//       m_intakePistons.set(Value.kForward);
//       intakeIsIn = false;
//     }
//     else {
//       m_intakePistons.set(Value.kReverse);
//       intakeIsIn = true;
//     }
//   }

//   public void suck(double input) {
//     if (input > 0) {
//       m_intakeMotor.set(-input);
//     } else {
//       stopIntake();
//     }
//   }

//   public void stopIntake() {
//     m_intakeMotor.set(0);
//   }

//   @Override
//   public void periodic() {
//     // This method will be called once per scheduler run
//     log();
//   }

//   public void log() {
//     SmartDashboard.putBoolean("Intake is in", intakeIsIn);
//     SmartDashboard.putNumber("Intake motor RPM", m_intakeMotor.getSpeed());
//   }
// }

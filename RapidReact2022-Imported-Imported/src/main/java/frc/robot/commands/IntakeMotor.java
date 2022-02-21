// // Copyright (c) FIRST and other WPILib contributors.
// // Open Source Software; you can modify and/or share it under the terms of
// // the WPILib BSD license file in the root directory of this project.

// package frc.robot.commands;

// import java.util.function.DoubleSupplier;

// import edu.wpi.first.wpilibj2.command.CommandBase;
// import frc.robot.subsystems.IntakeSubsystem;

// public class IntakeMotor extends CommandBase {
//   private final IntakeSubsystem m_intakeSubsystem;
//   private final DoubleSupplier m_input;

//   /** Creates a new IntakeMotor. */
//   public IntakeMotor(DoubleSupplier input, IntakeSubsystem intakeSubsystem) {
//     m_intakeSubsystem = intakeSubsystem;
//     m_input = input;
    
//     addRequirements(m_intakeSubsystem);
//   }

//   // Called when the command is initially scheduled.
//   @Override
//   public void initialize() {}

//   // Called every time the scheduler runs while the command is scheduled.
//   @Override
//   public void execute() {
//     m_intakeSubsystem.suck(m_input.getAsDouble());
//   }

//   // Called once the command ends or is interrupted.
//   @Override
//   public void end(boolean interrupted) {
//     m_intakeSubsystem.stopIntake();
//   }

//   // Returns true when the command should end.
//   @Override
//   public boolean isFinished() {
//     return false;
//   }
// }

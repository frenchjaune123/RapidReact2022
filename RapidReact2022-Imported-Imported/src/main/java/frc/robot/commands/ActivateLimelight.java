// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.PS4Controller.Button;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class ActivateLimelight extends CommandBase {
  private static boolean limeLightIsOn = false;
  private boolean isFinished = false;
  
  /** Creates a new ActivateLimelight. */
  public ActivateLimelight() {
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    if (limeLightIsOn == false) {
      limeLightIsOn = true; 
      isFinished = true;
    } else if (limeLightIsOn == true) {
      limeLightIsOn = false;
      isFinished = true;
    }
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    SmartDashboard.putBoolean("limelightisOn", limeLightIsOn);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return isFinished;
  }

  public static boolean getLimeLightStatus() {
    return limeLightIsOn;
  }
}

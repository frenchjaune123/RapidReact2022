// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.Autonomous;

import edu.wpi.first.math.MathUtil;
import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.PIDCommand;
import frc.robot.subsystems.DriveTrain;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/stable/docs/software/commandbased/convenience-features.html
public class DriveDistance extends PIDCommand {
  private boolean isFinished;
  private DriveTrain m_driveTrain;

  /** Creates a new DriveDistance. */
  public DriveDistance(double position, DriveTrain driveTrain) {
    super(
        // The controller that the command will use
        new PIDController(0, 0, 0),
        // This should return the measurement
        () -> driveTrain.getPosition(),
        // This should return the setpoint (can also be a constant)
        () -> position,
        // This uses the output
        output -> {
          // Use the output here
          SmartDashboard.putNumber("drdist output", MathUtil.clamp(output, -0.5, 0.5));
          driveTrain.arcadeDrive(MathUtil.clamp(output, -0.5, 0.5), 0);
        },
        driveTrain);
    // Use addRequirements() here to declare subsystem dependencies.
    // Configure additional PID options by calling `getController` here.
    m_driveTrain = driveTrain;
    getController().enableContinuousInput(-50, 50);
    getController().setTolerance(1, 10);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    isFinished = getController().atSetpoint();

    if (isFinished) {
      getController().reset();
    }

    return isFinished;
  }

  @Override
  public void initialize() {
    m_driveTrain.resetPosition();
  }
}
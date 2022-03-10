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
public class TurnToAngle extends PIDCommand {
  private boolean isFinished;
  private DriveTrain m_driveTrain;

  // Parameters: Positive angle is right, Negative angle is left
  public TurnToAngle(double angle, DriveTrain driveTrain) {
    super(
        // The controller that the command will use
        new PIDController(1, 0, 0.16), //0.013 does not brown out!, 0.014 browns out
        // This should return the measurement
        () -> driveTrain.getHeading(),
        // This should return the setpoint (can also be a constant)
        () -> angle,
        // This uses the output
        output -> {
          // Use the output here
          SmartDashboard.putNumber("auto output", MathUtil.clamp(output, -0.5, 0.5));
          driveTrain.arcadeDrive(0, MathUtil.clamp(output, -0.7, 0.7)); //+ for final, - for practice
        },
        driveTrain);
    // Use addRequirements() here to declare subsystem dependencies.
    // Configure additional PID options by calling `getController` here.
    
    // addRequirements(driveTrain);
    m_driveTrain = driveTrain;
    getController().enableContinuousInput(-180, 180);
    getController().setTolerance(1, 10);

  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    isFinished = getController().atSetpoint();

    SmartDashboard.putBoolean("tta PID isFinished", isFinished);
    SmartDashboard.putNumber("tta position error", this.getController().getPositionError());
    SmartDashboard.putNumber("tta measurement", this.m_measurement.getAsDouble());
    SmartDashboard.putNumber("tta setpointsource", this.m_setpoint.getAsDouble());

    if (isFinished) {
      getController().reset();
    }
    
    return isFinished;
  }

  @Override
  public void initialize() {
    m_driveTrain.resetGyro();
  }
}

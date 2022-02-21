// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.Autonomous;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.PIDCommand;
import frc.robot.subsystems.DriveTrain;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/stable/docs/software/commandbased/convenience-features.html
public class RotateCCW extends PIDCommand {
  private double m_angle;
  private DriveTrain m_driveTrain;
  
  /** Creates a new RotateCCW. */
  public RotateCCW(double angle, DriveTrain driveTrain) {
    super(
        // The controller that the command will use
        new PIDController(10, 0, 0),
        // This should return the measurement
        () -> 0,
        // This should return the setpoint (can also be a constant)
        () -> angle,
        // This uses the output
        output -> 
          // Use the output here
          driveTrain.arcadeDrive(0, output)
        );
    // Use addRequirements() here to declare subsystem dependencies.
    // Configure additional PID options by calling `getController` here.

    getController().enableContinuousInput(-180, 180);
    getController().setTolerance(5, 5);

    SmartDashboard.putData("AUTO PID", this.getController());
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return getController().atSetpoint();
  }
}

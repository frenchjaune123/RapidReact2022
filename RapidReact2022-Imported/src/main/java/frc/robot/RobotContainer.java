// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

//AKA ROBOTMAP

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.math.filter.SlewRateLimiter;
import edu.wpi.first.wpilibj.XboxController;
import frc.robot.commands.ArcadeDrive;
import frc.robot.commands.TankDrive;
import frc.robot.subsystems.DriveTrain;
import edu.wpi.first.wpilibj2.command.Command;

import edu.wpi.first.math.filter.SlewRateLimiter;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  
  private final DriveTrain m_drivetrain = new DriveTrain();
  // private final CrusaderController m_controller0 = new CrusaderController(Constants.kController0);
  // private final CrusaderController m_controller1 = new CrusaderController(Constants.kController1);
  private final LogitechController l_controller0 = new LogitechController(Constants.kController0);
  // private final SlewRateLimiter m_speedLimiter = new SlewRateLimiter(3);

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    // Configure the button bindings
    configureButtonBindings();

    setDefaultCommands();
  }

  private void setDefaultCommands() {
    // m_drivetrain.setDefaultCommand(
    //   new TankDrive(
    //     () -> -m_speedLimiter.calculate(m_controller0.getLeftStickY()), 
    //     () -> -m_speedLimiter.calculate(m_controller0.getRightStickY()), m_drivetrain)
    // );

    // m_drivetrain.setDefaultCommand(
    //   new TankDrive(
    //     () -> -m_speedLimiter.calculate(l_controller0.getYAxis()), 
    //     () -> -m_speedLimiter.calculate(l_controller0.getXAxis()), m_drivetrain)
    // );

    m_drivetrain.setDefaultCommand(
      new ArcadeDrive(
        () -> l_controller0.getZAxis(), 
        () -> -l_controller0.getYAxis(), m_drivetrain)
    );
  }

  /**
   * Use this method to define your button->command mappings. Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a {@link
   * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {}

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    return null;
  }
}

// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.playingwithfusion.CANVenom;
import com.playingwithfusion.CANVenom.ControlMode;

import edu.wpi.first.cameraserver.CameraServer;
import edu.wpi.first.cscore.CvSink;
import edu.wpi.first.cscore.CvSource;
import edu.wpi.first.cscore.HttpCamera;
import edu.wpi.first.cscore.MjpegServer;
import edu.wpi.first.cscore.UsbCamera;
import edu.wpi.first.cscore.HttpCamera.HttpCameraKind;
import edu.wpi.first.cscore.VideoMode.PixelFormat;
import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.interfaces.Gyro;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj.motorcontrol.VictorSP;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;


import frc.robot.Constants;
import frc.robot.commands.ArcadeDrive;
import frc.robot.commands.SlowMode;

public class DriveTrain extends SubsystemBase {
  // VictorSP = practice bot
  // private final DifferentialDrive m_drive;
  // private final VictorSP leftMotor0;
  // private final VictorSP rightMotor0;

  // CANVenom = official bot
  private final CANVenom leftMotor0;
  private final CANVenom leftMotor1;
  private final CANVenom rightMotor0;
  private final CANVenom rightMotor1;
  private final DifferentialDrive m_drive;

  private final Gyro m_gyro;


  private NetworkTableInstance m_table;
  private double m_tv;
  private double m_tx;
  private double m_ty;
  private double m_ta;

  private boolean m_LimelightHasValidTarget = false;
  private double m_LimelightDriveCommand = 0.0;
  private double m_LimelightSteerCommand = 0.0;

  HttpCamera limelightFeed;

  /** Creates a new ExampleSubsystem. */
  public DriveTrain() {
    // VictorSP
    // leftMotor0 = new VictorSP(Constants.DRIVE_LEFT_VICTORSP0);
    // rightMotor0 = new VictorSP(Constants.DRIVE_RIGHT_VICTORSP0);

    // CANVenom
    leftMotor0 = new CANVenom(Constants.DRIVE_LEFT_VENOM0);
    leftMotor1 = new CANVenom(Constants.DRIVE_LEFT_VENOM1);
    leftMotor0.follow(leftMotor1); // leftMotor1 is leading
    rightMotor0 = new CANVenom(Constants.DRIVE_RIGHT_VENOM0);
    rightMotor1 = new CANVenom(Constants.DRIVE_RIGHT_VENOM1);
    rightMotor0.follow(rightMotor1); // rightMotor1 is leading

    m_drive = new DifferentialDrive(leftMotor1, rightMotor1); // CANVenom
    // m_drive = new DifferentialDrive(leftMotor0, rightMotor0); //VictorSP

    // VictorSP
    // leftMotor0.stopMotor();
    // rightMotor0.stopMotor();

    m_gyro = new ADXRS450_Gyro();
    m_gyro.calibrate();
    m_gyro.reset();

    // // Creates UsbCamera and MjpegServer [1] and connects them
    // UsbCamera usbCamera = new UsbCamera("USB Camera 0", 0);
    // MjpegServer mjpegServer1 = new MjpegServer("serve_USB Camera 0", 1181);
    // mjpegServer1.setSource(usbCamera);

    // // Creates the CvSink and connects it to the UsbCamera
    // CvSink cvSink = new CvSink("opencv_USB Camera 0");
    // cvSink.setSource(usbCamera);

    // // Creates the CvSource and MjpegServer [2] and connects them
    // CvSource outputStream = new CvSource("Blur", PixelFormat.kMJPEG, 640, 480, 30);
    // MjpegServer mjpegServer2 = new MjpegServer("serve_Blur", 1182);
    // mjpegServer2.setSource(outputStream);



    // Creates UsbCamera and MjpegServer [1] and connects them
    CameraServer.startAutomaticCapture();

    // Creates the CvSink and connects it to the UsbCamera
    CvSink cvSink = CameraServer.getVideo();

    // Creates the CvSource and MjpegServer [2] and connects them
    CvSource outputStream = CameraServer.putVideo("Blur", 640, 480);

    // limelightFeed = new HttpCamera("limelight", "http://10.3.22.11:5800/stream.mjpg", HttpCameraKind.kMJPGStreamer);
    // CameraServer.startAutomaticCapture(limelightFeed);

    // addChild("Drive", m_drive);
  }

  public void setLeftMotors(double speed) {
    leftMotor0.set(-speed);
  }

  public void setRightMotors(double speed) {
    rightMotor0.set(-speed);
  }

  public void arcadeDrive(double throttle, double turn) {
    double leftMtr = throttle - turn;
    double rightMtr = throttle + turn;

    // m_drive.arcadeDrive(throttle, turn); //original
    m_drive.arcadeDrive(turn, throttle); // new
    // m_drive.tankDrive(leftMtr, rightMtr);
  }

  public void tankDrive(double left, double right) {
    m_drive.tankDrive(left, right);
  }

  public void stop() {
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    log();
  }

  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }

  public void resetGyro() {
    m_gyro.reset();
  }

  public double getHeading() {
    return m_gyro.getAngle();
  }

  public void resetPosition() {
    // leftMotor0.resetPosition();
    // leftMotor1.resetPosition();
    // rightMotor0.resetPosition();
    // rightMotor1.resetPosition();
  }

  // Try to find out which motor is most accurate in position, if any
  public double getPosition() {
    return leftMotor1.getPosition();
  }

  public boolean getllValidTarget() {
    return m_LimelightHasValidTarget;
  } 

  public double getllDrive() {
    return m_LimelightDriveCommand;
  } 
  
  public double getllSteer() {
    return m_LimelightSteerCommand;
  } 

  public void log() {
    // SmartDashboard.putNumber("Gyro", m_gyro.getAngle());
    // SmartDashboard.putNumber("LeftSpeed0", leftMotor0.getSpeed());
    // SmartDashboard.putNumber("LeftSpeed1", leftMotor1.getSpeed());
    // SmartDashboard.putNumber("RightSpeed0", rightMotor0.getSpeed());
    // SmartDashboard.putNumber("RightSpeed1", rightMotor1.getSpeed());

    // SmartDashboard.putNumber("LeftPosition0", leftMotor0.getPosition());
    // SmartDashboard.putNumber("LeftPosition1", leftMotor1.getPosition());
    // SmartDashboard.putNumber("RightPosition0", rightMotor0.getPosition());
    // SmartDashboard.putNumber("RightPosition1", rightMotor1.getPosition());

    SmartDashboard.putNumber("tv", m_tv);
    SmartDashboard.putNumber("tx", m_tx);
    SmartDashboard.putNumber("ty", m_ty);
    SmartDashboard.putNumber("ta", m_ta);

    SmartDashboard.putNumber("setted speed", ArcadeDrive.getSpeed());
  }


  public NetworkTableInstance getNetworkTableInstance() {
    return m_table;
  }

  public void Update_Limelight_Tracking() {
    // These numbers must be tuned for your Robot! Be careful!
    final double STEER_K = 0.3; // how hard to turn toward the target
    final double DRIVE_K = 0.3; // how hard to drive fwd toward the target
    final double DESIRED_TARGET_AREA = 8.0; // Area of the target when the robot reaches the wall
    //15 was good, trying 13
    final double MAX_DRIVE = 0.7; // Simple speed limit so we don't drive too fast

    m_tv = m_table.getDefault().getTable("limelight").getEntry("tv").getDouble(0);
    m_tx = m_table.getDefault().getTable("limelight").getEntry("tx").getDouble(0);
    m_ty = m_table.getDefault().getTable("limelight").getEntry("ty").getDouble(0);
    m_ta = m_table.getDefault().getTable("limelight").getEntry("ta").getDouble(0);


    if (m_tv < 1.0) {
      m_LimelightHasValidTarget = false;
      m_LimelightDriveCommand = 0.0;
      m_LimelightSteerCommand = 0.0;
      return;
    }

    m_LimelightHasValidTarget = true;

    // Start with proportional steering
    m_LimelightSteerCommand = m_tx * STEER_K;

    // try to drive forward until the target area reaches our desired area
    double drive_cmd = (DESIRED_TARGET_AREA - m_ta) * DRIVE_K;

    // don't let the robot drive too fast into the goal
    if (drive_cmd > MAX_DRIVE) {
      drive_cmd = MAX_DRIVE;
    }
    m_LimelightDriveCommand = drive_cmd;
  }
}

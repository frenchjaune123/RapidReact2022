// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {

    //PWM Motors
    public static final int DRIVE_LEFT_VICTORSP0 = 4;
    public static final int INTAKE_MOTOR_VICTORSP = 0; //review this port!!

    public static final int DRIVE_RIGHT_VICTORSP0 = 5;
    public static final int SHOOTER_VICTORSP0 = 0;
    public static final int INDEX_REDLINE = 2;
    public static final int INTAKE_REDLINE = 3;
    

    //CAN Motors
    public static final int DRIVE_LEFT_VENOM0 = 0;
    public static final int DRIVE_LEFT_VENOM1 = 1;
    public static final int DRIVE_RIGHT_VENOM0 = 2;
    public static final int DRIVE_RIGHT_VENOM1 = 3;
    public static final int CLIMBER_SPARKMAX0 = 6; 
    public static final int CLIMBER_SPARKMAX1 = 5; 

    //Shooter Motors
    public static final int SHOOTER_VENOM0 = 4;

    //Pneumatics
    public static final int INTAKE_SOLENOID_DEPLOY = 11; //check for actual pneumatic ports
    public static final int INTAKE_SOLENOID_RETRACT = 10; //this, too ^^
    public static final int CLIMBER_SOLENOID_DEPLOY = 2; //CHECK TOO
    public static final int CLIMBER_SOLENOID_RETRACT = 3; //check
    public static final int CLAW_SOLENOID_DEPLOY = 0; //CHECK TOO
    public static final int CLAW_SOLENOID_RETRACT = 1; //check

    //Controllers
    public static final int kController0 = 0;
    public static final int kController1 = 1;
}

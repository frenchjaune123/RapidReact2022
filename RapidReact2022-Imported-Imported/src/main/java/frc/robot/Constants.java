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
    // public static final int DRIVE_LEFT_VICTORSP1 = 12;

    public static final int DRIVE_RIGHT_VICTORSP0 = 5;
    // public static final int DRIVE_RIGHT_VICTORSP1 = 13;
    public static final int SHOOTER_VICTORSP0 = 0;

    //CAN Motors
    public static final int DRIVE_RIGHT_VENOM0 = 0;
    public static final int DRIVE_LEFT_VENOM0 = 1;

    //Controllers
    public static final int kController0 = 0;
    public static final int kController1 = 1;
}

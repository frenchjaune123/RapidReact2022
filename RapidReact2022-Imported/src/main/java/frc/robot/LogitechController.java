package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;

public class LogitechController extends Joystick {
    
    public LogitechController(int port) {
        super(port);
    }

    public double getXAxis() {
        return this.getX();
    }
    public double getYAxis() {
        return this.getY();
    }
    public double getZAxis() {
        return this.getZ();
    }

    
    
}

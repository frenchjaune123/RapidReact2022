package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj2.command.button.Trigger;

public class LogitechController extends Joystick {
   
    // public JoystickButton l_trigger1 = new Trigger();
    public JoystickButton l_trigger1 = new JoystickButton(this, 1);
    public JoystickButton l_button2 = new JoystickButton(this, 2); 
    public JoystickButton l_button3 = new JoystickButton(this, 3);  //this button for slow mode
    public JoystickButton l_button4 = new JoystickButton(this, 4);  //this button for shooter
    public JoystickButton l_button5 = new JoystickButton(this, 5);
    public JoystickButton l_button6 = new JoystickButton(this, 6);
    public JoystickButton l_button7 = new JoystickButton(this, 7);
    public JoystickButton l_button8 = new JoystickButton(this, 8);
    public JoystickButton l_button9 = new JoystickButton(this, 9);
    public JoystickButton l_button10 = new JoystickButton(this, 10);
    public JoystickButton l_button11 = new JoystickButton(this, 11);
    public JoystickButton l_button12 = new JoystickButton(this, 12);


    public LogitechController(int port) {
        super(port);
    }

    //Left is negative
    //Right is positive
    public double getXAxis() {
        return this.getX();
    }
   
    //Up is positive
    //Down is negative
    public double getYAxis() {
        return this.getY();
    }

    //CCW is negative
    //CW is positive
    public double getZAxis() {
        return this.getZ();
    }

    //Up is positive
    //Down is negative
    public double getThrottle() {
        return -this.getThrottle();
    }
    
    // public double getTrigger() {
    //     return this.getRawAxis(1);
    // }
}

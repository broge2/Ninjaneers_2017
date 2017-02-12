package org.usfirst.frc4156.Ninjaneers.subsystems;

import org.usfirst.frc4156.Ninjaneers.RobotMap;
import org.usfirst.frc4156.Ninjaneers.XBoxControllerMap;
import org.usfirst.frc4156.Ninjaneers.commands.AdjustShootingAngle;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class AngleShooterSubsystem extends Subsystem {

    private final CANTalon angleMotor = RobotMap.shootingSubSystemAngleMotor;
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	setDefaultCommand(new AdjustShootingAngle());
    }
    

    public void adjustAngle(Joystick controller){    	
    	double leftTrigger = controller.getRawAxis(XBoxControllerMap.LT);
    	double rightTrigger = controller.getRawAxis(XBoxControllerMap.RT);
    	if(leftTrigger > 0){
    		angleMotor.set(leftTrigger * 0.9);
    	} else if(rightTrigger > 0){
    		angleMotor.set(rightTrigger * -0.9);
    	}
//    	angleMotor.set(controller.getRawAxis(XBoxControllerMap.LT));
    }
    
    public void stopAdjusting(){
    	angleMotor.set(0);
    }
}


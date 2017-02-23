package org.usfirst.frc4156.Ninjaneers.subsystems;

import org.usfirst.frc4156.Ninjaneers.Robot;
import org.usfirst.frc4156.Ninjaneers.RobotMap;
import org.usfirst.frc4156.Ninjaneers.XBoxControllerMap;
import org.usfirst.frc4156.Ninjaneers.commands.AdjustShootingAngle;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.DigitalInput;
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
    	setDefaultCommand(new AdjustShootingAngle(Robot.oi.getXBOXController()));
    }
    
    public void adjustAngle(double velocity){  
    	angleMotor.set(velocity);
    }
    
    public void stopAdjusting(){
    	angleMotor.set(0);
    }
}


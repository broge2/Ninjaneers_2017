package org.usfirst.frc4156.Ninjaneers.commands;

import org.usfirst.frc4156.Ninjaneers.Robot;
import org.usfirst.frc4156.Ninjaneers.XBoxControllerMap;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class AdjustShootingAngle extends Command {
	
	private final Joystick controller;
	private double leftTrigger;
	private double rightTrigger;
    public AdjustShootingAngle(Joystick controller) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	this.controller = controller;
    	requires(Robot.angleShooterSubsystem);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	leftTrigger = controller.getRawAxis(XBoxControllerMap.LT);
    	rightTrigger = controller.getRawAxis(XBoxControllerMap.RT);
    	if(leftTrigger > 0.5){
    		Robot.angleShooterSubsystem.adjustAngle(leftTrigger * -0.5);
    	} else if(rightTrigger > 0.5){
    		Robot.angleShooterSubsystem.adjustAngle(rightTrigger * 0.5);
    	} else {
    		leftTrigger = 0;
    		rightTrigger = 0;
    	}
    	//Robot.angleShooterSubsystem.adjustAngle(Robot.oi.getXBOXController());
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	return leftTrigger == 0 && rightTrigger == 0;
        //return Robot.angleShooterSubsystem.isSwitchPressed();
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.angleShooterSubsystem.stopAdjusting();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	this.end();
    }
}

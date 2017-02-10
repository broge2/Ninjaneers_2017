package org.usfirst.frc4156.Ninjaneers.commands;

import org.usfirst.frc4156.Ninjaneers.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class AdjustShootingAngle extends Command {

    public AdjustShootingAngle() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.shootingSubSystem);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.shootingSubSystem.adjustAngle(Robot.oi.getXBOXController());
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.shootingSubSystem.stopAdjusting();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	this.end();
    }
}
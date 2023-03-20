package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveSubsystem;

public class AutoBalanceCommand extends CommandBase {
    private final DriveSubsystem driveSubsystem;
    private double roll;

    public AutoBalanceCommand (DriveSubsystem driveSubsystem)
    {
        this.driveSubsystem = driveSubsystem;
        this.addRequirements(driveSubsystem);
    }

    @Override 
    public void execute() 
    {
        // Move in direction opposite angle, and change speed 
        // based on angle.
        roll = driveSubsystem.getRoll();
        if (roll > 0)
        {
            driveSubsystem.arcadeDrive(0.2, 0);
        }
        else 
        {
            driveSubsystem.arcadeDrive(-0.2, 0);
        }
    }

    @Override 
    public boolean isFinished()
    {
        // Finished if angle is 
        return -5 < roll && roll < 5;
    }
}

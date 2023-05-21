package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveSubsystem;

public class DriveDistanceCommand extends CommandBase {
    private final DriveSubsystem driveSubsystem;
    private final double driveDistance;
    private double startPosition;
    private boolean isForward;

    public DriveDistanceCommand(DriveSubsystem driveSubsystem, double driveDistance, boolean isForward)
    {
        this.driveSubsystem = driveSubsystem;
        this.driveDistance = driveDistance;
        this.isForward = isForward;
        this.addRequirements(driveSubsystem);
    }
    
    @Override 
    public void initialize()
    {
        // Get current position
        driveSubsystem.resetEncoders();
        startPosition = driveSubsystem.getLeftPosition();
    }

    @Override
    public void execute()
    {
        // Drive forward
        driveSubsystem.arcadeDrive(isForward ? -.9 : .9 , 0);
    }

    @Override 
    public boolean isFinished()
    {
        var isFinished = Math.abs(driveSubsystem.getLeftPosition()) >= Math.abs(driveDistance);
        // Stop when we reach desired position
        //return Math.abs(driveSubsystem.getLeftPosition()) >= Math.abs(driveDistance);

        if (isFinished) 
        {
            driveSubsystem.resetEncoders();
            return true;
        }
        else 
        {
            return false;

        }
    }

    
}
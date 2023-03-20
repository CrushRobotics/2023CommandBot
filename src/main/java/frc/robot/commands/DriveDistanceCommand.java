package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveSubsystem;

public class DriveDistanceCommand extends CommandBase {
    private final DriveSubsystem driveSubsystem;
    private final double driveDistance;
    private double startPosition;

    public DriveDistanceCommand(DriveSubsystem driveSubsystem, double driveDistance)
    {
        this.driveSubsystem = driveSubsystem;
        this.driveDistance = driveDistance;
        this.addRequirements(driveSubsystem);
    }
    
    @Override 
    public void initialize()
    {
        // Get current position
        startPosition = driveSubsystem.getLeftPosition();
    }

    @Override
    public void execute()
    {
        // Drive forward
        driveSubsystem.arcadeDrive(0.5, 0);
    }

    @Override 
    public boolean isFinished()
    {
        // Stop when we reach desired position
        return Math.abs(driveSubsystem.getLeftPosition() - startPosition) >= driveDistance;
    }
}
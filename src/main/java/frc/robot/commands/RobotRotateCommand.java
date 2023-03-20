package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveSubsystem;

public class RobotRotateCommand extends CommandBase {
    private final DriveSubsystem driveSubsystem;
    private final double rotation;
    private double startAngle;

    public RobotRotateCommand (DriveSubsystem driveSubsystem, double rotation)
    {
        this.driveSubsystem = driveSubsystem;
        this.rotation = rotation;
        this.addRequirements(driveSubsystem);
    }

    @Override 
    public void initialize()
    {
        // Get the angle from the gyro
        startAngle = driveSubsystem.getHeading();
    }

    @Override 
    public void execute()
    {
        // Tell bot to rotate
        driveSubsystem.setTurnSpeed(0.5);
    }

    @Override 
    public boolean isFinished()
    {
        // Stop when bot has rotated 180 degrees
        double currentAngle = driveSubsystem.getHeading();
        return Math.abs(startAngle - currentAngle) >= rotation;
    }
}

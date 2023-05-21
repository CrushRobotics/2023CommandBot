package frc.robot.commands;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveSubsystem;

public class TestDriveCommand extends CommandBase {
    private final DriveSubsystem subsystem;
    private final XboxController controller;

    public TestDriveCommand(DriveSubsystem subsystem, XboxController controller)
    {
        this.subsystem = subsystem;
        this.controller = controller;
        addRequirements(subsystem);
    } 

    @Override
    public void execute()
    {
        /* 
        var matchTime = DriverStation.getMatchTime();
        if (matchTime > 145)
        {

        }
        else 
        {
            subsystem.arcadeDrive(controller.getLeftY(), controller.getRightX());
        }
        */
        
        subsystem.arcadeDrive(controller.getLeftY(), controller.getRightX());
    }

    @Override 
    public void end(boolean wasInterrupted)
    {
        subsystem.arcadeDrive(0, 0);
    }
}

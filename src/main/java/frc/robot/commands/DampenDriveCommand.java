package frc.robot.commands;

import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveSubsystem;

public class DampenDriveCommand extends CommandBase {
    private DriveSubsystem driveSubsystem;
    private DoubleSupplier dampenAmt;

    public DampenDriveCommand (DriveSubsystem driveSubsystem, DoubleSupplier dampenAmt)
    {
        this.driveSubsystem = driveSubsystem;
        this.dampenAmt = dampenAmt;
        this.addRequirements(driveSubsystem);
    }

    @Override
    public void initialize()
    {
        driveSubsystem.setDampenFactor(dampenAmt.getAsDouble());
    }

    @Override
    public void end(boolean interrupted)
    {
        driveSubsystem.setDampenFactor(1.0);
    }
}

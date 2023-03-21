package frc.robot.commands;

import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.ElevatorSubsystem;

public class ManualElevatorComand extends CommandBase {
    private final ElevatorSubsystem subsystem;
    private DoubleSupplier speed;

    public ManualElevatorComand(ElevatorSubsystem subsystem, DoubleSupplier speed)
    {
        this.subsystem = subsystem; 
        this.speed = speed;
        addRequirements(subsystem);
    }

    @Override 
    public void execute()
    {
        subsystem.setElevatorVolts(speed.getAsDouble());
    }
    
}

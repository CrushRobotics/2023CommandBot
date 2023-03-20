package frc.robot.commands;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.ElevatorSubsystem;

public class ManualElevatorComand extends CommandBase {
    private final ElevatorSubsystem subsystem;

    public ManualElevatorComand(ElevatorSubsystem subsystem)
    {
        this.subsystem = subsystem; 
        addRequirements(subsystem);
    }

    @Override 
    public void execute()
    {
        subsystem.setElevatorVolts(-1);
    }

    
}

package frc.robot.commands;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.ElevatorSubsystem;
import frc.robot.Helpers;

public class TestElevatorCommand extends CommandBase {
    private final ElevatorSubsystem subsystem;
    private final XboxController controller;

    public TestElevatorCommand(ElevatorSubsystem subsystem, XboxController controller)
    {
        this.subsystem = subsystem;
        this.controller = controller;
        addRequirements(subsystem);
    } 

    @Override
    public void execute()
    {
        subsystem.setSpeed(Helpers.FilterDeadband(Helpers.SquareInput(controller.getLeftY())));
    }

    @Override 
    public void end(boolean wasInterrupted)
    {
        subsystem.setSpeed(0);
    }
    
}

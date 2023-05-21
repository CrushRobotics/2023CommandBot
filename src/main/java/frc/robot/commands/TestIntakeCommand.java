package frc.robot.commands;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Helpers;
import frc.robot.subsystems.IntakeSubsystem;

public class TestIntakeCommand extends CommandBase {
    private final IntakeSubsystem subsystem;
    private final XboxController armController;

    public TestIntakeCommand(IntakeSubsystem intakeSubsystem, XboxController armController)
    {
        this.subsystem = intakeSubsystem;
        this.armController = armController;
    }

    @Override 
    public void initialize()
    {
        subsystem.resetEncoders();
    }

    @Override 
    public void execute()
    {
        if (armController.getXButton())
        {
            subsystem.activate();
        }
        
        if (armController.getYButton())
        {
            subsystem.deactivate();
        }
    }
}

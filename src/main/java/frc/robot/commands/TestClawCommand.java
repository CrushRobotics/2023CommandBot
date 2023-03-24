package frc.robot.commands;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Helpers;
import frc.robot.subsystems.ClawSubsystem;

public class TestClawCommand extends CommandBase {
    private final ClawSubsystem subsystem;
    private final XboxController controller;

    public TestClawCommand(ClawSubsystem subsystem, XboxController controller)
    {
        this.subsystem = subsystem;
        this.controller = controller;
        addRequirements(subsystem);
    } 

    @Override
    public void execute()
    {
        // Claw section
        var leftValue = controller.getLeftTriggerAxis();
        var rightValue = controller.getRightTriggerAxis();
        var value = leftValue > 0 ? leftValue : -rightValue;

        subsystem.moveClaw(Helpers.FilterDeadband(Helpers.SquareInput(value)));

        // Intake section
        var runIntake = controller.getAButton();

        if (runIntake)
        {
            subsystem.runIntake(0.5);
        }
        else 
        {
            subsystem.runIntake(0);
        }
    }

    @Override 
    public void end(boolean wasInterrupted)
    {
        subsystem.moveClaw(0);
    }

}

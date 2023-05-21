package frc.robot.commands;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Helpers;
import frc.robot.helpers.AutoHoldCalculator;
import frc.robot.subsystems.ArmSubsystem;

public class TestArmCommand extends CommandBase {
    private final ArmSubsystem subsystem;
    private final XboxController controller;
    private final AutoHoldCalculator autoHoldCalc;

    public TestArmCommand(ArmSubsystem subsystem, XboxController controller)
    {
        this.subsystem = subsystem;
        this.controller = controller;
        this.autoHoldCalc = new AutoHoldCalculator();
        addRequirements(subsystem);
    } 

    @Override
    public void execute()
    {
        var moveSpeed = Helpers.FilterDeadband(Helpers.SquareInput(controller.getRightY()));
        subsystem.swing(moveSpeed);

        /* 
        if (moveSpeed != 0)
        {
            subsystem.swing(moveSpeed);
        }
        else 
        {
            var position = subsystem.getPosition();
            //position = Math.round(position);
            moveSpeed = autoHoldCalc.calculate(-subsystem.getPosition());
            subsystem.swing(-moveSpeed);
        }
        */
    }

    @Override 
    public void end(boolean wasInterrupted)
    {
        subsystem.swing(0);
    }

}

package frc.robot.commands;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.ElevatorSubsystem;

public class DefaultElevatorCommand extends CommandBase {
    
    final XboxController controller;
    final ElevatorSubsystem elevatorSubsystem;

    public DefaultElevatorCommand(XboxController controller, ElevatorSubsystem elevatorSubsystem) {
        this.controller = controller;
        this.elevatorSubsystem = elevatorSubsystem;
        this.addRequirements(elevatorSubsystem);
    }

    @Override
    public void execute() {
        
        double height = controller.getRightY();

        elevatorSubsystem.move(height);
    }
}
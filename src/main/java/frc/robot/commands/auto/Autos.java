// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.auto;

import frc.robot.commands.DriveDistanceCommand;
import frc.robot.commands.ExampleCommand;
import frc.robot.commands.RobotRotateCommand;
import frc.robot.subsystems.DriveSubsystem;
import frc.robot.subsystems.ExampleSubsystem;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.Commands;

public final class Autos {
  /** Example static factory for an autonomous command. */
  public static CommandBase exampleAuto(ExampleSubsystem subsystem) {
    return Commands.sequence(subsystem.exampleMethodCommand(), new ExampleCommand(subsystem));
  }
  
  public static CommandBase scoreTwiceAuto(DriveSubsystem driveSubsystem)
  {
    return Commands.sequence(
      new DriveDistanceCommand(driveSubsystem, 5),
      new RobotRotateCommand(driveSubsystem, 90), 
      new DriveDistanceCommand(driveSubsystem, 3));
  }

  private Autos() {
    throw new UnsupportedOperationException("This is a utility class!");
  }

}

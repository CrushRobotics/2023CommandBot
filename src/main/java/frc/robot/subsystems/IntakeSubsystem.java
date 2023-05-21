package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class IntakeSubsystem extends SubsystemBase {
    private CANSparkMax intakeMotor;
    private RelativeEncoder encoder;
    private final double minPosition = 0;
    private final double maxPosition = 100;
    public void init()
    {
        // Setup motor
        intakeMotor = new CANSparkMax(8, MotorType.kBrushless);

        // Setup encoder
        encoder = intakeMotor.getEncoder();
    }

    public void activate()
    {
        if (getPosition() < maxPosition)
        {
            intakeMotor.set(0.5);
        }
        else 
        {
            intakeMotor.set(0);
        }
    }

    public void deactivate()
    {
        if (getPosition() > minPosition)
        {
            intakeMotor.set(-0.5);
        }
        else 
        {
            intakeMotor.set(0);
        }
    }

    public void resetEncoders() {
        encoder.setPosition(0);
    }

    public double getPosition()
    {
        return encoder.getPosition();
    }

    public void setSpeed(double speed) {

    }
}

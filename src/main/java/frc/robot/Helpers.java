package frc.robot;

public class Helpers {
    public static double FilterDeadband(double value)
    {
        if (Math.abs(value) <= 0.02)
            return 0;
        
        return value;
    }

    public static double SquareInput(double input)
    {
        var squared = input * input;
        
        if (input < 0)
            return -squared;

        return squared;
    }
}

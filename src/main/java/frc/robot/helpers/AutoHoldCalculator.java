package frc.robot.helpers;


public class AutoHoldCalculator 
{
    private double lastPosition;
    private double lastValue;
    private boolean hasLastValue;

    public AutoHoldCalculator()
    {
        hasLastValue = false;
    }

    public void reset()
    {
        hasLastValue = false;
        lastValue = 0;
        lastPosition = 0;
    }

    public double calculate(double nextPosition)
    {
        double value = 0;
        if (!hasLastValue)
        {
            value = 0;
        }

        if (nextPosition < lastPosition)
        {
            value = lastValue + 0.02;
        }

        if (nextPosition > lastPosition) 
        {
            value = lastValue - 0.01;
        }

        lastValue = value;
        hasLastValue = true;
        lastPosition = nextPosition;
        return value;
    }
}
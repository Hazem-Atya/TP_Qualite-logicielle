package com.directi.training.isp.exericise_solution;

import java.util.TimerTask;

public class Timer
{
    public void register(long timeOut, final TimingDevice dev)
    {
        java.util.Timer timerUtility = new java.util.Timer();
        timerUtility.schedule(new TimerTask()
        {
            @Override
            public void run()
            {
                dev.timeOutCallback();
            }
        }, timeOut);
    }
}

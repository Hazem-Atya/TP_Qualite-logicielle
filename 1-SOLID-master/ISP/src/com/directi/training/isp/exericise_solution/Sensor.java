package com.directi.training.isp.exericise_solution;

import java.util.Random;

public class Sensor
{
    public void register(SensingDevice dev)
    {
        while (true) {
            if (isPersonClose()) {
                dev.proximityCallback();
                break;
            }
        }
    }

    private boolean isPersonClose()
    {
        return new Random().nextBoolean();
    }
}

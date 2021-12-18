package com.directi.training.ocp.exemplesolution;

public class TimeSlot implements Resource{

    @Override
    public int allocate() {
        int resourceId = findFreeTimeSlot();
        markTimeSlotBusy(resourceId);
        return 0;
    }

    @Override
    public void free() {

    }
    private void markTimeSlotFree(int resourceId)
    {
    }
    private int findFreeTimeSlot()
    {
        return 0;
    }

}

package com.directi.training.ocp.exercise_solution;

public interface Resource {

     void markSlotFree(int resourceId) ;

     void markSlotBusy(int resourceId) ;

     int findFreeSlot();
}



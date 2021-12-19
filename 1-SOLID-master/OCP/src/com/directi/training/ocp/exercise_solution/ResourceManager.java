package com.directi.training.ocp.exercise_solution;

public class ResourceManager {
    public int allocate(Resource resource) {
        int resourceId = resource.findFreeSlot();
        resource.markSlotBusy(resourceId);
        return resourceId;
    }

    public void free(Resource resource, int resourceId) {
        resource.markSlotFree(resourceId);
    }

}

package service.impl;

import service.ParkingSpotManager;
import strategies.impl.NearestToTargetFindSpotStrategy;

import java.util.ArrayList;

public class FourWheelerParkingSpotManager extends ParkingSpotManager {
    //Singleton

    private static volatile FourWheelerParkingSpotManager fourWheelerParkingSpotManager;

    private FourWheelerParkingSpotManager() {
        super(new ArrayList<>(), new NearestToTargetFindSpotStrategy());
    }

    public static FourWheelerParkingSpotManager getInstance() {
        if (fourWheelerParkingSpotManager == null) {
            synchronized (FourWheelerParkingSpotManager.class) {
                if (fourWheelerParkingSpotManager == null) {
                    fourWheelerParkingSpotManager = new FourWheelerParkingSpotManager();
                }
            }
        }
        return fourWheelerParkingSpotManager;
    }
}

package service.impl;

import service.ParkingSpotManager;
import strategies.impl.RandomFindSpotStrategy;

import java.util.ArrayList;

public class TwoWheelerParkingSpotManager extends ParkingSpotManager {
    //Singleton

    private static volatile TwoWheelerParkingSpotManager twoWheelerParkingSpotManager;

    private TwoWheelerParkingSpotManager() {
        super(new ArrayList<>(), new RandomFindSpotStrategy());
    }

    public static TwoWheelerParkingSpotManager getInstance() {
        if (twoWheelerParkingSpotManager == null) {
            synchronized (TwoWheelerParkingSpotManager.class) {
                if (twoWheelerParkingSpotManager == null) {
                    twoWheelerParkingSpotManager = new TwoWheelerParkingSpotManager();
                }
            }
        }
        return twoWheelerParkingSpotManager;
    }
}

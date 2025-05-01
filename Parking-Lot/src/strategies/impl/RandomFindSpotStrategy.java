package strategies.impl;

import service.ParkingSpot;
import strategies.FindParkingSpotStrategy;

import java.util.List;

public class RandomFindSpotStrategy implements FindParkingSpotStrategy {
    @Override
    public ParkingSpot findSpot(List<ParkingSpot> parkingSpotList, int target) {
        for(ParkingSpot parkingSpot: parkingSpotList) {
            if (parkingSpot.isEmpty()) {
                return parkingSpot;
            }
        }
        return null;
    }
}

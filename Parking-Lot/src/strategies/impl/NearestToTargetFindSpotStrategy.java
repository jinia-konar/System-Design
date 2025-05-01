package strategies.impl;

import service.ParkingSpot;
import strategies.FindParkingSpotStrategy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class NearestToTargetFindSpotStrategy implements FindParkingSpotStrategy {
    @Override
    public ParkingSpot findSpot(List<ParkingSpot> recievedParkingSpotList, int target) {
        //return parking spot nearest to target
        List<ParkingSpot> parkingSpotList = new ArrayList<>();
        recievedParkingSpotList.forEach(recievedParkingSpot -> {
            if (recievedParkingSpot.isEmpty()) {
                parkingSpotList.add(recievedParkingSpot);
            }
        });
        parkingSpotList.sort((a, b) -> a.getParkingSpotId() - b.getParkingSpotId());
        if (parkingSpotList.isEmpty()) return null;
        return parkingSpotList.getFirst();
    }
}

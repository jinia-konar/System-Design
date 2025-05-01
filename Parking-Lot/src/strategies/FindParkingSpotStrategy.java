package strategies;

import service.ParkingSpot;

import java.util.List;

public interface FindParkingSpotStrategy {
    ParkingSpot findSpot(List<ParkingSpot> parkingSpotList, int target);
}

package LLD.ParkingLot.Strategy.Fee;

import LLD.ParkingLot.Entities.ParkingTicket;
import LLD.ParkingLot.Vehicle.VehicleSize;

import java.util.Map;

public class VehicleBasedFeeStrategy implements FeeStrategy{
    private static final Map<VehicleSize, Double> PER_HOUR = Map.of(
            VehicleSize.SMALL , 10.0,
            VehicleSize.MEDIUM, 20.0,
            VehicleSize.LARGE, 30.0
    );

    @Override
    public double calculateFee(ParkingTicket ticket) {
        Long duration = ticket.getExitTimeStamp() - ticket.getEntryTimeStamp();
        double fee = duration/(1000 * 60 * 60) +1;
        return fee * PER_HOUR.get(ticket.getVehicle().getVehicleSize());
    }
}

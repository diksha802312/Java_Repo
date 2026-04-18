package LLD.ParkingLot.Strategy.Fee;

import LLD.ParkingLot.Entities.ParkingTicket;

public interface FeeStrategy {
    public double calculateFee(ParkingTicket ticket);
}

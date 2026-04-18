package LLD.ParkingLot.Strategy.Fee;

import LLD.ParkingLot.Entities.ParkingTicket;

public class FlatRateFeeStrategy implements FeeStrategy {
    private static final double PER_HOUR = 10.0;

    @Override
    public double calculateFee(ParkingTicket ticket) {
        Long duration = ticket.getExitTimeStamp()- ticket.getEntryTimeStamp();
        double fee = duration/(1000 * 60 * 60) + 1;
        return fee * PER_HOUR;
    }

}

package LLD.ParkingLot.Entities;

import LLD.ParkingLot.Vehicle.Vehicle;

import java.util.Date;
import java.util.UUID;

public class ParkingTicket {
    private ParkingSpot spot;
    private String ticketId;
    private long entryTimeStamp;
    private long exitTimeStamp;
    private Vehicle vehicle;

    public ParkingTicket(ParkingSpot spot, Vehicle vehicle){
        this.spot = spot;
        this.ticketId = UUID.randomUUID().toString();
        this.entryTimeStamp = new Date().getTime();
        this.vehicle = vehicle;
    }
    public ParkingSpot getSpot() {
        return spot;
    }

    public String getTicketId() {
        return ticketId;
    }

    public long getEntryTimeStamp() {
        return entryTimeStamp;
    }

    public long getExitTimeStamp() {
        return exitTimeStamp;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setExitTimeStamp(long exitTimeStamp) {
        this.exitTimeStamp = new Date().getTime();
    }

}

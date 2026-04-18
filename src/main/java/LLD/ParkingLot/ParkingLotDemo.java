package LLD.ParkingLot;

import LLD.ParkingLot.Entities.ParkingFloor;
import LLD.ParkingLot.Entities.ParkingSpot;
import LLD.ParkingLot.Entities.ParkingTicket;
import LLD.ParkingLot.Vehicle.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ParkingLotDemo {
    public static void main(String[] args){
        ParkingLot parkingLot = ParkingLot.getInstance();

        ParkingFloor floor1 = new ParkingFloor(1);
        floor1.addSpot(new ParkingSpot("1F-S", VehicleSize.SMALL));
        floor1.addSpot(new ParkingSpot("1F-M", VehicleSize.MEDIUM));
        floor1.addSpot(new ParkingSpot("1F-L", VehicleSize.LARGE));


        ParkingFloor floor2 = new ParkingFloor(2);
        floor2.addSpot(new ParkingSpot("2F-M", VehicleSize.MEDIUM));
        floor2.addSpot(new ParkingSpot("2F-L", VehicleSize.LARGE));

        parkingLot.addFloor(floor1);
        parkingLot.addFloor(floor2);

        Vehicle car = new Car("C-123");
        Vehicle truck = new Truck("T-123");
        Vehicle bike = new Bike("B-123");

        System.out.println("Vehicke Enteries:");
        floor1.displayAvalability();
        floor2.displayAvalability();

        parkingLot.parkVehicle(bike);
        parkingLot.parkVehicle(car);
        parkingLot.parkVehicle(truck);

        System.out.println("Available spots after parking:");
        floor1.displayAvalability();
        floor2.displayAvalability();

        Vehicle car2 = new Car("C-456");
        Vehicle bike2 = new Bike("B-456");
        Vehicle truck2 = new Truck("T-456");

       Optional<ParkingTicket> car2Ticket = parkingLot.parkVehicle(car2);
        parkingLot.parkVehicle(bike2);
        parkingLot.parkVehicle(truck2);

        System.out.println("Available spots after parking:");
        floor1.displayAvalability();
        floor2.displayAvalability();

        parkingLot.unParkVehicle(car2);





    }
}

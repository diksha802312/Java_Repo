package LLD.ParkingLot.Vehicle;

public class Vehicle {
    private VehicleSize vehicleSize;
    private String licenseNumber;

    public Vehicle(VehicleSize vehicleSize, String licenseNumber){
        this.vehicleSize = vehicleSize;
        this.licenseNumber = licenseNumber;
    }

    public String getLicenseNumber() {
        return licenseNumber;
    }

    public VehicleSize getVehicleSize() {
        return vehicleSize;
    }
}

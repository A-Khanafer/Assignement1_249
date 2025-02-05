package vehicles;

public class Vehicle {

    protected String plateNumber;
    protected String model;
    protected String make;
    protected int year;

    public Vehicle(String model, String make, int year) {
        this.model = model;
        this.make = make;
        this.year = year;
    }

    public Vehicle() {
        model = "";
        make = "";
        year = 0;
    }

    public Vehicle(Vehicle vehicle){
        this.model = vehicle.model;
        this.make = vehicle.make;
        this.year = vehicle.year;
    }


}

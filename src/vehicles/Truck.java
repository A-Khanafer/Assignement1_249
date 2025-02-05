package vehicles;

public class Truck extends Vehicle {

    private double maxCapacity;
    private static int numberOfTrucks = 1000;

    public Truck() {
        super();
        maxCapacity = 0;
    }

    public Truck(String model, String make, int year, int maxCapacity) {
        super(model, make, year);
        this.maxCapacity = maxCapacity;
    }



}

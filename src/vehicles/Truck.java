package vehicles;

public class Truck extends Vehicle {

    protected double maxCapacity;

    public Truck() {
        super();
        maxCapacity = 0;
    }

    public Truck(String model, String make, int year, int maxCapacity) {
        super(model, make, year);
        this.maxCapacity = maxCapacity;
    }

    public Truck(Truck truck) {
        super(truck);
        this.maxCapacity = maxCapacity;
    }




}

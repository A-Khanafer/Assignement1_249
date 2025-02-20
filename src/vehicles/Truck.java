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

    public double getMaxCapacity() {
        return maxCapacity;
    }
    public void setMaxCapacity(double maxCapacity) {
        this.maxCapacity = maxCapacity;
    }

    @Override
    public String toString() {
        return super.toString() + " " + maxCapacity;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Truck truck = (Truck) o;
        return super.equals(truck) && maxCapacity == truck.maxCapacity;
    }
}

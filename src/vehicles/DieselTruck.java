package vehicles;

public class DieselTruck extends Truck {

    private double tankCapacity;
    private static int numberOfTrucks = 1000;

    public DieselTruck() {
        super();
        tankCapacity = 0;
    }

    public DieselTruck(String model, String make, int year, int maxCapacity, double tankCapacity) {
        super(model, make, year, maxCapacity);
        this.tankCapacity = tankCapacity;
        generatePlate();
    }

    public DieselTruck(DieselTruck dieselTruck) {
        super(dieselTruck);
        this.tankCapacity = dieselTruck.tankCapacity;
        this.plateNumber = dieselTruck.plateNumber;
    }

    public double getTankCapacity() {
        return tankCapacity;
    }

    public void setTankCapacity(double tankCapacity) {
        this.tankCapacity = tankCapacity;
    }

    private void generatePlate(){
        plateNumber = "DT" + ++numberOfTrucks;
    }

    @Override
    public String toString() {
        return super.toString() + " " + tankCapacity ;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        DieselTruck dieselTruck = (DieselTruck) o;
        return super.equals(dieselTruck) && tankCapacity == dieselTruck.tankCapacity;
    }

}

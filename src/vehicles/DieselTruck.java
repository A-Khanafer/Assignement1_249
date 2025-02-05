package vehicles;

public class DieselTruck extends Truck {

    private double tankCapacity;
    private static int numberOfTrucks = 1000;

    public DieselTruck() {
        super();
        tankCapacity = 0;
        generatePlate();
    }

    public DieselTruck(String model, String make, int year, int maxCapacity, double tankCapacity) {
        super(model, make, year, maxCapacity);
        this.tankCapacity = tankCapacity;
        generatePlate();
    }

    public DieselTruck(DieselTruck dieselTruck) {
        super(dieselTruck);
        this.tankCapacity = dieselTruck.tankCapacity;
        generatePlate();
    }

    private void generatePlate(){
        plateNumber = "DT" + ++numberOfTrucks;
    }

}

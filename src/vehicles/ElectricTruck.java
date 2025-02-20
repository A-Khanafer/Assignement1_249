package vehicles;

public class ElectricTruck extends Truck {

    private double range;
    private static int numberOfElectricTrucks = 1000;

    public ElectricTruck() {
        super();
        range = 0;
        generatePlate();
    }

    public ElectricTruck(String model, String make, int year, int maxCapacity, double range) {
        super(model, make, year, maxCapacity);
        this.range = range;
        generatePlate();
    }

    public ElectricTruck(ElectricTruck electricTruck) {
        super(electricTruck);
        this.range = electricTruck.range;
        generatePlate();
    }

    public double getRange() {
        return range;
    }
    public void setRange(double range) {
        this.range = range;
    }
    private void generatePlate(){
        plateNumber = "ET" + ++numberOfElectricTrucks;
    }

    @Override
    public String toString() {
        return super.toString() + " " + range ;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        ElectricTruck electricTruck = (ElectricTruck) o;
        return super.equals(electricTruck) && range == electricTruck.range;
    }

}

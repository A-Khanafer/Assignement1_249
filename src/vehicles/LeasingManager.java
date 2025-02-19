package vehicles;

public class LeasingManager {
    private int numbVehiclesPerClient;

    Vehicle[] leaseManager = new Vehicle[numbVehiclesPerClient];

    public void addVehicle(Vehicle vehicle) {
        numbVehiclesPerClient++;
        for (int i = 0; i < numbVehiclesPerClient; i++) {
            if (leaseManager[i] == null) {
                leaseManager[i] = vehicle;
            }
        }
    }

    public void returnVehicle(Vehicle vehicle) {

    }



}

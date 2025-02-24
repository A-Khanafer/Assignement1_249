package vehicles;

import clients.Client;

public class LeasingList {

    private VehicleManagement leasedVehiclesForAClient;

    public LeasingList() {
        leasedVehiclesForAClient = new VehicleManagement();
    }

    public LeasingList(Vehicle[] leaseManager) {
        leasedVehiclesForAClient = new VehicleManagement(leaseManager);
    }

    public LeasingList(LeasingList other) {
        leasedVehiclesForAClient = new VehicleManagement(other.leasedVehiclesForAClient);
    }

    public void lease(Vehicle vehicle) {
        leasedVehiclesForAClient.addVehicle(vehicle);
    }

    public void returnVehicle(Vehicle vehicle) {
        leasedVehiclesForAClient.deleteVehicle(vehicle.getPlateNumber());
    }

    public String toString(){
        return leasedVehiclesForAClient.toString();
    }
}

package clients;

import vehicles.LeasingList;
import vehicles.Vehicle;
import vehicles.VehicleManagement;

public class ClientManager{

    private Client[] clientManager;
    private int clientCount;
    private VehicleManagement vehicleData;

    //ask the user, before launching the program to input how many clients MAXIMUM their system will take.
    public ClientManager(int numClients,VehicleManagement vehicleData) {
        clientManager = new Client[numClients];
        clientCount = numClients;
        this.vehicleData = new VehicleManagement(vehicleData);
    }

    public ClientManager() {
        clientManager = new Client[0];
        clientCount = 0;
        vehicleData = new VehicleManagement();
    }

    public void addClient(String name, String email, String phoneNumber, String address , LeasingList leasingList) {
        boolean found = false;
        for (int i = 0; i < clientCount; i++) {
            if (clientManager[i]!=null && clientManager[i].equals(new Client(name, email, phoneNumber, address, leasingList))) {
                found = true;
                System.out.println("Client already in Database.");
                break;
            }
        }
        if (!found) {
           Client[] temp = new Client[++clientCount];

           for(int i = 0; i < clientManager.length; i++) {

               if(clientManager[i]!=null)
                   temp[i] = new Client(clientManager[i]);

           }
           temp[clientCount-1] = new Client(name, email, phoneNumber, address, leasingList);
           clientManager = temp;
           System.out.println("Client added");
        }
    }

    public void addClient(Client client) {
        boolean found = false;
        for (int i = 0; i < clientCount; i++) {
            if (clientManager[i]!=null && clientManager[i].equals(client)) {
                found = true;
                System.out.println("Client already in Database.");
                break;
            }
        }
        if (!found) {
            Client[] temp = new Client[++clientCount];

            for(int i = 0; i < clientManager.length; i++) {

                if(clientManager[i]!=null)
                    temp[i] = new Client(clientManager[i]);

            }
            temp[clientCount-1] = new Client(client);
            clientManager = temp;
            System.out.println("Client added");
        }
    }

    public void deleteClient(String name, String email, String phoneNumber, String address, LeasingList leasingList) {
        int index = -1;
        for (int i = 0; i < clientCount; i++) {

            if (clientManager[i]!=null && clientManager[i].equals(new Client(name, email, phoneNumber, address,leasingList))) {
                index = i;
                break;
            }
        }
        if (index>-1){

            Client[] temp = new Client[--clientCount];

            for (int i = 0; i < index; i++) {
                temp[i] = clientManager[i];
            }

            for (int i = index ; i < clientCount; i++) {
                temp[i] = clientManager[i+1];
            }
            clientManager = temp;

            System.out.println("Client {" + name +" // "+ email +" // "+ phoneNumber +" // "+ address + "} has been deleted.");
        }
        else {
            System.out.println("Client {" + name +" // "+ email +" // "+ phoneNumber +" // "+ address + "} does not exist.");
        }
    }

    public void deleteClient(Client client) {
        int index = -1;
        for (int i = 0; i < clientCount; i++) {

            if (clientManager[i]!=null && clientManager[i].equals(new Client(client))) {
                index = i;
                break;
            }
        }
        if (index>-1){
            for(Vehicle v : clientManager[index].getLeasingList().getLeasedVehiclesForAClient()){
                v.returnVehicle();
            }

            Client[] temp = new Client[--clientCount];

            for (int i = 0; i < index; i++) {
                temp[i] = clientManager[i];
            }

            for (int i = index ; i < clientCount; i++) {
                temp[i] = clientManager[i+1];
            }
            clientManager = temp;

            System.out.println("Client {" + client + "} has been deleted.");
        }
        else {
            System.out.println("Client {" + client + "} does not exist.");
        }

    }

    public void editClient(Client client, String input, int choice) {
        int index = -1;
        for (int i = 0; i < clientCount; i++) {
            if (clientManager[i] != null && clientManager[i].equals(client)) {
                index = i;
                break;
            }
        }
        if (index > -1) {

                switch (choice) {
                    case 1:
                        clientManager[index].setName(input);
                        System.out.println("Client name has been updated.");
                        break;
                    case 2:
                        clientManager[index].setEmail(input);
                        System.out.println("Client email has been updated.");
                        break;
                    case 3:
                        clientManager[index].setAddress(input);
                        System.out.println("Client address has been updated.");
                        break;
                    case 4:
                        clientManager[index].setPhoneNumber(input);
                        System.out.println("Client phone number has been updated.");
                        break;
                    default:
                        System.out.println("No modification has been made.");
                        break;

            }
        } else System.out.println("Client {" + client + "} does not exist.");
    }

    public void showAllLeasedVehiclesByAClient(Client client){
        int index = -1;
        for (int i = 0; i < clientCount; i++) {
            if (clientManager[i] != null && clientManager[i].equals(client)) {
                index = i;
                break;
            }
        }
        if (index > -1) {
            System.out.println(clientManager[index].showAllVehicles());
        } else{
            System.out.println("Client {" + client.getName() + "} does not exist.");
        }
    }

    public void showAllLeasedVehicles(){
        for (int i = 0; i < clientCount; i++) {
            System.out.println(clientManager[i].showAllVehicles()+ "\n");
        }
    }

    public void addLeasedVehicle(Client client , String plateNumber) {
        int index = -1;
        for (int i = 0; i < clientCount; i++) {
            if (clientManager[i]!=null && clientManager[i].equals(client)) {
                index = i;
                break;
            }
        }
        boolean found = false;
        if(index>-1){
            for(Vehicle v : vehicleData.getVehiclesManager()){
                if(v.getPlateNumber().equals(plateNumber) && !v.isLeased()) {
                    v.leaseVehicle();
                    clientManager[index].addVehicle(v);
                    System.out.println(v.isLeased());
                    found = true;
                    break;
                }
            }
            if (!found) {
                System.out.println("Vehicle " + plateNumber + " does not exist or is already leased.");
            }
        }else System.out.println("Client {" + client + "} does not exist.");
    }

    public void returnLeasedVehicle(Client client, String plateNumber) {
        int index = -1;
        for (int i = 0; i < clientCount; i++) {
            if (clientManager[i]!=null && clientManager[i].equals(client)) {
                index = i;
                break;
            }
        }
        boolean found = false;
        if(index>-1){
            for(Vehicle v : vehicleData.getVehiclesManager()){
                if(v.getPlateNumber().equals(plateNumber) && v.isLeased()) {
                    clientManager[index].returnVehicle(v);
                    v.returnVehicle();
                    found = true;
                    break;
                }
            }
            if (!found) {
                System.out.println("Vehicle " + plateNumber + " does not exist or is not leased.");
            }
        }else System.out.println("Client {" + client + "} does not exist.");
    }

    @Override
    public String toString() {
        String s = "";
        for (int i = 0; i < clientCount; i++) {
            s += clientManager[i].toString() +"\n";
        }
        s += clientCount;
        return s;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;

        ClientManager that = (ClientManager) o;
        boolean equals = true;

        if (clientCount != that.clientCount) return false;

        for (int i = 0; i < clientCount; i++) {
            equals = clientManager[i].equals(that.clientManager[i]);
            if (!equals) {
                return false;
            }
        }
        return equals;
    }

    public int getClientCount() {
        return clientCount;
    }

    public void setVehicleData(VehicleManagement vm) {
        vehicleData = vm;
    }
}
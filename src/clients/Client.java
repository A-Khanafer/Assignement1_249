package clients;

import vehicles.LeasingList;
import vehicles.Vehicle;

public class Client {

    private String name;
    protected String email;
    private String phoneNumber;
    private String address;
    private LeasingList leasingList;

    public Client(String name, String email, String phoneNumber, String address, LeasingList leasingList) {
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.leasingList = new LeasingList(leasingList);

    }

    public Client(){
        this.name = "";
        this.email = "";
        this.phoneNumber = "";
        this.address = "";
        this.leasingList = new LeasingList();
    }


    public Client(Client copy){
        this.name = copy.name;
        this.email = copy.email;
        this.phoneNumber = copy.phoneNumber;
        this.address = copy.address;
        this.leasingList = new LeasingList(copy.leasingList);
    }

    public Client(String clientName, String clientEmail, String clientPhone, String clientAddress) {
        this.name = clientName;
        this.email = clientEmail;
        this.phoneNumber = clientPhone;
        this.address = clientAddress;
        this.leasingList = new LeasingList();
    }

    public String getName() {
            return name;
    }

    public String getEmail() {
            return email;
    }

    public String getPhoneNumber() {
            return phoneNumber;
    }

    public String getAddress() {
            return address;
    }

    public void setName(String name) {
            this.name = name;
    }

    public void setEmail(String email) {
            this.email = email;
    }

    public void setPhoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
    }

    public void setAddress(String address) {
            this.address = address;
    }

    public void addVehicle(Vehicle vehicle){
        leasingList.lease(vehicle);
    }

    public void returnVehicle(Vehicle vehicle){
        leasingList.returnVehicle(vehicle);
    }

    public void showAllVehicles(){
        System.out.println(leasingList);
    }


    @Override
    public String toString() {
        return "Client{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", address='" + address + '\'' +
                "Leased Vehicles=" + leasingList +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == null || obj.getClass() != this.getClass()){
            return false;
        }
        Client other = (Client)obj;
        return this.name.equals(other.name)
                && this.email.equals(other.email)
                && this.phoneNumber.equals(other.phoneNumber)
                && this.address.equals(other.address);
    }



}

package clients;

import vehicles.LeasingManager;

public class Client {

    private String name;
    protected String email;
    private String phoneNumber;
    private String address;

    LeasingManager[] leaseList = new LeasingManager[3];







    public Client(String name, String email, String phoneNumber, String address) {
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.address = address;

    }

    public Client(){
        this.name = "";
        this.email = "";
        this.phoneNumber = "";
        this.address = "";


    }


public Client(Client copy){
        this.name = copy.name;
        this.email = copy.email;
        this.phoneNumber = copy.phoneNumber;
        this.address = copy.address;
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

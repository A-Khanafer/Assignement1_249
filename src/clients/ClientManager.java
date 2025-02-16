package clients;

public class ClientManager extends Client {

    private Client[] clientManager;

    public ClientManager(int numClients) {
        clientManager = new Client[numClients];
    }

    public void addClient(String name, String email, String phoneNumber, String address) {
        int index = -1;
        for (int i = 0; i < clientManager.length; i++) {
            if (clientManager[i]!=null && clientManager[i].getEmail().equals(email)) {
                index = i;
                break;
            }
            if (index > -1) {
                System.out.println("Client email already in use");
            }
            else {
                clientManager[Client.clientCount] = new Client(name, email, phoneNumber, address);
            }
        }

    }


    public void deleteClient(String email) {
        int index = -1;
        for (int i = 0; i < clientManager.length; i++) {
            if (clientManager[i]!=null && clientManager[i].getEmail().equals(email)) {
                index = i;
                break;
            }

        }


        if (index>-1){
            Client[] temp = new Client[clientManager.length];
            for (int k = 0; k < index; k++) {
                temp[k] = clientManager[k];
            }
            for (int j = index; j < clientManager.length-1; j++) {
                temp[j] = clientManager[j+1];
            }
            temp[clientManager.length-1] = null;

            for (int e = index+1; e < clientManager.length; e++) {
                clientManager[e] = temp[e];
            }
            temp = null;


            System.out.println("Client " + email + " has been deleted.");
        Client.clientCount--;
        }
        else {
            System.out.println("Client with email \"" +email+  "\" does not exist");
        }





        }


public void editClient(String email, String input, int choice) {
        int index = -1;
        for (int i = 0; i < clientManager.length; i++) {
            if (clientManager[i]!=null && clientManager[i].getEmail().equals(email)) {
                index = i;
                break;
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
            }
            else System.out.println("Client with email \"" +email+  "\" does not exist");


        }
        }




}













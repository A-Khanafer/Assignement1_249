package clients;

public class ClientManager{

    private Client[] clientManager;
    private int clientCount;

    //ask the user, before launching the program to input how many clients MAXIMUM their system will take.
    public ClientManager(int numClients) {
        clientManager = new Client[numClients];
        clientCount = numClients;
    }

    public void addClient(String name, String email, String phoneNumber, String address) {
    boolean found = false;
        for (int i = 0; i < clientCount; i++) {
            if (clientManager[i]!=null && clientManager[i].equals(new Client(name, email, phoneNumber, address))) {
                found = true;
                System.out.println("Client already in Database.");
                break;
            }
        }
       if (!found) {
           Client[] temp = new Client[++clientCount];
           for(int i = 0; i < clientManager.length; i++) {
               temp[i] = clientManager[i];
           }
           temp[clientManager.length] = new Client(name, email, phoneNumber, address);
           clientManager = temp;
           System.out.println("Client added");
       }

    }


    public void deleteClient(String email) {
        int index = -1;
        for (int i = 0; i < clientCount; i++) {
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
            for (int j = index; j < clientCount; j++) {
                temp[j] = clientManager[j+1];
            }


            for (int e = index+1; e < clientCount; e++) {
                clientManager[e] = temp[e];
            }
            temp = null;


            System.out.println("Client " + email + " has been deleted.");
            clientCount--;
        }
        else {
            System.out.println("Client with email \"" +email+  "\" does not exist");
        }


        }


public void editClient(String email, String input, int choice) {
        int index = -1;
        for (int i = 0; i < clientCount; i++) {
            if (clientManager[i] != null && clientManager[i].getEmail().equals(email)) {
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
            }
            else System.out.println("Client with email \"" +email+  "\" does not exist");



        }




}













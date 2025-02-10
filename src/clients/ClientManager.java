package clients;

public class ClientManager {

    private Client[] clientManager;

    public ClientManager(int numClients) {
        clientManager = new Client[numClients];
    }


    public void deleteClient(String email) {
        int index = -1;
        boolean emailFound = false;
        for (int i = 0; i < Client.registeredClients; i++) {
            if (clientManager[i]!=null && clientManager[i].getEmail().equals(email)) {
                index = i;
                emailFound = true;
                break;
            }

        }


        if (emailFound){
            Client[] temp = new Client[clientManager.length];
            for (int k = 0; k < index; k++) {
                temp[k] = clientManager[k];
            }
            for (int j = index; j < Client.registeredClients-1; j++) {
                temp[j] = clientManager[j+1];
            }
            clientManager = temp;

            System.out.println("Client email: " + email + " has been deleted.");
            Client.registeredClients--;
        }
        else {
            System.out.println("Client with email \"" +email+  "\" does not exist");
        }









        }












    }



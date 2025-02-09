package clients;

public class ClientManager {

    private Client[] clientManager;

    public ClientManager() {
        clientManager = new Client[100000];
    }


    public void deleteClient(String email) {
        int index = 0;
        boolean emailFound = false;
        for (int i = 0; i < clientManager.length; i++) {
            if (clientManager[i].getEmail().equals(email)) {
                index = i;
                emailFound = true;
                break;
            }
            else {emailFound = false;
            }
        }

        if (emailFound){

        }
        else {
            System.out.println("Client with email \"" +email+  "\" does not exist");
        }









        }












    }



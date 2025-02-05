package clients;

public class ClientManager {

    private Client[] clientManager;

    public ClientManager(int numClients) {
        clientManager = new Client[numClients];
    }


    public void deleteClient(String email) {


        int index = 0;
        Client[] temp = new Client[clientManager.length-1];
        for(int i = 0; i < clientManager.length; i++) {
            if (clientManager[i] != null && clientManager[i].getEmail().equals(email)) {
                index = i;
            }
        }

        int j = 0;
        for(int i = 0; i < clientManager.length-1; i++) {
            if(j!=index){
                temp[i] = clientManager[j];
            }
            j++;
        }

        //clientManager = new ClientManager(temp);

    }


}
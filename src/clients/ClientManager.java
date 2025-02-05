package clients;

public class ClientManager extends Client {

    private Client[] clientManager;

    public ClientManager(int numClients) {
        clientManager = new Client[numClients];
    }



    public void deleteClient(Client client, String email) {


            for (int i = 0; i < clientManager.length; i++) {
                if (clientManager[i].getEmail() == email){
                    clientManager[i] = null;
                }
              int temp;
                for (int k = 0; k < clientManager.length-1; k++) {
                    if (clientManager[k+1] != null) {

                    }
                }

            }




        }



    }



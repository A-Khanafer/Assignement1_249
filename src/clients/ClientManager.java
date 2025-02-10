package clients;

public class ClientManager extends Client {

    private Client[] clientManager;

    public ClientManager(int numClients) {
        clientManager = new Client[numClients];
    }

    public void addClient(String email) {
       for (int i = 0; i < clientManager.length; i++) {
           if (clientManager[i]!=null && clientManager[i].getEmail().equals(email)) {
               System.out.println("Client already exists");
           }
       }

    }


    public void deleteClient(String email) {
        int index = -1;
        boolean emailFound = false;
        for (int i = 0; i < clientManager.length; i++) {
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
         switch (choice){
                case 1:
                    clientManager[index].setName(input);
                    break;
                    case 2:
                        clientManager[index].setEmail(input);
                        break;
                        case 3:
                            clientManager[index].setAddress(input);
                            break;
                            case 4:
                                clientManager[index].setPhoneNumber(input);
                                break;
         }


        }
        }




}













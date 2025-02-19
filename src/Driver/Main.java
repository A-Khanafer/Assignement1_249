package Driver;

import clients.Client;
import clients.ClientManager;

import java.util.ArrayList;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Client ahmad = new Client("ahmad" , "hamd@gmail.com", "514", "3429");
        Client abed = new Client("abed" , "abed@gmail.com", "123", "3429");
        Client jayz = new Client("jayz" , "jayz@gmail.com", "456", "3429");

        ClientManager clman = new ClientManager();

        clman.addClient(ahmad);
        clman.addClient(abed);
        clman.addClient(jayz);
        clman.addClient("ahmad" , "hamd@gmail.com", "514", "3429");

        clman.deleteClient(ahmad);
        clman.deleteClient(ahmad);


        System.out.println(clman);


        }
    }

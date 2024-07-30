package tcpforward;

//import util.NetworkUtil;

import java.util.Scanner;

public class Client {
    static final String serverAddress = "127.0.0.1";
    static final int serverPort = 33333;
    NetworkUtil networkUtil;
    String clientName;

    public Client(String serverAddress, int serverPort) {
        try {
            System.out.print("Enter name of the client: ");
            Scanner scanner = new Scanner(System.in);
            clientName = scanner.nextLine();
            networkUtil = new NetworkUtil(serverAddress, serverPort);
            networkUtil.write(clientName);
            new ReadThreadClient(networkUtil);
            new WriteThreadClient(networkUtil, clientName);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void MainMenu(){
        System.out.println("1. Connect");
        System.out.println("2. GetList");
        System.out.println("3. SendMessage");
        System.out.println("4. Broadcast");
        System.out.print("Enter Option: ");
    }

    public static void main(String args[]) {
        int a;
        while (true) {
            MainMenu();
            while(true) {
                Scanner scn = new Scanner(System.in);
                a = scn.nextInt();
                if (a > 0 && a < 5)
                    break;
                System.out.println("Invalid Option!");
                MainMenu();
            }//System.out.println("Here");
            if(a == 1) {
                Client client = new Client(serverAddress, serverPort);
            }

            if(a == 2){

            }

            if(a == 3){

            }

        }
    }
}



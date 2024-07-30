package server;

import FileOperations.FileOperations;
import util.NetworkUtil;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;

public class Server {

    private ServerSocket serverSocket;
    public HashMap<String, String> userMap;

    Server() throws Exception {
        userMap = new HashMap<>();

        for(Password p: FileOperations.readfile(FileOperations.INPUT_PASSWORD)){
            userMap.put(p.getUsername(),p.getPassword());
        }

        try {
            serverSocket = new ServerSocket(33333);
            while (true) {
                Socket clientSocket = serverSocket.accept();
                serve(clientSocket);
            }
        } catch (Exception e) {
            System.out.println("Server starts:" + e);
        }
    }

    public void serve(Socket clientSocket) throws IOException {
        NetworkUtil networkUtil = new NetworkUtil(clientSocket);
        new ReadThreadServer(userMap, networkUtil);
    }

    public static void main(String[] args) throws Exception {
        new Server();
    }
}

package server;

import FileOperations.FileOperations;
import sample.Club;
import sample.Main;
import sample.Player;
import util.LoginDTO;
import util.NetworkUtil;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

public class ReadThreadServer implements Runnable {
    private final Thread thr;
    private final NetworkUtil networkUtil;
    public HashMap<String, String> userMap;


    public ReadThreadServer(HashMap<String, String> map, NetworkUtil networkUtil) {
        this.userMap = map;
        this.networkUtil = networkUtil;
        this.thr = new Thread(this);
        thr.start();
    }

    public void run() {
        try {
            while (true) {
                Object o = networkUtil.read();
                if (o != null) {
                    if (o instanceof LoginDTO) {
                        LoginDTO loginDTO = (LoginDTO) o;
                        String password = userMap.get(loginDTO.getUserName());
                        loginDTO.setStatus(loginDTO.getPassword().equals(password));
                        List<Player> PlayerList = FileOperations.readFile_1(FileOperations.INPUT);
                        loginDTO.setPlayerList(PlayerList);
                       // System.out.println("Inside the Server");
                        List<Club> ClubList = FileOperations.AssignClubs(PlayerList);
                        for(Club c: ClubList){
                            if(loginDTO.getUserName().equals(c.getName()))
                                loginDTO.setUserClub(c);
                        }
                        networkUtil.write(loginDTO);
                    }
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            try {
                networkUtil.closeConnection();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}




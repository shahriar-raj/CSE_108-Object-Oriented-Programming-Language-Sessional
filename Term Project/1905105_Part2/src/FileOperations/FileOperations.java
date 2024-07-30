package FileOperations;

import sample.Club;
import server.Password;
import sample.Player;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class FileOperations {

    public static final String INPUT_PASSWORD = "password.txt";
    public static final String INPUT = "players.txt";

    public static List<Password> readfile(String FILE_NAME) throws Exception{
        List<Password> PasswordList = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader(FILE_NAME));
        while (true) {
            String line = br.readLine();
            if (line == null) break;
            String[] s = line.split(",");
            PasswordList.add(new Password(s[0],s[1]));
        }
        br.close();
       /* for (Player p : PlayerList){
            p.getPlayerInfo();
        }*/
        return  PasswordList;
    }

    public static List <Player> readFile_1(String FILE_NAME) throws Exception{
        List<Player> PlayerList = new ArrayList();
        BufferedReader br = new BufferedReader(new FileReader(FILE_NAME));
        while (true) {
            String line = br.readLine();
            if (line == null) break;
            String[] s = line.split(",");
            PlayerList.add(new Player(s[0],s[1],Integer.parseInt(s[2]),Double.parseDouble(s[3]),s[4],s[5],Integer.parseInt(s[6]),Double.parseDouble(s[7])));
        }
        br.close();
       /* for (Player p : PlayerList){
            p.getPlayerInfo();
        }*/
        return  PlayerList;
    }

    public static List<Club> AssignClubs(List<Player> playerlist){
        List<Club> clublist = new ArrayList<>();
        for(Player p: playerlist){
            int match = -1;
            // System.out.println(p.getCountry());
            for(Club c_l: clublist){
                if(c_l.getName().equalsIgnoreCase(p.getClub())){
                    match = 1;
                    c_l.addPlayer(p);
                    break;
                }
            }
            if(match == -1){
                clublist.add(new Club(p.getClub()));
                clublist.get(clublist.size()-1).addPlayer(p);
            }
        }
        return clublist;
    }
}

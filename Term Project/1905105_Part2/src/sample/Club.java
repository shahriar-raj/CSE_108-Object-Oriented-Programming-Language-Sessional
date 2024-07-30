package sample;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Club implements Serializable {
    private String name;
    private int count;
    private List<Player> playerList = new ArrayList<>();

    public Club(String name){
        this.name = name;
        count = 0;
    }

    public Club(){

    }

    public void addPlayer (Player p){
        playerList.add(p);
        count++;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Player> getPlayerList() {
        return playerList;
    }

    public int getCount() {
        return count;
    }
}

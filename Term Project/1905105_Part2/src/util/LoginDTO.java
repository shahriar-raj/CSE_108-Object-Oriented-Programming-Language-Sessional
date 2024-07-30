package util;

import sample.Club;
import sample.Player;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class LoginDTO implements Serializable {

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public void setUserClub(Club userClub) {
        this.userClub = userClub;
    }

    public Club getUserClub() {
        return userClub;
    }

    public List<Player> getPlayerList() {
        return PlayerList;
    }

    public void setPlayerList(List<Player> playerList) {
        PlayerList = playerList;
    }

    private String userName;
    private String password;
    private boolean status;
    private Club userClub = new Club();
    private List<Player> PlayerList = new ArrayList<>();

}

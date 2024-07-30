package SearchPlayer;

import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import sample.Country;
import sample.Main;
import sample.Player;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SearchPlayer {
    private Main main;

    @FXML
    private ImageView player, salary, country, position, list, exit;

    public List<Player> SearchByName (String searchName, List<Player> PlayerList){
        List <Player> playerlist = new ArrayList<>();
        for(Player p: PlayerList){
            if(p.getName().equalsIgnoreCase(searchName)){
                playerlist.add(p);
                break;
            }
        }
        return playerlist;
    }

    public List<Player> SearchByClub (String searchClub, String searchCountry, List<Player> PlayerList){
        List <Player> playerlist = new ArrayList<>();
        String any = "Any";
        if(searchClub.equalsIgnoreCase(any)){
            for (Player p : PlayerList) {
                if (p.getCountry().equalsIgnoreCase(searchCountry)) {
                    playerlist.add(p);
                }
            }
        }
        else{
            for (Player p : PlayerList) {
                if (p.getCountry().equalsIgnoreCase(searchCountry)&&p.getClub().equalsIgnoreCase(searchClub)) {
                    playerlist.add(p);
                }
            }
        }
        return playerlist;
    }

    public List<Player> SearchByPosition (String searchPosition, List<Player> PlayerList){
        List <Player> playerList = new ArrayList<>();
        for(Player p: PlayerList){
            if(p.getPosition().equalsIgnoreCase(searchPosition)){
                playerList.add(p);
            }
        }
        return playerList;
    }

    public List<Player> SearchBySalary (double low_range, double high_range, List<Player> PlayerList){
        List <Player> playerlist = new ArrayList<>();
        for(Player p: PlayerList){
            if( p.getSalary()>=low_range && p.getSalary()<=high_range){
                playerlist.add(p);
            }
        }
        return playerlist;
    }

    public List<Country> country_wise_count(List<Player> playerList) {
        List <Country> countries = new ArrayList<>();
        for(Player p: playerList){
            int match = -1;
            // System.out.println(p.getCountry());
            for(Country c: countries){
                if(c.getName().equalsIgnoreCase(p.getCountry())){
                    match = 1;
                    c.increaseCount();
                    break;
                    //System.out.println("Match Found");
                }
            }
            if(match == -1){
                countries.add(new Country(p.getCountry()));
            }
        }
        return countries;
    }

    public void init(){
        Image img = new Image(Main.class.getResourceAsStream("player.png"));
        player.setImage(img);
        Image img1 = new Image(Main.class.getResourceAsStream("salary.png"));
        salary.setImage(img1);
        Image img2 = new Image(Main.class.getResourceAsStream("country.png"));
        country.setImage(img2);
        Image img3 = new Image(Main.class.getResourceAsStream("list.png"));
        list.setImage(img3);
        Image img4 = new Image(Main.class.getResourceAsStream("position.png"));
        position.setImage(img4);
        Image img5 = new Image(Main.class.getResourceAsStream("exit.png"));
        exit.setImage(img5);
    }

    public void setMain(Main main) {
        this.main = main;
    }
    public void SearchName(ActionEvent actionEvent) throws Exception {
        main.showSearchPlayerPage(Main.userClub.getName());
    }

    public void SearchPosition(ActionEvent actionEvent) throws Exception {
        main.showSearchPositionPage(Main.userClub.getName());
    }

    public void SearchSalary(ActionEvent actionEvent) throws Exception {
        main.showSearchSalaryPage(Main.userClub.getName());
    }

    public void SearchCountry(ActionEvent actionEvent) throws Exception {
        main.showSearchCountryPage(Main.userClub.getName());
    }

    public void CountryList(ActionEvent actionEvent) throws Exception {
        main.showCountryListPage(Main.userClub.getName());
    }

    public void Exit(ActionEvent actionEvent) {
        try{
            main.showHomePage(Main.userClub.getName());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

package Club;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import sample.Club;
import sample.Main;
import sample.Player;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SearchClub {
    private List<Player> playerlist = new ArrayList<>();
    private List<Player> foundPlayer = new ArrayList<>();
    private Main main;

    @FXML
    private ImageView max_sal, max_height, max_age, total_sal, exit;

    public SearchClub(String name, List<Club> clublist) {
        for(Club c_l: clublist){
            if(name.equalsIgnoreCase(c_l.getName())) {
                this.playerlist = c_l.getPlayerList();
                break;
            }
        }
    }

    public SearchClub(Club c){
        this.playerlist = c.getPlayerList();
    }

    public SearchClub(){

    }

    public List<Player> max_sal(){
        double max_sal = 0;
        for (Player p : playerlist) {
            if (p.getSalary() > max_sal)
                max_sal = p.getSalary();
        }
        for (Player p : playerlist) {
            if (p.getSalary() == max_sal)
                foundPlayer.add(p);
        }
        return foundPlayer;
    }

    public List<Player> max_age(){
        int max_age = 0;
        for (Player p : playerlist) {
            if (p.getAge() > max_age)
                max_age = p.getAge();
        }
        for (Player p : playerlist) {
            if (p.getAge() == max_age)
                foundPlayer.add(p);
        }
        return foundPlayer;
    }

    public List<Player> max_height(){
        double max_height= 0;
        for (Player p : playerlist) {
            if (p.getHeight() > max_height)
                max_height = p.getHeight();
        }
        for (Player p : playerlist) {
            if (p.getHeight() == max_height)
                foundPlayer.add(p);
        }
        return foundPlayer;
    }

    public double total_sal(){
        double weekly_sal = 0;
        for(Player p: playerlist){
            weekly_sal += p.getSalary();
        }
        return (weekly_sal*52.0);
    }

    public void init(){
        Image img = new Image(Main.class.getResourceAsStream("max_sal.png"));
        max_sal.setImage(img);
        Image img1 = new Image(Main.class.getResourceAsStream("max_height.png"));
        max_height.setImage(img1);
        Image img2 = new Image(Main.class.getResourceAsStream("max_age.png"));
        max_age.setImage(img2);
        Image img3 = new Image(Main.class.getResourceAsStream("yearly_salary.png"));
        total_sal.setImage(img3);
        Image img4 = new Image(Main.class.getResourceAsStream("exit.png"));
        exit.setImage(img4);
    }

    public void setMain(Main main) {
        this.main = main;
    }

    public void f_max_height(ActionEvent actionEvent) throws Exception {
        main.showMaxHeightPage();
    }

    public void f_max_age(ActionEvent actionEvent) throws Exception {
        main.showMaxAgePage();
    }

    public void f_total_sal(ActionEvent actionEvent) throws Exception {
        main.showTotalSalaryPage();
    }

    public void f_max_sal(ActionEvent actionEvent) throws Exception {
        main.showMaxSalaryPage();
    }

    public void Exit(ActionEvent actionEvent) {
        try{
            main.showHomePage(Main.userClub.getName());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

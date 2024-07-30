package Transfer;

import javafx.event.ActionEvent;
import sample.Main;

public class Transfer {
    private Main main;

    public void init(){

    }

    public void Exit(ActionEvent actionEvent) {
        try{
            main.showHomePage(Main.userClub.getName());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setMain(Main main){
        this.main = main;
    }
}

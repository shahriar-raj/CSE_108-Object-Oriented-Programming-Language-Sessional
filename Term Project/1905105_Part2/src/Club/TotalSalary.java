package Club;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import sample.Main;

import java.math.BigDecimal;

public class TotalSalary {
    private Main main;
    private final SearchClub c1 = new SearchClub(Main.userClub);
    private String username;

    @FXML
    private Button salary, clubName;

    @FXML
    private ImageView exit;

    public TotalSalary(){

    }

    @FXML
    public void TotalYearlySalary() {
        salary.setText(new BigDecimal(c1.total_sal()).toPlainString() + " $");
        clubName.setText("The Total Yearly Salary of "+ Main.userClub.getName());
        Image img = new Image(Main.class.getResourceAsStream("exit.png"));
        exit.setImage(img);
    }

    public void setMain(Main main) {
        this.main = main;
    }

    public void Exit(ActionEvent actionEvent) throws Exception {
        main.ClubPage();
    }

}

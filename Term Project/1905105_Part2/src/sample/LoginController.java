package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import util.LoginDTO;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LoginController {
    private Main main;
    private List<Player> PlayerList;

    @FXML
    private TextField userText;

    @FXML
    private PasswordField passwordText;

    @FXML
    private Button resetButton;

    @FXML
    private Button loginButton;

    @FXML
    private ImageView football, manager, player;

    @FXML
    void loginAction(ActionEvent event) throws Exception {
        String userName = userText.getText();
        String password = passwordText.getText();
       /* List<Password> PasswordList = main.readfile(Main.INPUT_PASSWORD);
        PlayerList = main.readFile_1(Main.INPUT);
        List<Club> clubList = main.AssignClubs(PlayerList);
        int f=-1;
        for(Password p: PasswordList) {
           if(p.getUsername().equals(userName) && password.equals(p.getPassword())) {
               f=1;
               for(Club c: clubList){
                   if(c.getName().equals(p.getUsername()))
                       //main.writeToFile_2(c.getPlayerList());
                       Main.userClub = c;
               }
               try {
                   main.showHomePage(userName, p.getImage());
               } catch (Exception e) {
                   System.out.println(e);
               }
           }
        }
        if(f==-1){
            main.showAlert();
        }*/
        LoginDTO loginDTO = new LoginDTO();
        loginDTO.setUserName(userName);
        loginDTO.setPassword(password);
        try {
            main.getNetworkUtil().write(loginDTO);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void init(){
        Image img1 = new Image(Main.class.getResourceAsStream("football.png"));
        football.setImage(img1);
       // Image img2 = new Image(Main.class.getResourceAsStream("player.png"));
       // player.setImage(img2);
       // Image img3 = new Image(Main.class.getResourceAsStream("manager.png"));
        //manager.setImage(img3);
    }

    @FXML
    void resetAction(ActionEvent event) {
        userText.setText(null);
        passwordText.setText(null);
    }

    void setMain(Main main) {
        this.main = main;
    }

}

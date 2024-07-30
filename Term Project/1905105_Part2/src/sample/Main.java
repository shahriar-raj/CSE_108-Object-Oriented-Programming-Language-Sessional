package sample;

import SearchGlobal.*;
import SearchPlayer.*;
import Club.*;
import Transfer.Transfer;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import util.NetworkUtil;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main extends Application {

    private Stage stage;
    private List<Player> PlayerList;
    private NetworkUtil networkUtil;

    public Stage getStage() {
        return stage;
    }

    public static Club userClub = new Club();

    public NetworkUtil getNetworkUtil() {
        return networkUtil;
    }

    public void setPlayerList(List<Player> playerList) {
        PlayerList = playerList;
    }

    public List<Player> getPlayerList() {
        return PlayerList;
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        stage = primaryStage;
        connectToServer();
        showLoginPage();
    }

    private void connectToServer() throws IOException {
        String serverAddress = "127.0.0.1";
        int serverPort = 33333;
        networkUtil = new NetworkUtil(serverAddress, serverPort);
        new ReadThread(this);
    }


    public void showLoginPage() throws Exception {
        // XML Loading using FXMLLoader
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("login.fxml"));
        Parent root = loader.load();
        // Loading the controller
        LoginController controller = loader.getController();
        controller.init();
        controller.setMain(this);

        // Set the primary stage
        stage.setTitle("Login");
        stage.setScene(new Scene(root, 709, 577));
        stage.show();
    }

    public void showHomePage(String userName) throws Exception {

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("home.fxml"));
        Parent root = loader.load();

        // Loading the controller
        HomeController controller = loader.getController();
        controller.init(userName, userName+".png");
        controller.setMain(this);
        controller.setTableView();
       /* for(Player P: PlayerList){
            P.getPlayerInfo();
        }*/
        //controller.setListView(userClub.getPlayerList());
        // Set the primary stage
        stage.setTitle("Home // " + userClub.getName());
        stage.setScene(new Scene(root, 958, 705));
        stage.show();
    }

    public void SearchPage() throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("Search.fxml"));
        Parent root = loader.load();

        // Loading the controller
        SearchPlayer controller = loader.getController();
        controller.setMain(this);
        controller.init();
        //controller.setPlayerList(PlayerList);
        // Set the primary stage
        stage.setTitle("Search // "+userClub.getName());
        stage.setScene(new Scene(root, 750, 505));
        stage.show();
    }

    public void showSearchPlayerPage(String userName) throws Exception {

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("SearchPlayerName.fxml"));
        Parent root = loader.load();

        // Loading the controller
        ByName controller = loader.getController();
        controller.setMain(this);
        controller.setUsername(userName);
        controller.setPictures();
        //controller.setPlayerList(PlayerList);
        // Set the primary stage
        stage.setTitle("Search Player By Name // " + userClub.getName());
        stage.setScene(new Scene(root, 716, 566));
        stage.show();
    }

    public void showSearchPositionPage(String userName) throws Exception {

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("SearchPlayerPosition.fxml"));
        Parent root = loader.load();

        // Loading the controller
        ByPosition controller = loader.getController();
        controller.setMain(this);
        controller.setUsername(userName);
        controller.setPictures();
        //controller.setPlayerList(PlayerList);
        // Set the primary stage
        stage.setTitle("Search Player By Position // " + userClub.getName());
        stage.setScene(new Scene(root, 716, 566));
        stage.show();
    }

    public void showSearchCountryPage(String userName) throws Exception {

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("SearchCountryName.fxml"));
        Parent root = loader.load();

        // Loading the controller
        ByCountry controller = loader.getController();
        controller.setMain(this);
        controller.setUsername(userName);
        controller.setPictures();
        //controller.setPlayerList(PlayerList);
        // Set the primary stage
        stage.setTitle("Search Player By Country // " + userClub.getName());
        stage.setScene(new Scene(root, 716, 566));
        stage.show();
    }

    public void showSearchSalaryPage(String userName) throws Exception {

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("SearchPlayerSalary.fxml"));
        Parent root = loader.load();

        // Loading the controller
        BySalary controller = loader.getController();
        controller.setMain(this);
        controller.setUsername(userName);
        controller.setPictures();
        //controller.setPlayerList(PlayerList);
        // Set the primary stage
        stage.setTitle("Search Player By Salary // " + userClub.getName());
        stage.setScene(new Scene(root, 716, 566));
        stage.show();
    }

    public void showCountryListPage(String userName) throws Exception {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("CountryListPage.fxml"));
        Parent root = loader.load();

        // Loading the controller
        CountryList controller = loader.getController();
        controller.setMain(this);
        controller.setUsername(userName);
        controller.searchCountryList();
        //controller.setPlayerList(PlayerList);
        // Set the primary stage
        stage.setTitle("Country-Wise Player List // " + userClub.getName());
        stage.setScene(new Scene(root, 600, 410));
        stage.show();
    }

    public void ClubPage() throws Exception {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("Club.fxml"));
        Parent root = loader.load();

        // Loading the controller
        SearchClub controller = loader.getController();
        controller.setMain(this);
        controller.init();
        //controller.setPlayerList(PlayerList);
        // Set the primary stage
        stage.setTitle("Club // " + userClub.getName());
        stage.setScene(new Scene(root, 700, 460));
        stage.show();
    }

    public void showMaxSalaryPage() throws Exception {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("FindMaxSalary.fxml"));
        Parent root = loader.load();

        // Loading the controller
        MaxSalary controller = loader.getController();
        controller.setMain(this);
        controller.FindMaxSalary();
        //controller.setPlayerList(PlayerList);
        // Set the primary stage
        stage.setTitle("Find Max Salary // " + userClub.getName());
        stage.setScene(new Scene(root, 700, 400));
        stage.show();
    }

    public void showMaxHeightPage() throws Exception {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("FindMaxHeight.fxml"));
        Parent root = loader.load();

        // Loading the controller
        MaxHeight controller = loader.getController();
        controller.setMain(this);
        controller.FindMaxHeight();
        //controller.setPlayerList(PlayerList);
        // Set the primary stage
        stage.setTitle("Find Max Height // " + userClub.getName());
        stage.setScene(new Scene(root, 700, 400));
        stage.show();
    }

    public void showMaxAgePage() throws Exception {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("FindMaxAge.fxml"));
        Parent root = loader.load();

        // Loading the controller
        MaxAge controller = loader.getController();
        controller.setMain(this);
        controller.FindMaxAge();
        //controller.setPlayerList(PlayerList);
        // Set the primary stage
        stage.setTitle("Find Max Age // " + userClub.getName());
        stage.setScene(new Scene(root, 700, 400));
        stage.show();
    }

    public void showTotalSalaryPage() throws Exception {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("FindTotalSalary.fxml"));
        Parent root = loader.load();

        // Loading the controller
        TotalSalary controller = loader.getController();
        controller.setMain(this);
        controller.TotalYearlySalary();
        //controller.setPlayerList(PlayerList);
        // Set the primary stage
        stage.setTitle("Find Total Yearly Salary // " + userClub.getName());
        stage.setScene(new Scene(root, 600, 400));
        stage.show();
    }

    public void showTransferPage() throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("Transfer.fxml"));
        Parent root = loader.load();

        // Loading the controller
        Transfer controller = loader.getController();
        controller.setMain(this);
        controller.init();
        //controller.setPlayerList(PlayerList);
        // Set the primary stage
        stage.setTitle("Transfer Window // " + userClub.getName());
        stage.setScene(new Scene(root, 600, 400));
        stage.show();
    }

    public void showAlert() {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Incorrect Credentials");
        alert.setHeaderText("Incorrect Credentials");
        alert.setContentText("The clubname and password you provided is not correct.");
        alert.showAndWait();
    }

    public void SearchPage_() throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("SearchG.fxml"));
        Parent root = loader.load();

        // Loading the controller
        SearchPlayerGlobal controller = loader.getController();
        controller.setMain(this);
        controller.init();
        //controller.setPlayerList(PlayerList);
        // Set the primary stage
        stage.setTitle("Search // All Clubs");
        stage.setScene(new Scene(root, 750, 505));
        stage.show();
    }

    public void showSearchPlayerPage_(String userName) throws Exception {

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("SearchPlayerNameG.fxml"));
        Parent root = loader.load();

        // Loading the controller
        ByNameGlobal controller = loader.getController();
        controller.setMain(this);
        controller.setUsername(userName);
        controller.setPictures();
        //controller.setPlayerList(PlayerList);
        // Set the primary stage
        stage.setTitle("Search Player By Name // All Clubs");
        stage.setScene(new Scene(root, 716, 566));
        stage.show();
    }

    public void showSearchPositionPage_(String userName) throws Exception {

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("SearchPlayerPositionG.fxml"));
        Parent root = loader.load();

        // Loading the controller
        ByPositionGlobal controller = loader.getController();
        controller.setMain(this);
        controller.setUsername(userName);
        controller.setPictures();
        //controller.setPlayerList(PlayerList);
        // Set the primary stage
        stage.setTitle("Search Player By Position // All Clubs");
        stage.setScene(new Scene(root, 716, 566));
        stage.show();
    }

    public void showSearchCountryPage_(String userName) throws Exception {

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("SearchCountryNameG.fxml"));
        Parent root = loader.load();

        // Loading the controller
        ByCountryGlobal controller = loader.getController();
        controller.setMain(this);
        controller.setUsername(userName);
        controller.setPictures();
        //controller.setPlayerList(PlayerList);
        // Set the primary stage
        stage.setTitle("Search Player By Country // All Clubs");
        stage.setScene(new Scene(root, 716, 588));
        stage.show();
    }

    public void showSearchSalaryPage_(String userName) throws Exception {

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("SearchPlayerSalaryG.fxml"));
        Parent root = loader.load();

        // Loading the controller
        BySalaryGlobal controller = loader.getController();
        controller.setMain(this);
        controller.setUsername(userName);
        controller.setPictures();
        //controller.setPlayerList(PlayerList);
        // Set the primary stage
        stage.setTitle("Search Player By Salary // All Clubs");
        stage.setScene(new Scene(root, 716, 566));
        stage.show();
    }

    public void showCountryListPage_(String userName) throws Exception {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("CountryListPageG.fxml"));
        Parent root = loader.load();

        // Loading the controller
        CountryListGlobal controller = loader.getController();
        controller.setMain(this);
        controller.setUsername(userName);
        controller.searchCountryList();
        //controller.setPlayerList(PlayerList);
        // Set the primary stage
        stage.setTitle("Country-Wise Player List // All Clubs");
        stage.setScene(new Scene(root, 600, 410));
        stage.show();
    }
    /* public List<Password> readfile(String FILE_NAME) throws Exception{
        List<Password> PasswordList = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader(FILE_NAME));
        while (true) {
            String line = br.readLine();
            if (line == null) break;
            String[] s = line.split(",");
            PasswordList.add(new Password(s[0],s[1],s[2]));
        }
        br.close();
        for (Player p : PlayerList){
            p.getPlayerInfo();
        }
        return  PasswordList;
    }

    public List <Player> readFile_1(String FILE_NAME) throws Exception{
        List<Player> PlayerList = new ArrayList();
        BufferedReader br = new BufferedReader(new FileReader(FILE_NAME));
        while (true) {
            String line = br.readLine();
            if (line == null) break;
            String[] s = line.split(",");
            PlayerList.add(new Player(s[0],s[1],Integer.parseInt(s[2]),Double.parseDouble(s[3]),s[4],s[5],Integer.parseInt(s[6]),Double.parseDouble(s[7])));
        }
        br.close();
        for (Player p : PlayerList){
            p.getPlayerInfo();
        }
        return  PlayerList;
    }

    public List<Club> AssignClubs(List<Player> playerlist){
        List<Club> clublist = new ArrayList<>();
        for(Player p: playerlist){
            int match = -1;
            System.out.println(p.getCountry());
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
    }*/

    public static void main(String[] args) {
        launch(args);
    }


}

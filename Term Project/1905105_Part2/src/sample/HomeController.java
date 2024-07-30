package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class HomeController {

    private Main main;

    private List<Player> PlayerList;

    @FXML
    private ImageView image, logout, search, club, transfer, all;

    @FXML
    private Button button, message_button;

   /* @FXML
    private ListView listView; */

    @FXML
    private TableView tableView;

    ObservableList<Person> data;

   /*public void setListView(List<Player> PlayerList){
        ObservableList names = FXCollections.observableArrayList();
        this.PlayerList = PlayerList;
        for(Player P: PlayerList) {
            names.add(P.getName());
        }
        listView.setItems(names);
    } */


    private boolean init = true;

    private void initializeColumns() {
        TableColumn<Person, String> NameCol = new TableColumn<>("Player Name");
        NameCol.setMinWidth(110);
        NameCol.setCellValueFactory(new PropertyValueFactory<>("name"));

        TableColumn<Person, String> PosCol = new TableColumn<>("Position");
        PosCol.setMinWidth(70);
        PosCol.setCellValueFactory(new PropertyValueFactory<>("position"));

        TableColumn<Person, String> CountryCol = new TableColumn<>("Country");
        CountryCol.setMinWidth(60);
        CountryCol.setCellValueFactory(new PropertyValueFactory<>("country"));

      /*  TableColumn<Person, String> ClubCol = new TableColumn<>("Club");
        ClubCol.setMinWidth(60);
        ClubCol.setCellValueFactory(new PropertyValueFactory<>("club"));*/

        TableColumn<Person, Double> HeightCol = new TableColumn<>("Height");
        HeightCol.setMinWidth(25);
        HeightCol.setCellValueFactory(new PropertyValueFactory<>("height"));

      /*  TableColumn<Person, Double> SalaryCol = new TableColumn<>("Salary");
        SalaryCol.setMinWidth(60);
        SalaryCol.setCellValueFactory(new PropertyValueFactory<>("salary")); */

        TableColumn<Person, Integer> NumberCol = new TableColumn<>("Number");
        NumberCol.setMinWidth(25);
        NumberCol.setCellValueFactory(new PropertyValueFactory<>("number"));

        TableColumn<Person, Integer> AgeCol = new TableColumn<>("Age");
        AgeCol.setMinWidth(20);
        AgeCol.setCellValueFactory(new PropertyValueFactory<>("age"));

        TableColumn<Person, String> buttonCol = new TableColumn<>("View");
        buttonCol.setMinWidth(20);
        buttonCol.setCellValueFactory(new PropertyValueFactory<>("button"));

        tableView.getColumns().addAll(NameCol, CountryCol, AgeCol, HeightCol, PosCol, NumberCol, buttonCol);
    }

    public void setTableView() throws Exception {
        if(init) {
            initializeColumns();
            init = false;
        }
        List<Person> PersonList = new ArrayList<>();

        for(Player p : Main.userClub.getPlayerList()) {
            PersonList.add(new Person(p.getName(), p.getCountry(), p.getAge(), p.getHeight(), p.getClub(), p.getPosition(), p.getNumber(), p.getSalary()));
        }

       /* for(Person P: PersonList)
            System.out.println("*****"+P.getName() +"***"+ P.getAge());*/

        data = FXCollections.observableArrayList(PersonList);

        tableView.setEditable(true);
        tableView.setItems(data);
    }

    public void init(String msg, String profile_image) {
        message_button.setText(msg);
        Image img = new Image(Main.class.getResourceAsStream(profile_image));
        image.setImage(img);
        Image img2 = new Image(Main.class.getResourceAsStream("logout.png"));
        logout.setImage(img2);
        Image img3 = new Image(Main.class.getResourceAsStream("search.png"));
        search.setImage(img3);
        Image img4 = new Image(Main.class.getResourceAsStream("club.png"));
        club.setImage(img4);
        Image img5 = new Image(Main.class.getResourceAsStream("transfer.png"));
        transfer.setImage(img5);
        Image img6 = new Image(Main.class.getResourceAsStream("all.png"));
        all.setImage(img6);
    }

    @FXML
    void logoutAction(ActionEvent event) {
        try {
            main.showLoginPage();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    void setMain(Main main) {
        this.main = main;
    }

    public void Search(ActionEvent actionEvent) throws IOException {
        main.SearchPage();
    }

    public void Club(ActionEvent actionEvent) throws Exception {
        main.ClubPage();
    }

    public void Transfer(ActionEvent actionEvent) throws IOException {
        main.showTransferPage();
    }

    public void SearchGlobal(ActionEvent actionEvent) throws IOException {
        main.SearchPage_();
    }
}

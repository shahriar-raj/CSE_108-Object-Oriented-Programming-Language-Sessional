package Club;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import sample.Main;
import sample.Person;
import sample.Player;

import java.util.ArrayList;
import java.util.List;

public class MaxSalary {
    private Main main;
    private final SearchClub c1 = new SearchClub(Main.userClub);
    private String username;

    @FXML
    private TableView tableView;

    @FXML
    private ImageView exit;

    ObservableList<Person> data;

    public MaxSalary(){

    }

    private boolean init = true;

    private void initializeColumns() {
        TableColumn<Person, String> NameCol = new TableColumn<>("Player Name");
        NameCol.setMinWidth(130);
        NameCol.setCellValueFactory(new PropertyValueFactory<>("name"));

        TableColumn<Person, String> PosCol = new TableColumn<>("Position");
        PosCol.setMinWidth(80);
        PosCol.setCellValueFactory(new PropertyValueFactory<>("position"));

        TableColumn<Person, String> CountryCol = new TableColumn<>("Country");
        CountryCol.setMinWidth(80);
        CountryCol.setCellValueFactory(new PropertyValueFactory<>("country"));

        TableColumn<Person, String> ClubCol = new TableColumn<>("Club");
        ClubCol.setMinWidth(80);
        ClubCol.setCellValueFactory(new PropertyValueFactory<>("club"));

        TableColumn<Person, Double> HeightCol = new TableColumn<>("Height");
        HeightCol.setMinWidth(48);
        HeightCol.setCellValueFactory(new PropertyValueFactory<>("height"));

        TableColumn<Person, Double> SalaryCol = new TableColumn<>("Salary");
        SalaryCol.setMinWidth(80);
        SalaryCol.setCellValueFactory(new PropertyValueFactory<>("salary"));

        TableColumn<Person, Integer> NumberCol = new TableColumn<>("Number");
        NumberCol.setMinWidth(40);
        NumberCol.setCellValueFactory(new PropertyValueFactory<>("number"));

        TableColumn<Person, Integer> AgeCol = new TableColumn<>("Age");
        AgeCol.setMinWidth(48);
        AgeCol.setCellValueFactory(new PropertyValueFactory<>("age"));

        TableColumn<Person, String> buttonCol = new TableColumn<>("View");
        buttonCol.setMinWidth(80);
        buttonCol.setCellValueFactory(new PropertyValueFactory<>("button"));

        tableView.getColumns().addAll(NameCol, CountryCol, AgeCol, HeightCol, ClubCol, PosCol, NumberCol, SalaryCol, buttonCol);
    }

    public void setTableView(List<Player> found_players) throws Exception {
        if(init) {
            initializeColumns();
            init = false;
        }
        List<Person> PersonList = new ArrayList<>();

        for(Player p : found_players) {
            PersonList.add(new Person(p.getName(), p.getCountry(), p.getAge(), p.getHeight(), p.getClub(), p.getPosition(), p.getNumber(), p.getSalary()));
        }
        data = FXCollections.observableArrayList(PersonList);
        tableView.setEditable(true);
        tableView.setItems(data);

    }

    public void FindMaxSalary() throws Exception {
        List<Player> found_players = c1.max_sal();
        Image img = new Image(Main.class.getResourceAsStream("exit.png"));
        exit.setImage(img);
        setTableView(found_players);
    }


    public void setMain(Main main) {
        this.main = main;
    }

    public void Exit(ActionEvent actionEvent) throws Exception {
        main.ClubPage();
    }
}

package SearchGlobal;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import sample.*;

import java.util.ArrayList;
import java.util.List;

public class CountryListGlobal {
    private Main main;
    private final SearchPlayerGlobal s1 = new SearchPlayerGlobal();
    private String username;

    ObservableList<CountryTable> data;

    @FXML
    private TableView tableView;

    @FXML
    private ImageView exit;

    public CountryListGlobal(){

    }

    public void searchCountryList() throws Exception {
        List<Country> found_list = s1.country_wise_count(main.getPlayerList());
        setTableView(found_list);
        Image img = new Image(Main.class.getResourceAsStream("exit.png"));
        exit.setImage(img);
    }

    private boolean init = true;

    private void initializeColumns() {
        TableColumn<CountryTable, String> NameCol = new TableColumn<>("Country");
        NameCol.setMinWidth(148);
        NameCol.setCellValueFactory(new PropertyValueFactory<>("name"));

        TableColumn<CountryTable, Integer> NumCol = new TableColumn<>("Number of Players");
        NumCol.setMinWidth(149);
        NumCol.setCellValueFactory(new PropertyValueFactory<>("count"));

        tableView.getColumns().addAll(NameCol, NumCol);
    }

    public void setTableView(List<Country> found_list) throws Exception {
        if(init) {
            initializeColumns();
            init = false;
        }
        List<CountryTable> CountryTableList = new ArrayList<>();

        for(Country c : found_list) {
            CountryTableList.add(new CountryTable(c.getName(),c.getCount()));
        }
        data = FXCollections.observableArrayList(CountryTableList);
        tableView.setEditable(true);
        tableView.setItems(data);
    }

    public void setMain(Main main) {
        this.main = main;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void back(ActionEvent actionEvent) {
        try{
            main.SearchPage_();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

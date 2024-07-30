package sample;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class CountryTable {
    private SimpleStringProperty name;
    private SimpleIntegerProperty count;

    public CountryTable(String name, int count){
        this.name = new SimpleStringProperty(name);
        this.count = new SimpleIntegerProperty(count);
    }

    public int getCount() {
        return count.get();
    }

    public String getName() {
        return name.get();
    }

}

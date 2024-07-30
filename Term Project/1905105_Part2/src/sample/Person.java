package sample;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;

public class Person {
    private final SimpleStringProperty name;
    private final SimpleStringProperty position;
    private final SimpleIntegerProperty age;
    private final SimpleStringProperty country;
    private final SimpleStringProperty club;
    private final SimpleDoubleProperty salary;
    private final SimpleDoubleProperty height;
    private final SimpleIntegerProperty number;
    private final Button button;

    public Person(String name, String country, int age, double height, String club, String position, int number, double salary) {
        this.name = new SimpleStringProperty(name);
        this.country = new SimpleStringProperty(country);
        this.age = new SimpleIntegerProperty(age);
        this.height = new SimpleDoubleProperty(height);
        this.club = new SimpleStringProperty(club);
        this.position = new SimpleStringProperty(position);
        this.number = new SimpleIntegerProperty(number);
        this.salary = new SimpleDoubleProperty(salary);
        this.button = new Button("Details");
        button.setOnAction( e -> {
                   // System.out.println(getFirstName() + " " + getLastName() + " " + getEmail());
                    Alert a = new Alert(Alert.AlertType.INFORMATION);
                    a.setTitle("Player Information");
                    a.setHeaderText(getName());
                    a.setContentText("Name: "+getName()+"\nCountry: "+getCountry()+"\nAge: "+getAge()+"\nHeight: "+getHeight()+"\nClub: "+getClub()+"\nPosition: "+getPosition()+"\nNumber: "+getNumber()+"\nSalary: "+getSalary());

                    a.showAndWait();
                }
        );
    }

    public int getAge() {
        return age.get();
    }

    public double getHeight() {
        return height.get();
    }

    public double getSalary() {
        return salary.get();
    }

    public int getNumber() {
        return number.get();
    }

    public String getClub() {
        return club.get();
    }

    public String getPosition() {
        return position.get();
    }

    public String getCountry() {
        return country.get();
    }

    public String getName() {
        return name.get();
    }

   /* public String toString() {
        return firstName + ", " + lastName + ", " + email;
    }*/

    public Button getButton() {
        return button;
    }


}


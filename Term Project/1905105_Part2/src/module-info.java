module myjfx {
    requires javafx.fxml;
    requires javafx.controls;
    requires javafx.graphics;
    opens sample to javafx.graphics, javafx.fxml, javafx.base;
    opens SearchPlayer to javafx.fxml, javafx.graphics;
    opens Club to javafx.base, javafx.fxml, javafx.graphics;
    opens server to javafx.base, javafx.fxml, javafx.graphics;
    opens Transfer to javafx.base, javafx.fxml, javafx.graphics;
    opens SearchGlobal to javafx.base, javafx.fxml, javafx.graphics;
}
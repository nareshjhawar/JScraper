module com.jscraper.jscraper {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.jscraper.jscraper to javafx.fxml;
    exports com.jscraper.jscraper;
}
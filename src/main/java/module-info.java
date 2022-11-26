module com.jscraper.jscraper {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafxblur;


    opens com.jscraper.jscraper to javafx.fxml;
    exports com.jscraper.jscraper;
}
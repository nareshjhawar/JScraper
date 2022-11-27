module com.jscraper.jscraper {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafxblur;
    requires org.jsoup;


    opens com.jscraper.app to javafx.fxml;
    exports com.jscraper.app;
    exports com.jscraper.app.util;
    opens com.jscraper.app.util to javafx.fxml;
}
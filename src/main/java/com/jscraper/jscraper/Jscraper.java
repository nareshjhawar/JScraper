package com.jscraper.jscraper;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class Jscraper extends Application {
    private double x, y;

    @Override
    public void start(Stage stage) throws IOException {
        //adding our fxml gui
        FXMLLoader fxmlLoader = new FXMLLoader(Jscraper.class.getResource("result.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        //window tweaking
        scene.setFill(Color.TRANSPARENT);
        stage.initStyle(StageStyle.UNDECORATED);
        stage.initStyle(StageStyle.TRANSPARENT);
        //adding scene
        stage.setScene(scene);
        // functions to drag windows
        scene.setOnMousePressed(event -> {
            x = event.getSceneX();
            y = event.getSceneY();
        });
        scene.setOnMouseDragged(event -> {

            stage.setX(event.getScreenX() - x);
            stage.setY(event.getScreenY() - y);

        });
        // display
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
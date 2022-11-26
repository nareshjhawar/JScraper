package com.jscraper.jscraper;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

import java.io.IOException;

public class Controller {

    @FXML
    Circle CloseBtn;
    ActionEvent event;

    /**** close screen ****/
    @FXML
    public void onCloseBtnClick(MouseEvent event) throws IOException {
        System.exit(0);
    }
}
package com.jscraper.app;

import com.jscraper.app.util.Scrape;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.List;

public class Controller {

    private Stage stage;
    private Scene scene;
    private Parent root;
    private double x, y;


    public void switchtoHome(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Home.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        scene.setFill(Color.TRANSPARENT);

        stage.setScene(scene);
        //functions to drag windows
        scene.setOnMousePressed(event1 -> {
            x = event1.getSceneX();
            y = event1.getSceneY();
        });
        scene.setOnMouseDragged(event1 -> {
            stage.setX(event1.getScreenX() - x);
            stage.setY(event1.getScreenY() - y);
        });
        stage.show();
    }
    public void switchtoAbout(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("about.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        scene.setFill(Color.TRANSPARENT);

        stage.setScene(scene);
        //functions to drag windows
        scene.setOnMousePressed(event1 -> {
            x = event1.getSceneX();
            y = event1.getSceneY();
        });
        scene.setOnMouseDragged(event1 -> {
            stage.setX(event1.getScreenX() - x);
            stage.setY(event1.getScreenY() - y);
        });
        stage.show();
    }
    public void switchtoResult(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("result.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        scene.setFill(Color.TRANSPARENT);

        stage.setScene(scene);
        //functions to drag windows
        scene.setOnMousePressed(event1 -> {
            x = event1.getSceneX();
            y = event1.getSceneY();
        });
        scene.setOnMouseDragged(event1 -> {
            stage.setX(event1.getScreenX() - x);
            stage.setY(event1.getScreenY() - y);
        });
        stage.show();
    }

    //    @FXML
//    Circle CloseBtn;
//    ActionEvent event;
    @FXML
    Button scrapeBtn;

    @FXML
    TextField keywordInput;
    @FXML
    TextField urlInput;

    /**** close screen ****/
    @FXML
    public void onCloseBtnClick() {
        System.exit(0);
    }
    @FXML
    public void onMaxBtnClick(MouseEvent event) throws IOException{
        System.exit(0);
    }

    @FXML
    public void onScrape() {
        String search = "https://www." + urlInput.getText() + "/search?q="+keywordInput.getText();

        Scrape Scraper = new Scrape(search);
        List<Scrape.Product> products = Scraper.extractProducts();
        for (Scrape.Product product : products) {
            System.out.println(
                    String.format("Product:\n%s\n%s\n%s\n%s\n%s\n\n", product.getTitle(),
                            product.getFormattedPrice(),
                            "Rate : "+ product.getRating(),
                            ("Link : "+ product.getLink()),
                            "Image:"+product.getImage()
                    )
            );

        }
    }
}
package com.jscraper.app;

import com.jscraper.app.util.Scrape;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

import java.io.IOException;
import java.util.List;

public class Controller {

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
        String search = "https://www." +urlInput.getText() + "/search?q="+keywordInput.getText();

        Scrape Scrapper = new Scrape(search);
        List<Scrape.Product> products = Scrapper.extractProducts();
        for (Scrape.Product product : products) {
            System.out.println(
                    String.format("Product:\n%s\n%s\n%s\n%s\n%s\n\n", product.getName(),
                            product.getFormattedPrice(),
                            "Rate : "+ product.getRating(),
                            ("Link : "+ product.getLink()),
                            "Image:"+product.getImage()
                    )
            );

        }
    }
}
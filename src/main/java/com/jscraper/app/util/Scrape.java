package com.jscraper.app.util;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Scrape {
    private final String baseUrl;
    public Scrape(String myUrl){
         this.baseUrl =myUrl;
    }

//    private static final String baseUrl = "https://www.flipkart.com/search?q=phone";
//    private static final String baseUrl = "https://www.amazon.com/s?k=phone";
//    boolean val = baseUrl.contains("amazon");

    // classes of HTML where data is displayed
    private static final String PRODUCT_CARD_CLASS = "_2kHMtA";
    private static final String PRODUCT_TITLE_CLASS = "_4rR01T";
    private static final String PRODUCT_PRICE_SELECTOR = "._30jeq3._1_WHN1";
    private static final String PRODUCT_RATING = "._3LWZlK";

    // amazon
//    private static final String PRODUCT_CARD_CLASS = "s-result-item";
//    private static final String PRODUCT_TITLE_CLASS = "a-text-normal";
//    private static final String PRODUCT_PRICE_SELECTOR = ".a-price-whole";
//    private static final String PRODUCT_RATING = ".a-icon-alt";

    public class Product {
        private String title;
        private String link;

        private String productImg;
        private String formattedPrice;
        private String rating;

        //#getter and setter methods
        // title
        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        // link
        public String getLink() { return (baseUrl+link);}

        public void setLink(String link) {
            this.link = link;
        }

        //image
        public String getImage() {
            return productImg;
        }

        public void setImage(String productImg) {
            this.productImg = productImg;
        }

        //price
        public String getFormattedPrice() {
            return formattedPrice;
        }

        public void setFormattedPrice(String formattedPrice) {
            this.formattedPrice = formattedPrice;
        }
        public String getRating() {
            return rating;
        }

        public void setRating(String rating) {
            this.rating = rating;
        }
    }

    //To get list of Products from site
    public List<Product> extractProducts() {
        List<Product> products = new ArrayList<>();
        // root document - doc
        Document doc;
        try {
            doc = Jsoup.connect(baseUrl).get();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // top card element of product
        Elements productElements = doc.getElementsByClass(PRODUCT_CARD_CLASS);
        for (Element productElement : productElements) {
            Product product = new Product();
            //title of product
            Elements titleElements = productElement.getElementsByClass(PRODUCT_TITLE_CLASS);
            product.setTitle(titleElements.text());
            //link of product
            Elements linkElements = productElement.getElementsByTag("a");
            if (!linkElements.isEmpty()) {
                product.setLink(linkElements.get(0).attr("href"));
            }
            // image of product
            Elements imageElements = productElement.getElementsByTag("img");
            if (!imageElements.isEmpty()) {
                product.setImage(imageElements.get(0).attr("src"));
            }
            // price of product
            Elements priceElements = productElement.select(PRODUCT_PRICE_SELECTOR);
            if (!priceElements.isEmpty()) {
                product.setFormattedPrice(priceElements.get(0).text());
            }
            // price of product
            Elements rateElements = productElement.select(PRODUCT_RATING);
            if (!rateElements.isEmpty()) {
                product.setRating(rateElements.get(0).text());
            }
            products.add(product);
        }
        return products;
    }
}
package com.company;


import javafx.animation.*;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.scene.text.Font;
import javafx.util.Duration;


public class splash {

    static Scene splash;

    final private Pane pane = new Pane();
    final private StackPane pane2 = new StackPane();



    public splash() {

        splash = new Scene(pane2 , 500,500);
    }

    public void show() {
        Image image = new Image(getClass().getResourceAsStream("/resorce/Asset 9dpi.png"));
        ImageView iv = new ImageView(image);
        Image image1 = new Image(getClass().getResourceAsStream("/resorce/Asset 3dpi.png"));
        ImageView iv2 = new ImageView(image1);
        iv.setFitWidth(130);
        iv.setFitHeight(140);
        ScaleTransition scaleTransition = new ScaleTransition();
        scaleTransition.setDuration(Duration.seconds(2));

        scaleTransition.setNode(iv);

        scaleTransition.setByY(1);
        scaleTransition.setByX(1);

        scaleTransition.play();

        pane.getChildren().addAll(iv2,iv);
        pane2.getChildren().addAll(iv2,iv);
        pane2.setAlignment(iv,Pos.CENTER);
    }

    public Scene getSplashScene() {
        return splash;

    }


}

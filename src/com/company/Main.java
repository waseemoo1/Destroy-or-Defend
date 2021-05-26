package com.company;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.util.Duration;
import java.io.IOException;

public class Main extends Application {

    @Override
    public void start(Stage stage)
    {
        splash splash = new splash();
        splash.show();
        stage.setScene(splash.getSplashScene());
        Timeline timeline = new Timeline();
        KeyFrame key = new KeyFrame(Duration.millis(2500), new KeyValue(splash.getSplashScene().getRoot().opacityProperty(), 0.2));
        timeline.getKeyFrames().add(key);
        timeline.setOnFinished((event) -> {
            try {
                Parent root = FXMLLoader.load(getClass().getResource("com.company.fxml"));
                //
                Scene scene = new Scene(root);
                stage.setTitle("ATTACK & DEFEND");
                stage.setScene(scene);
                stage.setFullScreen(true);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });
        timeline.play();
        stage.setFullScreen(true);
        stage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
}
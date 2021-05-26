package com.company;

import java.io.IOException;
import java.util.ArrayList;

import com.company.GameManagment.DODGameManager;
import com.company.Obstacles.Obstacle;
import com.company.Units.Unit;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Bounds;
import javafx.geometry.Point2D;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.util.Duration;
public class controller  {
    private int remainingtime =120;
    private long timeout = System.currentTimeMillis() + (remainingtime * 1000) + 10000;
    private long lostTime=0;
    private boolean isRunning=true;

    @FXML
    public void OnButtonClicked(MouseEvent e) {
        System.exit(0);
    }

    public void changeSceneOnButtonClicked(MouseEvent ev) throws IOException {


        Parent root = FXMLLoader.load(getClass().getResource("com.company2.fxml"));
        Scene scene4 = new Scene(root);
        Stage window = (Stage) ((Node) ev.getSource()).getScene().getWindow();
        window.setScene(scene4);
        window.setFullScreen(true);
        window.show();
    }

    public void changeSceneOnButtonClicked2(MouseEvent actionEvent) {

        DODGameManager.getInstance().start_StaticGame();
        DODGameManager.getInstance().runUnits();
        ImageView imageView;
        Image image = new Image(getClass().getResourceAsStream("/resorce/BackGround.png"));
        //Image image = new Image(getClass().getResourceAsStream("/resorce/BackGround.png"));
        Pane pane;
        ArrayList<ImageView> hero = new ArrayList<>();
        ArrayList<ImageView> hero1 = new ArrayList<>();
        imageView = new ImageView(image);
        pane = new Pane();
        Pane pane2 = new Pane();
        int j = 0;
        for (Unit i : Store.allUnits) {
            image = new Image(getClass().getResourceAsStream(i.draw()));
            hero.add(new ImageView(image));
            hero.get(j).setX(i.getMyPosition().getX());
            hero.get(j).setY(i.getMyPosition().getY());
            hero.get(j).setFitHeight(i.getRadius() * 2);
            hero.get(j).setFitWidth(i.getRadius() * 2);
            pane.getChildren().add(hero.get(j));
            j++;
        }

        j = 0;
        for (Obstacle r : Store.allObstacles) {
            image = new Image(getClass().getResourceAsStream(r.draw1()));
            hero1.add(new ImageView(image));
            hero1.get(j).setX(r.getMyPosition().getX());
            hero1.get(j).setY(r.getMyPosition().getY());
            hero1.get(j).setFitHeight(r.getRadius()*2);
            hero1.get(j).setFitWidth(r.getRadius()*2);
            pane2.getChildren().add(hero1.get(j));
            j++;
        }
        StackPane result = new StackPane(imageView,pane2,pane);
        result.setAlignment(Pos.TOP_LEFT);




        Region zoomTarget = result;
        zoomTarget.setPrefSize(10000, 10000);
       /* zoomTarget.setOnDragDetected(evt -> {
            Node target = (Node) evt.getTarget();
            while (target != zoomTarget && target != null) {
                target = target.getParent();
            }
            if (target != null) {
                target.startFullDrag();
            }
        });*/

        Group group = new Group(zoomTarget);

        // stackpane for centering the content, in case the ScrollPane viewport
        // is larget than zoomTarget
        StackPane content = new StackPane(group);
        group.layoutBoundsProperty().addListener((observable, oldBounds, newBounds) -> {
            // keep it at least as large as the content
            content.setMinWidth(newBounds.getWidth());
            content.setMinHeight(newBounds.getHeight());
        });

        ScrollPane scrollPane = new ScrollPane(content);
        scrollPane.setPannable(true);
        scrollPane.viewportBoundsProperty().addListener((observable, oldBounds, newBounds) -> {
            // use vieport size, if not too small for zoomTarget
            content.setPrefSize(newBounds.getWidth(), newBounds.getHeight());
        });

        content.setOnScroll(evt -> {
            if (evt.isControlDown()) {
                evt.consume();

                final double zoomFactor = evt.getDeltaY() > 0 ? 1.2 : 1 / 1.2;

                Bounds groupBounds = group.getLayoutBounds();
                final Bounds viewportBounds = scrollPane.getViewportBounds();

                // calculate pixel offsets from [0, 1] range
                double valX = scrollPane.getHvalue() * (groupBounds.getWidth() - viewportBounds.getWidth());
                double valY = scrollPane.getVvalue() * (groupBounds.getHeight() - viewportBounds.getHeight());

                // convert content coordinates to zoomTarget coordinates
                Point2D posInZoomTarget = zoomTarget.parentToLocal(group.parentToLocal(new Point2D(evt.getX(), evt.getY())));

                // calculate adjustment of scroll position (pixels)
                Point2D adjustment = zoomTarget.getLocalToParentTransform().deltaTransform(posInZoomTarget.multiply(zoomFactor - 1));

                // do the resizing
                zoomTarget.setScaleX(zoomFactor * zoomTarget.getScaleX());
                zoomTarget.setScaleY(zoomFactor * zoomTarget.getScaleY());

                // refresh ScrollPane scroll positions & content bounds
                scrollPane.layout();

                // convert back to [0, 1] range
                // (too large/small values are automatically corrected by ScrollPane)
                groupBounds = group.getLayoutBounds();
                scrollPane.setHvalue((valX + adjustment.getX()) / (groupBounds.getWidth() - viewportBounds.getWidth()));
                scrollPane.setVvalue((valY + adjustment.getY()) / (groupBounds.getHeight() - viewportBounds.getHeight()));
            }
        });
        scrollPane.setHvalue(0.5);
        scrollPane.setVvalue(0.5);
        scrollPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        scrollPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        Scene scene = new Scene(scrollPane, 564, 564);



        Timeline timeline = new Timeline(new KeyFrame(Duration.millis(60), ae ->
        {
            //mediaPlayer.setAutoPlay(true);

            int i = 0;
            pane.getChildren().clear();
            hero.clear();
            try {

                synchronized (Store.allUnits)
                {
                    for (Unit e : Store.allUnits) {
                        try {
                            //int index=hero.indexOf(e.getValue());
                            //hero.get(index).setX();
                            //hero.get(index).setY();
                            Image image6 = new Image(getClass().getResourceAsStream(e.draw()));
                            hero.add(new ImageView(image6));
                            hero.get(i).setX(e.getMyPosition().getX());
                            hero.get(i).setY(e.getMyPosition().getY());
                            hero.get(i).setFitHeight(e.getRadius() * 2);
                            hero.get(i).setFitWidth(e.getRadius() * 2);
                            pane.getChildren().add(hero.get(i));
                            i++;
                        } catch (Exception h) {
                            System.out.println(h);
                            System.out.println("exception handledlkkdL;JDKFL;JSALF;JASDFKJDAS;LFJSAL;DFJSL;");
                        }
                    }
                }

            } catch (Exception a) {

                System.out.println(a);
                System.out.println("handledflkdjjds;ljdlk;sjdlk;gfl;dsjg;lfkdlas;dj");
            }
            if(System.currentTimeMillis() >= timeout && isRunning)
            {
                DODGameManager.getInstance().PauseGame();
                System.out.println("____________________________________________");
                System.out.println("_________Times out Defender win_________");
                System.out.println("____________________________________________");
                System.exit(0);

            }
            if(!DODGameManager.mainBase.isAlive())
            {

                DODGameManager.getInstance().PauseGame();
                System.out.println();
                System.out.println("____________________________________________");
                System.out.println("_________Base destroyed Attacker win________");
                System.out.println("____________________________________________");
                System.exit(0);

            }
            if(DODGameManager.remainingAttackUnit<=0)
            {
                DODGameManager.getInstance().PauseGame();
                System.out.println();
                System.out.println("____________________________________________");
                System.out.println("_________Mission field Defender win_________");
                System.out.println("____________________________________________");
                System.exit(0);
            }
        }
        ));
        scene.addEventFilter(KeyEvent.KEY_PRESSED, (KeyEvent e) -> {
            if (null != e.getCode())
            {
                switch (e.getCode())
                {
                    case S:
                        if (timeline.getStatus() == Timeline.Status.RUNNING )
                        {
                            isRunning=false;
                            lostTime = timeout - System.currentTimeMillis();
                            DODGameManager.getInstance().PauseGame();
                            timeline.stop();
                        }
                        else if (timeline.getStatus() != Timeline.Status.RUNNING )
                        {
                            timeout = lostTime + System.currentTimeMillis();
                            isRunning=true;
                            DODGameManager.getInstance().ResumeGame();
                            timeline.play();
                        }
                        break;

                }
            }
        });


        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();
        Stage window = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.setFullScreen(true);
        window.show();
    }
}
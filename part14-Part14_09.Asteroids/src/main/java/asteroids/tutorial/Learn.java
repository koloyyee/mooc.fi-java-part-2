/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package asteroids.tutorial;

import java.util.HashMap;
import java.util.Map;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.geometry.Point2D;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Polygon;
import javafx.stage.Stage;

/**
 *
 * @author loyyeeko
 */
public class Learn extends Application {

  @Override
  public void start(Stage stage) throws Exception {
    /* Pre-Refactored */

    // how to make a polygon
    Polygon parallelogram = new Polygon(0, 0, 100, 0, 100, 50, 0, 50);
    parallelogram.setTranslateX(100);
    parallelogram.setTranslateY(20);

    Pane pane = new Pane();
    pane.setPrefSize(600, 400);
    Scene scene = new Scene(pane);

    Polygon ship = new Polygon(-5, -5, 10, 0, -5, 5);
    ship.setTranslateX(300);
    ship.setTranslateY(200);
    ship.setRotate(30);

    // basic keyboard control
    scene.setOnKeyPressed(event -> {
      KeyCode eCode = event.getCode();

      double rotDeg = ship.getRotate();
      double xTrans = ship.getTranslateX();
      // double yTrans = ship.getTranslateX();
      if (eCode == KeyCode.LEFT) {
        ship.setRotate(rotDeg - 5);
      } else if (eCode == KeyCode.RIGHT) {
        ship.setRotate(rotDeg + 5);
      }
    });
    // key presses
    Map<KeyCode, Boolean> pressedKeys = new HashMap<>();
    scene.setOnKeyPressed(event -> pressedKeys.put(event.getCode(), Boolean.TRUE));
    scene.setOnKeyReleased(event -> pressedKeys.put(event.getCode(), Boolean.FALSE));

    // start moving
    Point2D movement = new Point2D(1, 0);
    // make the key pressing responsive and smooth
    new AnimationTimer() { // refresh at 60fps
      @Override
      public void handle(long now) {
        if (pressedKeys.getOrDefault(KeyCode.LEFT, false)) {
          ship.setRotate(ship.getRotate() - 5);
        }
        if (pressedKeys.getOrDefault(KeyCode.RIGHT, false)) {
          ship.setRotate(ship.getRotate() + 5);
        }
        // start moving
        ship.setTranslateX(ship.getTranslateX() + movement.getX());
      }
    }.start();

    stage.setScene(scene);
    stage.show();

  }

}

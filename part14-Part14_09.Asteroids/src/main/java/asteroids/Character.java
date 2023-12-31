package asteroids;

import javafx.geometry.Point2D;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Shape;

/**
 *
 * @author loyyeeko
 */
public class Character {
  private final Polygon character;
  private Point2D movement;
  private boolean alive;

  public Character(Polygon polygon, int x, int y) {
    this.character = polygon;
    this.character.setTranslateX(x);
    this.character.setTranslateY(y);

    this.movement = new Point2D(0, 0);
    this.alive = true;
  }

  public Polygon getCharacter() {
    return character;
  }

  public void turnLeft() {
    this.character.setRotate(character.getRotate() - 5);
  }

  public void turnRight() {
    this.character.setRotate(character.getRotate() + 5);
  }

  public void move() {
    this.character.setTranslateX(this.character.getTranslateX() + this.movement.getX());
    this.character.setTranslateY(this.character.getTranslateY() + this.movement.getY());

    // NOTE: very important! for going on and off screen!
    // NOTE: MagicSquare logic!

    // right boundary check
    if (this.character.getTranslateX() < 0) {
      this.character.setTranslateX(this.character.getTranslateX() + AsteroidsApplication.WIDTH);
    }
    // left boundary check
    if (this.character.getTranslateX() > AsteroidsApplication.WIDTH) {
      this.character.setTranslateX(this.character.getTranslateX() % AsteroidsApplication.WIDTH);
    }

    // top boundary check
    if (this.character.getTranslateY() > AsteroidsApplication.HEIGHT) {
      this.character.setTranslateY(this.character.getTranslateY() + AsteroidsApplication.HEIGHT);
    }
    // bottom boundary check
    if (this.character.getTranslateY() > AsteroidsApplication.WIDTH) {
      this.character.setTranslateY(this.character.getTranslateY() % AsteroidsApplication.HEIGHT);
    }
  }

  public void accelerate() {
    double changeX = Math.cos(Math.toRadians(character.getRotate()));
    double changeY = Math.sin(Math.toRadians(character.getRotate()));

    changeX *= 0.05;
    changeY *= 0.05;

    this.movement = this.movement.add(changeX, changeY);
  }

  public boolean collide(Character other) {
    // NOTE: Shape.intersect check 2 shape intersect and act as collision check.
    Shape collisionArea = Shape.intersect(this.character, other.getCharacter());
    return collisionArea.getBoundsInLocal().getWidth() != -1;
  }

  public Point2D getMovement() {
    return movement;
  }

  public void setMovement(Point2D movement) {
    this.movement = movement;
  }

  public boolean isAlive() {
    return alive;
  }

  public void setAlive(boolean alive) {
    this.alive = alive;
  }
}

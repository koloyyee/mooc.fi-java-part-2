package asteroids;

import java.util.Random;

/**
 *
 * @author loyyeeko
 */
public class Asteroid extends Character {
  private final double rotationalMovement;

  public Asteroid(int x, int y) {
    super(new PolygonFactory().createPolygon(), x, y);

    // NOTE: random movement start when the polygon is spawned
    Random rand = new Random();
    super.getCharacter().setRotate(rand.nextInt(360));

    int acceAmount = 1 + rand.nextInt(10);
    for (int i = 0; i < acceAmount; i++) {
      accelerate();
    }
    this.rotationalMovement = 0.5 - rand.nextDouble();
  }

  @Override
  public void move() {
    super.move();
    super.getCharacter()
        .setRotate(
            super.getCharacter().getRotate() + rotationalMovement);
  }
}

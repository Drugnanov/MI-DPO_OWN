package cz.fit.dpo.mvcshooter.model.entities;

import cz.fit.dpo.mvcshooter.model.ModelConfig;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Drugnanov on 7.1.2016.
 */
public class EnemyTest {

  @Test
  public void testMove() throws Exception {
    FallingEnemy fallEnemy = new FallingEnemy(1, 1);
    fallEnemy.setY(1);
    assertEquals(fallEnemy.isVisible(), true);
    fallEnemy.setY(ModelConfig.PLAYGROUND_HEIGHT);
    assertEquals(fallEnemy.isVisible(), true);
    fallEnemy.setY(ModelConfig.PLAYGROUND_HEIGHT + 1);
    assertEquals(fallEnemy.getY(), ModelConfig.PLAYGROUND_HEIGHT + 1);
    assertEquals(fallEnemy.isVisible(), false);

    fallEnemy.setY(1);
    fallEnemy.setX(1);
    assertEquals(fallEnemy.isVisible(), true);
    fallEnemy.setX(ModelConfig.PLAYGROUND_WIDTH);
    assertEquals(fallEnemy.isVisible(), true);
    fallEnemy.setX(ModelConfig.PLAYGROUND_WIDTH + 1);
    assertEquals(fallEnemy.getX(), ModelConfig.PLAYGROUND_WIDTH + 1);
    assertEquals(fallEnemy.isVisible(), false);
    assertEquals(false, false);
  }
}

package cz.fit.dpo.mvcshooter.model.entities;

import cz.fit.dpo.mvcshooter.model.ModelConfig;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Drugnanov on 7.1.2016.
 */
public class EnemyTest {

  @Test
  public void testMoveYBase() throws Exception {
    FallingEnemy fallEnemy = new FallingEnemy(1, 1);
    fallEnemy.setY(1);
    assertEquals(fallEnemy.isVisible(), true);
  }

  @Test
  public void testMoveYFrontier() throws Exception {
    FallingEnemy fallEnemy = new FallingEnemy(1, 1);
    fallEnemy.setY(ModelConfig.PLAYGROUND_HEIGHT);
    assertEquals(fallEnemy.isVisible(), true);
  }

  @Test
  public void testMoveYNotVisible() throws Exception {
    FallingEnemy fallEnemy = new FallingEnemy(1, 1);
    fallEnemy.setY(ModelConfig.PLAYGROUND_HEIGHT + 1);
    assertEquals(fallEnemy.isVisible(), false);
  }

  @Test
  public void testMoveXBase() throws Exception {
    FallingEnemy fallEnemy = new FallingEnemy(1, 1);
    fallEnemy.setX(1);
    assertEquals(fallEnemy.isVisible(), true);
  }

  @Test
  public void testMoveXFrontier() throws Exception {
    FallingEnemy fallEnemy = new FallingEnemy(1, 1);
    fallEnemy.setX(ModelConfig.PLAYGROUND_WIDTH);
    assertEquals(fallEnemy.isVisible(), true);
  }

  @Test
  public void testMoveXNotVisible() throws Exception {
    FallingEnemy fallEnemy = new FallingEnemy(1, 1);
    fallEnemy.setX(ModelConfig.PLAYGROUND_WIDTH + 1);
    assertEquals(fallEnemy.isVisible(), false);
  }
}

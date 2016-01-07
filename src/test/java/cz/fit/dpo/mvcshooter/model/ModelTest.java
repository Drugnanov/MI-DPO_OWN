package cz.fit.dpo.mvcshooter.model;

import cz.fit.dpo.mvcshooter.model.entities.*;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class ModelTest {

  List<Missile> missiles = new ArrayList<Missile>();
  List<Enemy> enemies = new ArrayList<Enemy>();
  List<Collision> collisions = new ArrayList<Collision>();
  Cannon cannon;
  Score score;

  int count;

  @Before
  public void beforeTest() {
    missiles.add(mock(Missile.class));
    missiles.add(mock(Missile.class));
    enemies.add(mock(SimpleEnemy.class));
    enemies.add(mock(SimpleEnemy.class));
    enemies.add(mock(SimpleEnemy.class));
    collisions.add(mock(Collision.class));
    collisions.add(mock(Collision.class));
    cannon = mock(Cannon.class);
    score = mock(Score.class);
    count = 9;
  }

  @Test
  public void testLoadGame() throws Exception {
    Model model = mock(Model.class);
    when(model.getMissiles()).thenReturn(missiles);
    when(model.getEnemies()).thenReturn(enemies);
    when(model.getCollisions()).thenReturn(collisions);
    when(model.getCannon()).thenReturn(cannon);
    when(model.getScore()).thenReturn(score);

    doCallRealMethod().when(model).getAll();

    assertEquals(model.getAll().size(), count);
  }
}
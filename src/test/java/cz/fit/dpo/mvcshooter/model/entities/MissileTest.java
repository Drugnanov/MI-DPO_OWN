package cz.fit.dpo.mvcshooter.model.entities;

import cz.fit.dpo.mvcshooter.model.movement.MovementStrategy;
import cz.fit.dpo.mvcshooter.model.movement.RealisticMovementImp;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class MissileTest {

  Missile m;

  @Before
  public void executedBeforeEach() {
    m = new Missile(5, 10, 1, 2);
    assertEquals(m.getBeginX(), 5);
    assertEquals(m.getBeginY(), 10);
    assertEquals(m.getAngle(), 1);
    assertEquals(m.getForce(), 2);
  }

  @Test
  public void testMove() throws Exception {

    MovementStrategy realisticMovement = mock(RealisticMovementImp.class);

    Coordinates coordinates = new Coordinates(10, 15);
    when(realisticMovement.move(5, m)).thenReturn(coordinates);

    m.setMovementStrategy(realisticMovement);

    assertEquals(m.getMovementStrategy(), realisticMovement);

    m.move(5);

    assertEquals(coordinates.getX(), m.getX());
    assertEquals(coordinates.getY(), m.getY());
  }
}
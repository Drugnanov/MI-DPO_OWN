package cz.fit.dpo.mvcshooter.model.shootingmodes;

import cz.fit.dpo.mvcshooter.model.entities.Cannon;
import cz.fit.dpo.mvcshooter.model.entities.Missile;
import cz.fit.dpo.mvcshooter.model.gamemodes.GameMode;
import cz.fit.dpo.mvcshooter.model.gamemodes.SimpleGameModeImp;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.*;

public class SingleShootingModeTest {

  Cannon cannon;
  GameMode gameMode;

  @Before
  public void beforeTest() {
    cannon = spy(Cannon.class);
    gameMode = mock(SimpleGameModeImp.class);
  }

  @Test
  public void testShoot() throws Exception {
    ShootingMode sm = spy(SingleShootingMode.class);
    when(gameMode.createMissile(anyInt(), anyInt(), anyInt(), anyInt())).thenReturn(mock(Missile.class));
    List<Missile> missiles = sm.shoot(cannon, gameMode);

    assertEquals(missiles.size(), 1);
  }
}
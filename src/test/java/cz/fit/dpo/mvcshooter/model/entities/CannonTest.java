package cz.fit.dpo.mvcshooter.model.entities;

import cz.fit.dpo.mvcshooter.model.shootingmodes.DoubleShootingMode;
import cz.fit.dpo.mvcshooter.model.shootingmodes.ShootingMode;
import cz.fit.dpo.mvcshooter.model.shootingmodes.SingleShootingMode;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;


public class CannonTest {

  @Test
  public void testGetShootingMode() throws Exception {
    ShootingMode sm = mock(DoubleShootingMode.class);
    doCallRealMethod().when(sm).printName();

    Cannon cannon = spy(Cannon.class);
    cannon.setShootingMode(sm);

    assertEquals(sm, cannon.getShootingMode());
    assertEquals("Double", cannon.getShootingModeName());
  }

  @Test
  public void testChangeShootingMode() throws Exception {
    ShootingMode smDouble = mock(DoubleShootingMode.class);
    ShootingMode smSingle = mock(SingleShootingMode.class);

    doCallRealMethod().when(smDouble).getShootingType();

    Cannon cannon = spy(Cannon.class);
    cannon.setShootingMode(smDouble);

    assertEquals(smDouble, cannon.getShootingMode());

    when(cannon.getSingleShootingMode()).thenReturn(smSingle);
    cannon.changeShootingMode();

    assertEquals(smSingle, cannon.getShootingMode());
  }
}
package cz.fit.dpo.mvcshooter.model.shootingmodes;

import cz.fit.dpo.mvcshooter.model.ModelConfig;
import cz.fit.dpo.mvcshooter.model.entities.Cannon;
import cz.fit.dpo.mvcshooter.model.entities.Missile;
import cz.fit.dpo.mvcshooter.model.gamemodes.GameMode;

import java.util.ArrayList;

/**
 * Created by Drugnanov on 6.1.2016.
 */
public class DoubleShootingMode implements ShootingMode {

  @Override
  public ArrayList<Missile> shoot(Cannon cannon, GameMode gameMode) {
    ArrayList<Missile> missiles = new ArrayList<Missile>();
    Missile firstMissile = gameMode.createMissile(cannon.getX(), cannon.getY(), cannon.getAngle(), cannon.getForce());
    missiles.add(firstMissile);
    int addedAngle = cannon.getAngle() + ModelConfig.CANNON_AIM_STEP;
    Missile secondMissile = gameMode.createMissile(cannon.getX(), cannon.getY(), addedAngle, cannon.getForce());
    missiles.add(secondMissile);
    return missiles;
  }

  @Override
  public ShootingModeType getShootingType() {
    return ShootingModeType.DOUBLE;
  }

  @Override
  public String printName() {
    return "Double";
  }
}

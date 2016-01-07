package cz.fit.dpo.mvcshooter.model.shootingmodes;

import cz.fit.dpo.mvcshooter.model.entities.Cannon;
import cz.fit.dpo.mvcshooter.model.entities.Missile;
import cz.fit.dpo.mvcshooter.model.gamemodes.GameMode;

import java.util.ArrayList;

/**
 * Created by Drugnanov on 6.1.2016.
 */
public interface ShootingMode {

  ArrayList<Missile> shoot(Cannon cannon, GameMode gameMode);

  ShootingModeType getShootingType();

  String printName();
}

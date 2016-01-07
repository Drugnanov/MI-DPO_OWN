package cz.fit.dpo.mvcshooter.model.entities;

import cz.fit.dpo.mvcshooter.model.ModelConfig;

/**
 * Created by Drugnanov on 6.1.2016.
 */
public class SimpleEnemy extends Enemy {

  public SimpleEnemy(int x, int y) {
    super(x, y);
    time = ModelConfig.ENEMY_LIVE_TIME;
  }

  @Override
  public void move() {
    time--;
  }

  @Override
  public boolean isVisible() {
    return time >= 0;
  }

  @Override
  public Enemy copy() {
    SimpleEnemy se = new SimpleEnemy(x, y);
    se.setTime(time);
    se.setType(type);
    return se;
  }
}

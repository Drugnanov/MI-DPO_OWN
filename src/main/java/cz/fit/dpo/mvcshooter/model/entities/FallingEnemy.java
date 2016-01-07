package cz.fit.dpo.mvcshooter.model.entities;

import cz.fit.dpo.mvcshooter.model.ModelConfig;

/**
 * Created by Drugnanov on 6.1.2016.
 */
public class FallingEnemy extends Enemy {

  public FallingEnemy(int x, int y) {
    super(x, 0);
  }

  @Override
  public void move() {
    time++;
    y = time;
  }

  @Override
  public boolean isVisible() {
    return y <= ModelConfig.PLAYGROUND_HEIGHT && x <= ModelConfig.PLAYGROUND_WIDTH;
  }

  @Override
  public Enemy copy() {
    FallingEnemy re = new FallingEnemy(x, y);
    re.setTime(time);
    re.setType(type);
    return re;
  }
}

package cz.fit.dpo.mvcshooter.model.entities;

import cz.fit.dpo.mvcshooter.model.Acceptable;
import cz.fit.dpo.mvcshooter.model.ModelConfig;
import cz.fit.dpo.mvcshooter.model.Visitor;

/**
 * @author Ondrej Stuchlik
 */
public abstract class GameObject implements Acceptable {

  protected int x, y;

  public GameObject(int x, int y) {
    this.x = x;
    this.y = y;
  }

  public int getX() {
    return x;
  }

  public int getY() {
    return y;
  }

  protected void setX(int x) {
    this.x = x;
  }

  protected void setY(int y) {
    this.y = y;
  }

  public boolean collidesWith(GameObject anotherObject) {
    return Math.abs(this.x - anotherObject.x) < ModelConfig.COLLISION_MARGIN
        && Math.abs(this.y - anotherObject.y) < ModelConfig.COLLISION_MARGIN;
  }

  @Override
  public abstract void accept(Visitor visitor);
}

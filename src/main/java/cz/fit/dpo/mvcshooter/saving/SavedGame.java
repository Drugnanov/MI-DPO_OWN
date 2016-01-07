package cz.fit.dpo.mvcshooter.saving;

import cz.fit.dpo.mvcshooter.model.Model;
import cz.fit.dpo.mvcshooter.model.ModelConfig;
import cz.fit.dpo.mvcshooter.model.entities.Collision;
import cz.fit.dpo.mvcshooter.model.entities.Enemy;
import cz.fit.dpo.mvcshooter.model.entities.Missile;
import cz.fit.dpo.mvcshooter.model.entities.Score;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Drugnanov on 6.1.2016.
 */
public class SavedGame {

  private List<Enemy> enemies = new ArrayList<Enemy>();
  private List<Missile> missiles = new ArrayList<Missile>();
  private List<Collision> collisions = new ArrayList<Collision>();
  private int gravity = ModelConfig.DEFAULT_GRAVITY;
  private Score score = null;
  private int timeTicks;

  public SavedGame(Model model) {
    for (Enemy enemy : model.getEnemies()) {
      this.enemies.add(enemy.copy());
    }

    for (Missile missile : model.getMissiles()) {
      this.missiles.add(missile.copy());
    }

    for (Collision collision : model.getCollisions()) {
      this.collisions.add(collision.copy());
    }

    this.gravity = model.getGravity();
    this.score = model.getScore().copy();
    this.timeTicks = model.getTimeTicks();
  }


  public List<Enemy> getEnemies() {
    return enemies;
  }

  public List<Missile> getMissiles() {
    return missiles;
  }

  public List<Collision> getCollisions() {
    return collisions;
  }

  public int getGravity() {
    return gravity;
  }

  public Score getScore() {
    return score;
  }

  public int getTimeTicks() {
    return timeTicks;
  }
}

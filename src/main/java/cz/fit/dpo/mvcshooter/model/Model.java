package cz.fit.dpo.mvcshooter.model;

import cz.fit.dpo.mvcshooter.model.entities.*;
import cz.fit.dpo.mvcshooter.model.gamemodes.GameMode;
import cz.fit.dpo.mvcshooter.saving.SavedGame;

import java.time.LocalTime;
import java.util.*;

/**
 * @author Ondrej Stuchlik
 */
public class Model {

  private List<Missile> missiles = new ArrayList<Missile>();
  private List<Enemy> enemies = new ArrayList<Enemy>();
  private List<Collision> collisions = new ArrayList<Collision>();
  private Cannon cannon;
  private Timer timer;
  private int gravity = ModelConfig.DEFAULT_GRAVITY;
  private List<ModelObserver> observers = new ArrayList<ModelObserver>();
  private GameMode gameMode;
  private int timeTicks = 0;
  private Score score;

  public Model(GameMode mode) {
    this.gameMode = mode;
    init();
  }

  private void init() {
    cannon = new Cannon();
    score = new Score(this);
    initTimer();
  }

  public int getPlaygroundWidth() {
    return ModelConfig.PLAYGROUND_WIDTH;
  }

  public int getPlaygroundHeight() {
    return ModelConfig.PLAYGROUND_HEIGHT;
  }

  private void initTimer() {
    timer = new Timer();
    timer.schedule(new TimerTask() {
      @Override
      public void run() {
        moveObjects();
      }
    }, 0, ModelConfig.TIME_TICK);
    timer.schedule(new TimerTask() {
      @Override
      public void run() {
        addNewEnemy();
      }
    }, 0, ModelConfig.TIME_ADD_NEW_ENEMY);
    timer.schedule(new TimerTask() {
      @Override
      public void run() {
        timeTicks++;
      }
    }, 0, ModelConfig.TIME_SECOND);
  }

  private void addNewEnemy() {
    if (enemies.size() == ModelConfig.ENEMIES_COUNT) {
      return;
    }
    int generatedX = (int) (Math.random() * (ModelConfig.PLAYGROUND_WIDTH - 130)) + 100;
    int generatedY = (int) (Math.random() * (ModelConfig.PLAYGROUND_HEIGHT - 60)) + 30;
    Enemy enemy = gameMode.createEnemy(generatedX, generatedY);
    enemies.add(enemy);
    notifyObservers();
  }

  private void moveObjects() {
    refreshMissiles();
    refreshEnemies();
    refreshCollisions();
    checkCollisions();
    notifyObservers();
  }

  private void checkCollisions() {
    for (Iterator<Enemy> enemyIter = enemies.iterator(); enemyIter.hasNext(); ) {
      Enemy enemy = enemyIter.next();
      for (Iterator<Missile> missileIter = missiles.iterator(); missileIter.hasNext(); ) {
        Missile missile = missileIter.next();
        if (missile.collidesWith(enemy)) {
          collisions.add(new Collision(enemy.getX(), enemy.getY()));
          score.addScore();
          try {
            enemyIter.remove();
            missileIter.remove();
          }
          catch (Exception ex) {
            ex.printStackTrace(System.err);
            System.out.println("Problem with collisions." + ex.getMessage());
          }
        }
      }
    }
  }

  private void refreshCollisions() {
    for (Iterator<Collision> colIter = collisions.iterator(); colIter.hasNext(); ) {
      Collision collision = colIter.next();
      collision.decreaseRemainingTime();
      if (!collision.isVisible()) {
        colIter.remove();
      }
    }
  }

  private void refreshEnemies() {
    boolean removed = false;
    for (Iterator<Enemy> it = enemies.iterator(); it.hasNext(); ) {
      Enemy enemy = it.next();
      enemy.move();
      if (!enemy.isVisible()) {
        it.remove();
        removed = true;
      }
    }
    if (removed) {
      addNewEnemy();
    }
  }

  private void refreshMissiles() {
    for (Iterator<Missile> it = missiles.iterator(); it.hasNext(); ) {
      Missile missile = it.next();
      missile.move(gravity);
      if (!missile.isVisible()) {
        score.minusScore();
        it.remove();
      }
    }
  }

  public void moveCannonDown() {
    cannon.moveDown();
    notifyObservers();
  }

  public void moveCannonUp() {
    cannon.moveUp();
    notifyObservers();
  }

  public void forceOfCannonDown() {
    cannon.forceDown();
  }

  public void forceOfCannonUp() {
    cannon.forceUp();
  }

  public void aimCannonUp() {
    cannon.aimUp();
  }

  public void aimCannonDown() {
    cannon.aimDown();
  }

  public void shootCannon() {
    ArrayList<Missile> newMissiles = cannon.shootMissile(gameMode);
    missiles.addAll(newMissiles);
    notifyObservers();
  }

  public void increaseGravity() {
    gravity += ModelConfig.GRAVITY_STEP;
  }

  public void decreaseGravity() {
    gravity -= ModelConfig.GRAVITY_STEP;
  }

  public String getTimeString() {
    return LocalTime.MIN.plusSeconds(timeTicks).toString();
  }

  // ################################## private logic ##################################


  public List<Missile> getMissiles() {
    return missiles;
  }

  public List<Enemy> getEnemies() {
    return enemies;
  }

  public List<Collision> getCollisions() {
    return collisions;
  }

  public Cannon getCannon() {
    return cannon;
  }

  public int getGravity() {
    return gravity;
  }

  public List<GameObject> getAll() {
    List<GameObject> all = new ArrayList<GameObject>();
    all.add(getCannon());
    all.addAll(getEnemies());
    all.addAll(getMissiles());
    all.addAll(getCollisions());
    all.add(getScore());
    return all;
  }

  public void attach(ModelObserver observer) {
    observers.add(observer);
  }

  public void detach(ModelObserver observer) {
    observers.remove(observer);
  }

  private void notifyObservers() {
    for (ModelObserver obs : observers) {
      obs.modelUpdated();
    }
  }

  public void toggleShootingMode() {
    cannon.changeShootingMode();
  }

  public String getShootingMode() {
    return cannon.getShootingModeName();
  }

  public SavedGame saveGame() {
    return new SavedGame(this);
  }

  public void loadGame(SavedGame savedGame) {
    enemies.clear();
    missiles.clear();
    collisions.clear();
    for (Enemy enemy : savedGame.getEnemies()) {
      enemies.add(enemy.copy());
    }
    for (Missile missile : savedGame.getMissiles()) {
      missiles.add(missile.copy());
    }
    for (Collision collision : savedGame.getCollisions()) {
      collisions.add(collision.copy());
    }
    gravity = savedGame.getGravity();
    score = savedGame.getScore().copy();
    timeTicks = savedGame.getTimeTicks();
  }

  public Score getScore() {
    return score;
  }

  public int getTimeTicks() {
    return timeTicks;
  }
}

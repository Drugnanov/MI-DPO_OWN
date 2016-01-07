package cz.fit.dpo.mvcshooter.model;

/**
 * @author Ondrej Stuchlik
 */
public class ModelConfig {

  public static final int PLAYGROUND_WIDTH = 500;
  public static final int PLAYGROUND_HEIGHT = 500;
  public static final int DEFAULT_GRAVITY = 5;
  public static final int GRAVITY_STEP = 1;
  public static final int HIT_POINTS = 10;


  // ########### cannon ##########
  // cannon moves just vertically, therefore x doesn't change
  public static final int CANNON_X = 20;
  public static final int CANNON_DEFAULT_Y = PLAYGROUND_HEIGHT / 2;
  public static final int CANNON_TOP_MARGIN = (int) (ModelConfig.PLAYGROUND_HEIGHT * 0.1);
  public static final int CANNON_BOTTOM_MARGIN = (int) (ModelConfig.PLAYGROUND_HEIGHT * 0.1);
  public static final int CANNON_MOVE_STEP = 10;

  public static final int CANNON_DEFAULT_ANGLE = 20;
  public static final int CANNON_MAX_UP_ANGLE = 90;
  public static final int CANNON_MAX_DOWN_ANGLE = -90;
  public static final int CANNON_AIM_STEP = 10;

  public static final int CANNON_DEFAULT_FORCE = 50;
  public static final int CANNON_MAX_FORCE = 100;
  public static final int CANNON_MIN_FORCE = 1;
  public static final int CANNON_FORCE_STEP = 1;


  // ########### Game Score ##########
  public static final int SCORE_POSITION_X = 10;
  public static final int SCORE_POSITION_Y = 10;

  // ########### missiles ##########

  // ########### enemies ##########
  public static final int ENEMY_LIVE_TIME = 60000;
  public static final int ENEMIES_COUNT = 4;

  // ########### collisions ##########
  public static final int COLLISION_MARGIN = 20;
  public static final int COLLISION_LIVE_TIME = 500;

  // ########### Timers ##########
  public static final long TIME_ADD_NEW_ENEMY = 4500;
  public static final long TIME_SECOND = 1000;
  public static final int TIME_TICK = 20;

  public static final String STRING_LINE_SEPARATOR = System.getProperty("line.separator");
}

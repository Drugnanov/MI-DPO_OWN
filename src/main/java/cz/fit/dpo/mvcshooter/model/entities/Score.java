package cz.fit.dpo.mvcshooter.model.entities;

import cz.fit.dpo.mvcshooter.model.Model;
import cz.fit.dpo.mvcshooter.model.ModelConfig;
import cz.fit.dpo.mvcshooter.model.Visitor;

/**
 * Created by Drugnanov on 7.1.2016.
 */
public class Score extends GameObject {

  private Model model;

  private int score = 0;

  public Score(Model model) {
    super(ModelConfig.SCORE_POSITION_X, ModelConfig.SCORE_POSITION_Y);
    this.model = model;
  }

  public int getScore() {
    return score;
  }

  public void addScore() {
    score += ModelConfig.HIT_POINTS;
  }

  public void minusScore() {
    score--;
  }

  public Score copy() {
    Score gameStats = new Score(model);
    gameStats.score = this.getScore();
    return gameStats;
  }

  @Override
  public void accept(Visitor visitor) {
    visitor.visit(this);
  }

  public String print() {
    String ls = System.getProperty("line.separator");
    final StringBuilder sb = new StringBuilder();
    sb.append("Score: " + score)
        .append(ls)
        .append(" time: " + model.getTimeString())
        .append(ls)
        .append(" angle: " + model.getCannon().getAngle())
        .append(ls)
        .append(" force: " + model.getCannon().getForce())
        .append(ls)
        .append(" cannon mode: " + model.getShootingMode());
    return sb.toString();
  }
}

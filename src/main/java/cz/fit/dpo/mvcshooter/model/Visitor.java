package cz.fit.dpo.mvcshooter.model;

import cz.fit.dpo.mvcshooter.model.entities.*;

/**
 * Created by Drugnanov on 6.1.2016.
 */
public interface Visitor {
  void visit(Enemy enemy);
  void visit(Cannon enemy);
  void visit(Missile enemy);
  void visit(Collision enemy);
  void visit(Score enemy);
}

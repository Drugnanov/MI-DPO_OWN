package cz.fit.dpo.mvcshooter.model;

/**
 * Created by Drugnanov on 6.1.2016.
 */
public interface Acceptable {

  void accept(Visitor visitor);
}

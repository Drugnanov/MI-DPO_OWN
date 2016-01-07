package cz.fit.dpo.mvcshooter;

import cz.fit.dpo.mvcshooter.controller.Controller;
import cz.fit.dpo.mvcshooter.model.Model;
import cz.fit.dpo.mvcshooter.model.gamemodes.GameMode;
import cz.fit.dpo.mvcshooter.model.gamemodes.RealisticGameModeImp;
import cz.fit.dpo.mvcshooter.model.gamemodes.SimpleGameModeImp;
import cz.fit.dpo.mvcshooter.view.MainWindow;

import javax.swing.*;

/**
 * Created by Drugnanov on 6.1.2016.
 */
public class Shooter {

  private static final boolean SIMPLE_GAME_MODE = true;

  public static void main(String[] args) {

    GameMode mode = (SIMPLE_GAME_MODE) ? new SimpleGameModeImp() : new RealisticGameModeImp();

    final Model model = new Model(mode);
    final Controller controller = new Controller(model);

    SwingUtilities.invokeLater(new Runnable() {

      @Override
      public void run() {
        new MainWindow(model, controller).setVisible(true);
      }
    });
  }
}

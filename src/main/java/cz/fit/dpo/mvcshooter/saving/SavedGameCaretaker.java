package cz.fit.dpo.mvcshooter.saving;

import cz.fit.dpo.mvcshooter.model.Model;

/**
 * Created by Drugnanov on 6.1.2016.
 */
public class SavedGameCaretaker {

  private SavedGame savedGame;

  public void saveGame(Model model) {
    savedGame = model.saveGame();
  }

  public void loadGame(Model model) {
    if (savedGame == null) return;
    model.loadGame(savedGame);
  }
}

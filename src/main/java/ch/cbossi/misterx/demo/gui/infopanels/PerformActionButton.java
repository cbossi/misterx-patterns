package ch.cbossi.misterx.demo.gui.infopanels;

import ch.cbossi.misterx.model.game.Game;
import ch.cbossi.misterx.model.observers.GameStateChangeObserver;

import javax.swing.*;


public class PerformActionButton extends JButton implements GameStateChangeObserver {

  private final Game game;

  public PerformActionButton(Game game, String text) {
    super(text);
    this.game = game;
    game.addGameStateChangeObserver(this);
  }

  private static final long serialVersionUID = -2298932250990144292L;

  @Override
  public void gameStateChangeUpdate() {
    if (game.isFinished()) {
      setEnabled(false);
    }
  }

}

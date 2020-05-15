package ch.cbossi.misterx.model.commands;

import ch.cbossi.misterx.model.game.Game;
import ch.cbossi.misterx.model.game.GameImpl;

public abstract class AbstractGameCommand implements GameCommand {

  protected Game getGame() {
    return GameImpl.getInstance();
  }

}

package misterx.model.commands;

import misterx.model.game.Game;
import misterx.model.game.GameImpl;

public abstract class AbstractGameCommand implements GameCommand {

  protected Game getGame() {
    return GameImpl.getInstance();
  }

}

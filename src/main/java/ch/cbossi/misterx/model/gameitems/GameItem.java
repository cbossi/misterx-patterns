package ch.cbossi.misterx.model.gameitems;

import ch.cbossi.misterx.model.game.Game;
import ch.cbossi.misterx.model.observers.GameItemObservable;

import java.io.Serializable;


public interface GameItem extends Serializable, GameItemObservable {

  public Game getGame();

  public void printMessage(String message);
}

package misterx.model.gameitems;

import misterx.model.game.Game;
import misterx.model.observers.GameItemObservable;

import java.io.Serializable;


public interface GameItem extends Serializable, GameItemObservable {

  public Game getGame();

  public void printMessage(String message);
}

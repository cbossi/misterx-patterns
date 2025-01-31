package ch.cbossi.misterx.model.gameitems.impl;

import ch.cbossi.misterx.model.game.Game;
import ch.cbossi.misterx.model.game.GameImpl;
import ch.cbossi.misterx.model.gameitems.GameItem;
import ch.cbossi.misterx.model.observers.GameItemObserver;
import ch.cbossi.misterx.model.util.Messsages;

import java.util.ArrayList;
import java.util.List;


public abstract class AbstractGameItemImpl implements GameItem {

  private static final long serialVersionUID = -3635905975313361023L;

  private final List<GameItemObserver> observers;

  public AbstractGameItemImpl() {
    this.observers = new ArrayList<GameItemObserver>();
  }

  @Override
  public Game getGame() {
    return GameImpl.getInstance();
  }

  @Override
  public void printMessage(String message) {
    Messsages.printMessage(message);
  }

  @Override
  public void addGameItemObserver(GameItemObserver observer) {
    observers.add(observer);

  }

  @Override
  public void removeGameItemObserver(GameItemObserver observer) {
    observers.remove(observer);

  }

  @Override
  public void notifyGameItemObservers() {
    for (GameItemObserver observer : observers) {
      observer.gameItemUpdate();
    }
  }

  @Override
  public abstract String toString();

}

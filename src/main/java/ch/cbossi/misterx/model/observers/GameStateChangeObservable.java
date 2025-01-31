package ch.cbossi.misterx.model.observers;

public interface GameStateChangeObservable {

  public void addGameStateChangeObserver(GameStateChangeObserver observer);

  public void removeGameStateChangeObserver(GameStateChangeObserver observer);

  public void notifyGameStateChangeObservers();
}

package ch.cbossi.misterx.model.game;

import ch.cbossi.misterx.model.game.helpers.PositionChecker;
import ch.cbossi.misterx.model.game.states.GameState;
import ch.cbossi.misterx.model.gameitems.Character;
import ch.cbossi.misterx.model.gameitems.*;
import ch.cbossi.misterx.model.gameitems.collections.GameItemList;
import ch.cbossi.misterx.model.gameitems.enums.DetectiveType;
import ch.cbossi.misterx.model.mapparser.MapDataParser;
import ch.cbossi.misterx.model.observers.GameStateChangeObservable;

public interface Game extends GameStateChangeObservable {

  public static final int NUMBER_OF_ROUNDS_UNTIL_MISTER_X_WINS = 20;
  public static final int MAX_NUMBER_OF_DETECTIVES = 4;

  public GameState getCurrentGameState();

  public void setCurrentGameState(GameState currentGameState);

  public void init();

  public boolean isReady();

  public boolean isFinished();

  public PositionChecker getPositionChecker();

  public Map getMap();

  public int getRound();

  public void increaseRound();

  public GameItemList<Connection> getConnections();

  public MisterX getMisterX();

  public void setMisterX(MisterX misterX);

  public GameItemList<Detective> getDetectives();

  public Detective getDetective(DetectiveType type);

  public ch.cbossi.misterx.model.gameitems.Character getWinner();

  public void setWinner(ch.cbossi.misterx.model.gameitems.Character character);

  public void fillMap(MapDataParser mapDataParser);

  public void addMisterX(MisterX misterX);

  public void addDetective(Detective detective);

  public void startGame();

  public void setStartPosition(Character character, City startPosition);

  public void moveMisterXTo(City destinationCity);

  public void moveDetectiveTo(Detective detective, City destinationCity);

  public void checkSituation();
}

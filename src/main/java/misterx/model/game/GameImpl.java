package misterx.model.game;

import misterx.model.factory.GameItemFactory;
import misterx.model.factory.GameItemFactoryImpl;
import misterx.model.game.helpers.PositionChecker;
import misterx.model.game.states.DefaultGameState;
import misterx.model.game.states.FinishedGameState;
import misterx.model.game.states.GameState;
import misterx.model.game.states.StartGameState;
import misterx.model.gameitems.Character;
import misterx.model.gameitems.*;
import misterx.model.gameitems.collections.GameItemList;
import misterx.model.gameitems.enums.DetectiveType;
import misterx.model.gameitems.impl.collections.GameItemListImpl;
import misterx.model.mapparser.MapDataParser;
import misterx.model.observers.GameStateChangeObserver;

import java.util.ArrayList;
import java.util.List;


public class GameImpl implements Game {

  private static Game instance;

  private final List<GameStateChangeObserver> observers;
  private GameState currentGameState;
  private Map map;
  private MisterX misterX;
  private GameItemList<Detective> detectives;
  private PositionChecker positionChecker;
  private int round;
  private Character winner;

  private GameImpl() {
    observers = new ArrayList<GameStateChangeObserver>();
    initHelpers();
    initGameState();
    setDefaultValues();

  }

  private void initHelpers() {
    this.positionChecker = new PositionChecker();
  }

  private void initGameState() {
    this.currentGameState = new DefaultGameState();
  }

  private void setDefaultValues() {
    GameItemFactory factory = GameItemFactoryImpl.getInstance();
    this.map = factory.createMap();
    this.misterX = factory.createMisterX();
    this.detectives = new GameItemListImpl<Detective>();
    this.winner = factory.createUnknownCharacter();
    round = 0;
  }

  public static Game getInstance() {
    if (instance == null) {
      instance = new GameImpl();
    }
    return instance;
  }

  @Override
  public void init() {
    this.currentGameState = new StartGameState(this);
  }

  @Override
  public boolean isReady() {
    return detectives.size() > 0 && map.isFilled();
  }

  @Override
  public boolean isFinished() {
    return getCurrentGameState() instanceof FinishedGameState;
  }

  @Override
  public PositionChecker getPositionChecker() {
    return positionChecker;
  }

  @Override
  public int getRound() {
    return round;
  }

  @Override
  public void increaseRound() {
    round = round + 1;
  }

  @Override
  public GameState getCurrentGameState() {
    return currentGameState;
  }

  @Override
  public void setCurrentGameState(GameState currentGameState) {
    this.currentGameState = currentGameState;
    notifyGameStateChangeObservers();
  }

  @Override
  public void fillMap(MapDataParser mapDataParser) {
    getCurrentGameState().fillMap(mapDataParser);
  }

  @Override
  public void addMisterX(MisterX misterX) {
    getCurrentGameState().addMisterX(misterX);
  }

  @Override
  public void addDetective(Detective detective) {
    getCurrentGameState().addDetective(detective);
  }

  @Override
  public void startGame() {
    getCurrentGameState().startGame();
  }

  @Override
  public void setStartPosition(Character character, City startPosition) {
    getCurrentGameState().setStartPosition(character, startPosition);
  }

  @Override
  public void moveMisterXTo(City destinationCity) {
    getCurrentGameState().moveMisterXTo(destinationCity);
  }

  @Override
  public void moveDetectiveTo(Detective detective, City destinationCity) {
    getCurrentGameState().moveDetectiveTo(detective, destinationCity);
  }

  @Override
  public void checkSituation() {
    getCurrentGameState().checkSituation();
  }

  @Override
  public MisterX getMisterX() {
    return misterX;
  }

  @Override
  public void setMisterX(MisterX misterX) {
    this.misterX = misterX;
  }

  @Override
  public GameItemList<Detective> getDetectives() {
    return detectives;
  }

  @Override
  public Detective getDetective(DetectiveType type) {
    for (Detective detective : detectives) {
      if (detective.getType().equals(type)) {
        return detective;
      }
    }
    return GameItemFactoryImpl.getInstance().createDetective(DetectiveType.DEFAULT);
  }

  @Override
  public GameItemList<Connection> getConnections() {
    return map.getConnections();
  }

  @Override
  public Map getMap() {
    return map;
  }

  @Override
  public Character getWinner() {
    return winner;
  }

  @Override
  public void setWinner(Character winner) {
    this.winner = winner;
  }

  @Override
  public void addGameStateChangeObserver(GameStateChangeObserver observer) {
    observers.add(observer);

  }

  @Override
  public void removeGameStateChangeObserver(GameStateChangeObserver observer) {
    observers.remove(observer);

  }

  @Override
  public void notifyGameStateChangeObservers() {
    for (GameStateChangeObserver observer : observers) {
      observer.gameStateChangeUpdate();
    }
  }
}

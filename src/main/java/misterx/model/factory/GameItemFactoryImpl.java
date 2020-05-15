package misterx.model.factory;

import misterx.model.gameitems.Character;
import misterx.model.gameitems.*;
import misterx.model.gameitems.decorators.CachedCity;
import misterx.model.gameitems.enums.ConnectionType;
import misterx.model.gameitems.enums.DetectiveType;
import misterx.model.gameitems.impl.*;

import java.awt.*;


public class GameItemFactoryImpl implements GameItemFactory {

  private static GameItemFactory instance;

  private GameItemFactoryImpl() {
  }

  public static GameItemFactory getInstance() {
    if (instance == null) {
      instance = new GameItemFactoryImpl();
    }
    return instance;
  }

  @Override
  public Map createMap() {
    return new MapImpl();
  }

  @Override
  public City createCity(String name, Point position) {
    return new CachedCity(new CityImpl(name, position));
  }

  @Override
  public City createUnknownCity() {
    return new UnknownCityImpl();
  }

  @Override
  public Connection createConnection(City cityA, City cityB, ConnectionType type) {
    return new ConnectionImpl(cityA, cityB, type);
  }

  @Override
  public MisterX createMisterX() {
    return new MisterXImpl();
  }

  @Override
  public Detective createDetective(DetectiveType type) {
    return new DetectiveImpl(type);
  }

  @Override
  public Character createUnknownCharacter() {
    return new UnknownCharacterImpl();
  }

}

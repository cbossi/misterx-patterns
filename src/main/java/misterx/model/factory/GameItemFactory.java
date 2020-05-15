package misterx.model.factory;

import misterx.model.gameitems.Character;
import misterx.model.gameitems.*;
import misterx.model.gameitems.enums.ConnectionType;
import misterx.model.gameitems.enums.DetectiveType;

import java.awt.*;


public interface GameItemFactory {

  public Map createMap();

  public City createCity(String name, Point position);

  public City createUnknownCity();

  public Connection createConnection(City cityA, City cityB, ConnectionType type);

  public MisterX createMisterX();

  public Detective createDetective(DetectiveType type);

  public Character createUnknownCharacter();

}

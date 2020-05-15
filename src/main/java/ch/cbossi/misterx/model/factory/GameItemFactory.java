package ch.cbossi.misterx.model.factory;

import ch.cbossi.misterx.model.gameitems.Character;
import ch.cbossi.misterx.model.gameitems.*;
import ch.cbossi.misterx.model.gameitems.enums.ConnectionType;
import ch.cbossi.misterx.model.gameitems.enums.DetectiveType;

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

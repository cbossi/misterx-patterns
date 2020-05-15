package misterx.model.game.states;

import misterx.model.gameitems.Character;
import misterx.model.gameitems.City;
import misterx.model.gameitems.Detective;
import misterx.model.gameitems.MisterX;
import misterx.model.mapparser.MapDataParser;

import java.io.Serializable;


public interface GameState extends Serializable {

  public void fillMap(MapDataParser mapDataParser);

  public void addMisterX(MisterX misterX);

  public void addDetective(Detective detective);

  public void setStartPosition(Character character, City startPosition);

  public void startGame();

  public void moveMisterXTo(City destinationCity);

  public void moveDetectiveTo(Detective detective, City destinationCity);

  public void checkSituation();
}

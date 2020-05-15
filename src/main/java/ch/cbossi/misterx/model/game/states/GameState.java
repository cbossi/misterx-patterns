package ch.cbossi.misterx.model.game.states;

import ch.cbossi.misterx.model.gameitems.Character;
import ch.cbossi.misterx.model.gameitems.City;
import ch.cbossi.misterx.model.gameitems.Detective;
import ch.cbossi.misterx.model.gameitems.MisterX;
import ch.cbossi.misterx.model.mapparser.MapDataParser;

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

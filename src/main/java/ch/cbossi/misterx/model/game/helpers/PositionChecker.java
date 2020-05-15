package ch.cbossi.misterx.model.game.helpers;

import ch.cbossi.misterx.model.gameitems.Character;
import ch.cbossi.misterx.model.gameitems.City;
import ch.cbossi.misterx.model.gameitems.Detective;


public class PositionChecker extends AbstractHelper {

  public boolean canCharacterMoveToCity(Character character, City destinationCity) {
    return !isCityOccupiedByDetective(destinationCity) && !character.getCurrentPosition().equals(destinationCity);
  }

  public boolean isCityOccupiedByCharacter(City city) {
    return isCityOccupiedByMisterX(city) || isCityOccupiedByDetective(city);
  }

  public boolean isCityOccupiedByMisterX(City city) {
    return isCharacterOnCity(getMisterX(), city);
  }

  public boolean isCityOccupiedByDetective(City city) {
    for (Detective detective : getDetectives()) {
      if (isCharacterOnCity(detective, city)) {
        return true;
      }
    }
    return false;
  }

  private boolean isCharacterOnCity(Character character, City city) {
    return character.getCurrentPosition().equals(city);
  }

  public boolean isMisterXFound() {
    for (Detective detective : getDetectives()) {
      if (hasDetectiveFoundMisterX(detective)) {
        return true;
      }
    }
    return false;
  }

  private boolean hasDetectiveFoundMisterX(Detective detective) {
    return detective.getCurrentPosition().equals(getMisterX().getCurrentPosition());
  }

  public Detective detectiveThatFoundMisterX() {
    return null; //Im Detective-Type Enum einen default, der hier zurückgegeben wird, wenn mister x noch nicht gefunden
  }
}

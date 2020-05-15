package ch.cbossi.misterx.model.commands;

import ch.cbossi.misterx.model.gameitems.Character;
import ch.cbossi.misterx.model.gameitems.City;
import ch.cbossi.misterx.model.gameitems.Detective;

public class MoveCharacterGameCommand extends AbstractGameCommand {

  Character character;
  City destinationCity;

  public MoveCharacterGameCommand(Character character, City destinationCity) {
    this.character = character;
    this.destinationCity = destinationCity;
  }

  @Override
  public void execute() {
    if (isCharacterMisterX(character)) {
      getGame().moveMisterXTo(destinationCity);
    } else {
      getGame().moveDetectiveTo((Detective) character, destinationCity);
    }

  }

  private boolean isCharacterMisterX(Character character) {
    return getGame().getMisterX().equals(character);
  }

}

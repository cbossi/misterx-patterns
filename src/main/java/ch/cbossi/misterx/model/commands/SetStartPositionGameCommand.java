package ch.cbossi.misterx.model.commands;

import ch.cbossi.misterx.model.gameitems.Character;
import ch.cbossi.misterx.model.gameitems.City;

public class SetStartPositionGameCommand extends AbstractGameCommand {

  Character character;
  City startPosition;

  public SetStartPositionGameCommand(Character character, City startPosition) {
    this.character = character;
    this.startPosition = startPosition;
  }

  @Override
  public void execute() {
    getGame().setStartPosition(character, startPosition);

  }

}

package ch.cbossi.misterx.model.game.states;

import ch.cbossi.misterx.model.gameitems.Character;
import ch.cbossi.misterx.model.gameitems.City;

public class MisterXMovementGameState extends AbstractMovementGameState {

  private static final long serialVersionUID = 688665260510969095L;

  @Override
  public void moveMisterXTo(City destinationCity) {
    moveCharacterAction(getGame().getMisterX(), destinationCity);
  }

  @Override
  public void characterMovementPostAction(Character character) {
    changeGameState(new DetectivesMovementGameState());
  }

}

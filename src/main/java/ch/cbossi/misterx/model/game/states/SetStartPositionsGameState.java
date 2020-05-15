package ch.cbossi.misterx.model.game.states;

import ch.cbossi.misterx.model.gameitems.Character;
import ch.cbossi.misterx.model.gameitems.City;
import ch.cbossi.misterx.model.gameitems.collections.GameItemList;
import ch.cbossi.misterx.model.gameitems.impl.collections.GameItemListImpl;

public class SetStartPositionsGameState extends AbstractGameState {

  private static final long serialVersionUID = 1944245018639366192L;
  GameItemList<Character> charactersThatAlreadySetStartPosition;

  public SetStartPositionsGameState() {
    charactersThatAlreadySetStartPosition = new GameItemListImpl<Character>();
  }

  @Override
  public void setStartPosition(Character character, City startPosition) {
    if (!characterHasAlreadySetStartPosition(character)) {
      character.setCurrentPosition(startPosition);
      charactersThatAlreadySetStartPosition.add(character);
    }
    if (allCharactersHaveSetStartPosition()) {
      changeGameState(new MisterXMovementGameState());
    }
  }

  private boolean characterHasAlreadySetStartPosition(Character character) {
    for (Character alreadySetCharacter : charactersThatAlreadySetStartPosition) {
      if (alreadySetCharacter.equals(character)) {
        return true;
      }
    }
    return false;
  }

  private boolean allCharactersHaveSetStartPosition() {
    return charactersThatAlreadySetStartPosition.size() == numberOfCharacters();
  }

  private int numberOfCharacters() {
    return getGame().getDetectives().size() + 1; // number of characters = all detectives + MisterX
  }

}

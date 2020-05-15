package ch.cbossi.misterx.model.game.states;

import ch.cbossi.misterx.model.game.Game;
import ch.cbossi.misterx.model.gameitems.Detective;
import ch.cbossi.misterx.model.gameitems.Map;
import ch.cbossi.misterx.model.gameitems.MisterX;
import ch.cbossi.misterx.model.gameitems.collections.GameItemList;
import ch.cbossi.misterx.model.mapparser.MapDataParser;

public class StartGameState extends AbstractGameState {

  private static final long serialVersionUID = -3040315833714803163L;
  private boolean misterXAlreadySet;

  public StartGameState(Game game) {
    misterXAlreadySet = false;
  }

  @Override
  public void fillMap(MapDataParser mapDataParser) {
    Map map = getGame().getMap();
    map.setMapDataParser(mapDataParser);
    map.fillMap();
  }

  @Override
  public void addMisterX(MisterX misterX) {
    if (!misterXAlreadySet) {
      getGame().setMisterX(misterX);
      misterXAlreadySet = true;
    }
  }

  @Override
  public void addDetective(Detective detective) {
    GameItemList<Detective> detectives = getGame().getDetectives();
    if (detectives.size() < Game.MAX_NUMBER_OF_DETECTIVES) {
      detectives.add(detective);
    }
  }

  @Override
  public void startGame() {
    if (getGame().isReady()) {
      getGame().increaseRound();
      changeGameState(new SetStartPositionsGameState());
    }
  }

}

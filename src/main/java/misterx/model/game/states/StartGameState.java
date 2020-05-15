package misterx.model.game.states;

import misterx.model.game.Game;
import misterx.model.gameitems.Detective;
import misterx.model.gameitems.Map;
import misterx.model.gameitems.MisterX;
import misterx.model.gameitems.collections.GameItemList;
import misterx.model.mapparser.MapDataParser;

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

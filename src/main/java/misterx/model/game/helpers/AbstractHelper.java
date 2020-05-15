package misterx.model.game.helpers;

import misterx.model.game.Game;
import misterx.model.game.GameImpl;
import misterx.model.gameitems.Connection;
import misterx.model.gameitems.Detective;
import misterx.model.gameitems.Map;
import misterx.model.gameitems.MisterX;
import misterx.model.gameitems.collections.GameItemList;

public class AbstractHelper implements Helper {

  @Override
  public Game getGame() {
    return GameImpl.getInstance();
  }

  @Override
  public Map getMap() {
    return getGame().getMap();
  }

  @Override
  public GameItemList<Connection> getConnections() {
    return getGame().getConnections();
  }

  @Override
  public MisterX getMisterX() {
    return getGame().getMisterX();
  }

  @Override
  public GameItemList<Detective> getDetectives() {
    return getGame().getDetectives();
  }


}

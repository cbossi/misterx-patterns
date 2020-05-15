package misterx.model.game.helpers;

import misterx.model.game.Game;
import misterx.model.gameitems.Connection;
import misterx.model.gameitems.Detective;
import misterx.model.gameitems.Map;
import misterx.model.gameitems.MisterX;
import misterx.model.gameitems.collections.GameItemList;

public interface Helper {

  public Game getGame();

  public Map getMap();

  public GameItemList<Connection> getConnections();

  public MisterX getMisterX();

  public GameItemList<Detective> getDetectives();

}

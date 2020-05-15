package ch.cbossi.misterx.model.game.helpers;

import ch.cbossi.misterx.model.game.Game;
import ch.cbossi.misterx.model.gameitems.Connection;
import ch.cbossi.misterx.model.gameitems.Detective;
import ch.cbossi.misterx.model.gameitems.Map;
import ch.cbossi.misterx.model.gameitems.MisterX;
import ch.cbossi.misterx.model.gameitems.collections.GameItemList;

public interface Helper {

  public Game getGame();

  public Map getMap();

  public GameItemList<Connection> getConnections();

  public MisterX getMisterX();

  public GameItemList<Detective> getDetectives();

}

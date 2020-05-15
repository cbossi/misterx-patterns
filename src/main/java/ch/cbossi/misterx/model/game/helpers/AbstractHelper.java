package ch.cbossi.misterx.model.game.helpers;

import ch.cbossi.misterx.model.game.Game;
import ch.cbossi.misterx.model.game.GameImpl;
import ch.cbossi.misterx.model.gameitems.Connection;
import ch.cbossi.misterx.model.gameitems.Detective;
import ch.cbossi.misterx.model.gameitems.Map;
import ch.cbossi.misterx.model.gameitems.MisterX;
import ch.cbossi.misterx.model.gameitems.collections.GameItemList;

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

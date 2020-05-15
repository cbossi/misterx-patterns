package ch.cbossi.misterx.model.gameitems.decorators;

import ch.cbossi.misterx.model.gameitems.City;
import ch.cbossi.misterx.model.gameitems.Connection;
import ch.cbossi.misterx.model.observers.GameItemObserver;

import java.util.List;


public class CachedCity extends AbstractCityDecorator implements GameItemObserver {

  private static final long serialVersionUID = -3645095023467610355L;

  private List<Connection> cachedConnections;
  private boolean isConnectionCacheValid;

  public CachedCity(City city) {
    super(city);
    isConnectionCacheValid = false;
    getGame().getConnections().addGameItemObserver(this);
  }

  @Override
  public List<Connection> getConnections() {
    if (!isConnectionCacheValid()) {
      cachedConnections = super.getConnections();
      isConnectionCacheValid = true;
    }
    return cachedConnections;
  }

  private boolean isConnectionCacheValid() {
    return isConnectionCacheValid;
  }

  @Override
  public void gameItemUpdate() {
    isConnectionCacheValid = false;
  }
}

package misterx.model.gameitems;

import misterx.model.gameitems.enums.ConnectionType;

public interface Connection extends GameItem {

  public City getCityA();

  public City getCityB();

  public ConnectionType getConnectionType();
}

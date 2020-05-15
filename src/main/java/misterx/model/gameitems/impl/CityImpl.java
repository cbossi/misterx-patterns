package misterx.model.gameitems.impl;

import misterx.model.gameitems.City;
import misterx.model.gameitems.Connection;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;


public class CityImpl extends AbstractGameItemImpl implements City {

  private static final long serialVersionUID = 4472170963074184150L;

  private final String name;
  private final Point point;

  public CityImpl(String name, Point point) {
    super();
    this.name = name;
    this.point = point;
  }

  @Override
  public String getName() {
    return name;
  }

  @Override
  public Point getPosition() {
    return point;
  }

  @Override
  public List<Connection> getConnections() {
    List<Connection> relevantConnections = new ArrayList<Connection>();
    for (Connection connection : getGame().getConnections()) {
      if (isRelevantConnection(connection)) {
        relevantConnections.add(connection);
      }
    }
    return relevantConnections;
  }

  public boolean isRelevantConnection(Connection connection) {
    return connection.getCityA().equals(this)
        || connection.getCityB().equals(this);
  }

  @Override
  public boolean equals(Object obj) {
    return getName().equals(((City) obj).getName());
  }

  @Override
  public String toString() {
    return getName();
  }
}

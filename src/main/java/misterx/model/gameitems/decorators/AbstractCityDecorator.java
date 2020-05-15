package misterx.model.gameitems.decorators;

import misterx.model.gameitems.City;
import misterx.model.gameitems.Connection;
import misterx.model.gameitems.impl.AbstractGameItemImpl;

import java.awt.*;
import java.util.List;


public abstract class AbstractCityDecorator extends AbstractGameItemImpl implements City {

  private static final long serialVersionUID = 1L;

  private City city;

  public AbstractCityDecorator(City city) {
    this.city = city;
  }

  @Override
  public String getName() {
    return city.getName();
  }

  @Override
  public Point getPosition() {
    return city.getPosition();
  }

  @Override
  public List<Connection> getConnections() {
    return city.getConnections();
  }

  @Override
  public boolean equals(Object obj) {
    return city.equals(obj);
  }

  public String toString() {
    return city.toString();
  }

}

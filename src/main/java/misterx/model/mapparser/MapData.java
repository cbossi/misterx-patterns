package misterx.model.mapparser;

import misterx.model.gameitems.City;
import misterx.model.gameitems.Connection;

import java.util.List;


public class MapData {

  public List<City> cities;
  public List<Connection> connections;

  public MapData() {
  }

  public MapData(List<City> cities, List<Connection> connections) {
    this.cities = cities;
    this.connections = connections;
  }
}

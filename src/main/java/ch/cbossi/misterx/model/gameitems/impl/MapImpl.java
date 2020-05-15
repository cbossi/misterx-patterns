package ch.cbossi.misterx.model.gameitems.impl;

import ch.cbossi.misterx.model.factory.GameItemFactoryImpl;
import ch.cbossi.misterx.model.gameitems.City;
import ch.cbossi.misterx.model.gameitems.Connection;
import ch.cbossi.misterx.model.gameitems.Map;
import ch.cbossi.misterx.model.gameitems.collections.GameItemList;
import ch.cbossi.misterx.model.gameitems.impl.collections.GameItemListImpl;
import ch.cbossi.misterx.model.mapparser.MapData;
import ch.cbossi.misterx.model.mapparser.MapDataParser;

public class MapImpl extends AbstractGameItemImpl implements Map {

  private static final long serialVersionUID = -8335172368629528076L;

  private static final int MIN_NUMBER_OF_CITIES = 2;
  private static final int MIN_NUMBER_OF_CONNECTIONS = 1;

  private GameItemListImpl<Connection> connections;
  private GameItemList<City> cities;
  private MapDataParser mapDataParser;

  public MapImpl() {
    super();
    this.connections = new GameItemListImpl<Connection>();
    this.cities = new GameItemListImpl<City>();
  }

  @Override
  public void setMapDataParser(MapDataParser mapDataParser) {
    this.mapDataParser = mapDataParser;
  }

  @Override
  public void fillMap() {
    MapData mapData = mapDataParser.getMapData();
    cities.addAll(mapData.cities);
    connections.addAll(mapData.connections);
    notifyGameItemObservers();
  }

  public boolean isFilled() {
    return cities.size() >= MIN_NUMBER_OF_CITIES && connections.size() >= MIN_NUMBER_OF_CONNECTIONS;
  }

  @Override
  public GameItemList<Connection> getConnections() {
    return this.connections;
  }

  @Override
  public GameItemList<City> getCities() {
    return cities;
  }

  @Override
  public City getCityByName(String name) {
    for (City city : getCities()) {
      if (city.getName().equals(name)) {
        return city;
      }
    }
    return GameItemFactoryImpl.getInstance().createUnknownCity();
  }

  @Override
  public String toString() {
    return "Map [Cities: " + cities + ", Connections: " + connections + "]";
  }
}

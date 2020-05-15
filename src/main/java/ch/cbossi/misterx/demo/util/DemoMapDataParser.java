package ch.cbossi.misterx.demo.util;

import ch.cbossi.misterx.model.factory.GameItemFactory;
import ch.cbossi.misterx.model.factory.GameItemFactoryImpl;
import ch.cbossi.misterx.model.gameitems.City;
import ch.cbossi.misterx.model.gameitems.Connection;
import ch.cbossi.misterx.model.gameitems.enums.ConnectionType;
import ch.cbossi.misterx.model.mapparser.MapData;
import ch.cbossi.misterx.model.mapparser.MapDataParser;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;


public class DemoMapDataParser implements MapDataParser {

  @Override
  public MapData getMapData() {
    List<City> cities = new ArrayList<City>();
    List<Connection> connections = new ArrayList<Connection>();

    GameItemFactory factory = GameItemFactoryImpl.getInstance();

    City basel = factory.createCity("Basel", new Point(3, 1));
    City zuerich = factory.createCity("Zuerich", new Point(5, 2));
    City bern = factory.createCity("Bern", new Point(3, 3));
    City luzern = factory.createCity("Luzern", new Point(4, 4));
    City lausanne = factory.createCity("Lausanne", new Point(2, 5));
    City chur = factory.createCity("Chur", new Point(6, 5));
    City genf = factory.createCity("Genf", new Point(1, 6));
    cities.add(zuerich);
    cities.add(basel);
    cities.add(bern);
    cities.add(luzern);
    cities.add(lausanne);
    cities.add(chur);
    cities.add(genf);

    connections.add(factory.createConnection(genf, basel, ConnectionType.PLANE));
    connections.add(factory.createConnection(genf, lausanne, ConnectionType.TRAIN));
    connections.add(factory.createConnection(lausanne, bern, ConnectionType.TRAIN));
    connections.add(factory.createConnection(lausanne, luzern, ConnectionType.CAR));
    connections.add(factory.createConnection(bern, basel, ConnectionType.TRAIN));
    connections.add(factory.createConnection(bern, luzern, ConnectionType.CAR));
    connections.add(factory.createConnection(bern, zuerich, ConnectionType.TRAIN));
    connections.add(factory.createConnection(zuerich, basel, ConnectionType.PLANE));
    connections.add(factory.createConnection(zuerich, luzern, ConnectionType.TRAIN));
    connections.add(factory.createConnection(zuerich, chur, ConnectionType.TRAIN));
    connections.add(factory.createConnection(chur, luzern, ConnectionType.CAR));

    return new MapData(cities, connections);
  }

}

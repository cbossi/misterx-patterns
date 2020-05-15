package misterx.model.gameitems;

import java.awt.*;
import java.util.List;

public interface City extends GameItem {

  public String getName();

  public Point getPosition();

  public List<Connection> getConnections();

}

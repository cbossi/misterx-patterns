package ch.cbossi.misterx.model.gameitems;


public interface Character extends GameItem {

  public City getCurrentPosition();

  public void setCurrentPosition(City currentPosition);

}

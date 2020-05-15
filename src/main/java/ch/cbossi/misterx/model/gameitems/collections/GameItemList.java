package ch.cbossi.misterx.model.gameitems.collections;

import ch.cbossi.misterx.model.gameitems.GameItem;

import java.util.Collection;
import java.util.Iterator;


public interface GameItemList<E extends GameItem> extends GameItem, Iterable<E> {

  public boolean add(E gameItem);

  public boolean addAll(Collection<E> gameItemCollection);

  public boolean remove(E gameItem);

  public int size();

  public Iterator<E> iterator();

}

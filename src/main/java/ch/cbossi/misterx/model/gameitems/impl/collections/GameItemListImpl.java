package ch.cbossi.misterx.model.gameitems.impl.collections;

import ch.cbossi.misterx.model.gameitems.GameItem;
import ch.cbossi.misterx.model.gameitems.collections.GameItemList;
import ch.cbossi.misterx.model.gameitems.collections.GameItemListIterator;
import ch.cbossi.misterx.model.gameitems.impl.AbstractGameItemImpl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;


public class GameItemListImpl<E extends GameItem> extends AbstractGameItemImpl implements GameItemList<E> {

  private static final long serialVersionUID = 1878249974430048843L;

  private final List<E> gameItems;

  public GameItemListImpl() {
    this.gameItems = new ArrayList<E>();
  }

  @Override
  public boolean add(E gameItem) {
    return notifyIfNecessary(gameItems.add(gameItem));
  }

  @Override
  public boolean addAll(Collection<E> gameItemCollection) {
    return notifyIfNecessary(gameItems.addAll(gameItemCollection));
  }

  @Override
  public boolean remove(E gameItem) {
    return notifyIfNecessary(gameItems.remove(gameItem));
  }

  private boolean notifyIfNecessary(boolean succeed) {
    if (succeed) {
      notifyGameItemObservers();
    }
    return succeed;
  }

  @Override
  public int size() {
    return gameItems.size();
  }

  @Override
  public Iterator<E> iterator() {
    return new GameItemListIterator<E>(gameItems);
  }

  @Override
  public String toString() {
    String content = "";
    for (E gameItem : this) {
      content += gameItem.toString() + ", ";
    }
    content = removeTerminalCommaAndWhitespace(content);
    return "[" + content + "]";
  }

  private String removeTerminalCommaAndWhitespace(String input) {
    int lastComma = input.lastIndexOf(",");
    return input.substring(0, lastComma);
  }

}

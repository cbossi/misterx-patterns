package ch.cbossi.misterx.demo.gui;

import ch.cbossi.misterx.model.game.Game;
import ch.cbossi.misterx.model.game.GameImpl;

public class GuiDemo {

  public static void main(String[] args) {

    Game game = GameImpl.getInstance();
    new DemoGameController(game);
  }

}

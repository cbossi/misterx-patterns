package misterx.demo.gui;

import misterx.model.game.Game;
import misterx.model.game.GameImpl;

public class GuiDemo {

  public static void main(String[] args) {

    Game game = GameImpl.getInstance();
    new DemoGameController(game);
  }

}

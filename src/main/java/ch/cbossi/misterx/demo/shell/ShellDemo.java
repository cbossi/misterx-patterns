package ch.cbossi.misterx.demo.shell;

import ch.cbossi.misterx.demo.util.DemoMapDataParser;
import ch.cbossi.misterx.demo.util.GameCycleSimplifier;
import ch.cbossi.misterx.model.factory.GameItemFactory;
import ch.cbossi.misterx.model.factory.GameItemFactoryImpl;
import ch.cbossi.misterx.model.game.Game;
import ch.cbossi.misterx.model.game.GameImpl;
import ch.cbossi.misterx.model.gameitems.Detective;
import ch.cbossi.misterx.model.gameitems.MisterX;
import ch.cbossi.misterx.model.gameitems.enums.DetectiveType;

public class ShellDemo {

  private GameCycleSimplifier gameCycleSimplifier;

  public static void main(String[] args) {
    ShellDemo shellDemo = new ShellDemo();
    shellDemo.createAndStartGame();
    shellDemo.play();
  }

  public void createAndStartGame() {
    GameItemFactory factory = GameItemFactoryImpl.getInstance();
    MisterX misterX = factory.createMisterX();
    Detective blueDetective = factory.createDetective(DetectiveType.BLUE);
    Detective greenDetective = factory.createDetective(DetectiveType.GREEN);

    Game game = GameImpl.getInstance();

    gameCycleSimplifier = new GameCycleSimplifier(game, misterX, blueDetective, greenDetective);
    gameCycleSimplifier.createAndStartGame(new DemoMapDataParser());
  }

  private void play() {
    printGameInfo();

    printAction("Set Start Positions");
    gameCycleSimplifier.setStartPositions("Luzern", "Chur", "Basel");
    printGameInfo();

    printAction("Play Round 1");
    gameCycleSimplifier.playRound("Bern", "Zürich", "Genf");
    printGameInfo();

    printAction("Play Round 2");
    gameCycleSimplifier.playRound("Lausanne", "Bern", "Lausanne");
    printGameInfo();

  }

  private void printAction(String action) {
    System.out.println("=====" + action + "=====\n");
  }

  private void printGameInfo() {
    Game game = GameImpl.getInstance();
    System.out.println("GameState: " + game.getCurrentGameState());
    System.out.println("MisterX: " + game.getMisterX().getCurrentPosition());
    for (Detective detective : game.getDetectives()) {
      System.out.println(detective + ": " + detective.getCurrentPosition());
    }
    System.out.println("Winner: " + game.getWinner() + "\n\n");
  }

}

package ch.cbossi.misterx.demo.gui;

import ch.cbossi.misterx.demo.commands.PlayRoundGameCommand;
import ch.cbossi.misterx.demo.commands.SetAllStartPositionsGameCommand;
import ch.cbossi.misterx.demo.util.DemoMapDataParser;
import ch.cbossi.misterx.demo.util.GameCycleSimplifier;
import ch.cbossi.misterx.model.commands.DefaultGameCommand;
import ch.cbossi.misterx.model.commands.GameCommand;
import ch.cbossi.misterx.model.commands.MoveCharacterGameCommand;
import ch.cbossi.misterx.model.factory.GameItemFactory;
import ch.cbossi.misterx.model.factory.GameItemFactoryImpl;
import ch.cbossi.misterx.model.game.Game;
import ch.cbossi.misterx.model.gameitems.Detective;
import ch.cbossi.misterx.model.gameitems.MisterX;
import ch.cbossi.misterx.model.gameitems.enums.DetectiveType;

import java.util.LinkedList;
import java.util.Queue;


public class DemoGameController {

  private final DemoGameView gameView;
  private GameCycleSimplifier gameCycleSimplifier;
  private Queue<GameCommand> demoCommands;
  private Game game;

  public DemoGameController(Game game) {
    this.game = game;
    this.gameView = new DemoGameView(game, this);
    this.demoCommands = new LinkedList<GameCommand>();
    onLoadAction();
    createView();

  }

  private void onLoadAction() {
    GameItemFactory factory = GameItemFactoryImpl.getInstance();
    MisterX misterX = factory.createMisterX();
    Detective blueDetective = factory.createDetective(DetectiveType.BLUE);
    Detective greenDetective = factory.createDetective(DetectiveType.GREEN);

    gameCycleSimplifier = new GameCycleSimplifier(game, misterX, blueDetective, greenDetective);
    gameCycleSimplifier.createAndStartGame(new DemoMapDataParser());

    fillDemoCommandList();
  }

  private void fillDemoCommandList() {
    demoCommands.add(new SetAllStartPositionsGameCommand(gameCycleSimplifier, "Luzern", "Chur", "Basel"));

    demoCommands.add(new MoveCharacterGameCommand(game.getMisterX(), game.getMap().getCityByName("Bern")));
    demoCommands.add(new MoveCharacterGameCommand(game.getDetective(DetectiveType.BLUE), game.getMap().getCityByName("Zuerich")));
    demoCommands.add(new MoveCharacterGameCommand(game.getDetective(DetectiveType.GREEN), game.getMap().getCityByName("Genf")));

    demoCommands.add(new PlayRoundGameCommand(gameCycleSimplifier, "Lausanne", "Bern", "Lausanne"));
  }

  private void createView() {
    gameView.createView();
  }

  public void performActionButtonAction() {
    fetchNextDemoCommand().execute();
  }

  private GameCommand fetchNextDemoCommand() {
    if (demoCommands.isEmpty()) {
      return new DefaultGameCommand();
    }
    return demoCommands.poll();
  }
}
